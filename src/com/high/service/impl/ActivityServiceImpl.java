package com.high.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.high.entity.Activity;
import com.high.entity.SearchActivityQueryModel;
import com.high.entity.SearchActivityResultModel;
import com.high.mapper.ActivityMapper;
import com.high.service.ActivityService;
import com.high.service.LocationService;
import com.high.utils.TimeUtils;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	private ActivityMapper activityMapper;
	@Autowired
	private LocationService locationService; 
	@Autowired
	private HttpSolrServer server;
//	private HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr");
	@Override
	public void createActivity(Activity activity) {
		// TODO 实现创建 活动的 功能
		
		//判断必要的域是否为空，并进行数据校验
		
		//从session中取出 用户信息
		
		//插入活动地址，并获得地址id
		locationService.insertLocation(activity.getActivityLocation());
		activity.setActivityLocationId(activity.getActivityLocation().getLocationId());
		//是否有距离限制，若有则获得用户当前位置，并插入数据库，且获得id
		if(activity.getDistance() != null && activity.getDistance() >0){
			locationService.insertLocation(activity.getCreatorLocation());
			activity.setCreatorLocationId(activity.getCreatorLocation().getLocationId());
		}
		//将活动添加到数据库，并获得id，返回
		activity.setActivityId(UUID.randomUUID().toString());
		activityMapper.insertActivity(activity);
	}

	@Override
	public SearchActivityResultModel searchActivity(SearchActivityQueryModel queryModel) {
		// TODO Auto-generated method stub
		SolrQuery query = new SolrQuery();
		//如果输入了搜索条件，则搜索，否则搜索全部
		if(StringUtils.isNotEmpty(queryModel.getQuery())){
			query.setQuery(queryModel.getQuery());
		}else{
			query.setQuery("*:*");
		}
		if(StringUtils.isNotEmpty(queryModel.getTopCategory())){
			query.addFilterQuery("activity_top_category:"+queryModel.getTopCategory());
		}
		if(StringUtils.isNotEmpty(queryModel.getSecCategory())){
			query.addFilterQuery("activity_secondary_category:"+queryModel.getSecCategory());
		}
		if(queryModel.getActivityLocation()!=null){
			// TODO 根据位置进行索引
			/**
			 * 
			 * 根据位置进行索引
			 * 
			 */
			
		}
		if(queryModel.getStartTime() != null){
			// TODO 这块的逻辑是什么？？？过滤时输入的是什么 时间？？？又需要查询些什么？？？
			// 并将本地时间改为 MTS时间
			query.addFilterQuery("activity_start_time: ["+TimeUtils.formatTimeForSolr(queryModel.getStartTime())+" TO *]" );
			
		}
		if(queryModel.getPage() ==null){
			queryModel.setPage(1);
		}
		query.setStart((queryModel.getPage()-1)*SearchActivityQueryModel.NUM_ACTIVITY_PER_PAGE);
		query.setRows(SearchActivityQueryModel.NUM_ACTIVITY_PER_PAGE);
		//设置默认域
		query.set("df", "activity_keyword");
		//设置高亮
		query.setHighlight(true);
		query.setHighlightSimplePre("<font style='color:red'>");
		query.setHighlightSimplePost("</font>");
		
		try {
			QueryResponse response = server.query(query);
			SolrDocumentList results = response.getResults();
			long count = results.getNumFound();
			List<Activity> activitys = new LinkedList<Activity>();
			Activity activity = null;
			for(SolrDocument doc : results){
				activity = new Activity();
				
				activity.setActivityId(doc.get("id").toString());
				activity.setComment(doc.get("activity_comment").toString());
				activity.setContent(doc.get("activity_content").toString());
				//TODO 将取出的时间转换格式
//				activity.setStartTime();
				
				activitys.add(activity);
			}
			SearchActivityResultModel resultModel = new SearchActivityResultModel();
			resultModel.setActivityList(activitys);
			resultModel.setCurPage(queryModel.getPage());
			resultModel.setRecordCount(count);
			resultModel.setPageCount((int) ((count+ SearchActivityQueryModel.NUM_ACTIVITY_PER_PAGE-1)/SearchActivityQueryModel.NUM_ACTIVITY_PER_PAGE));
			return resultModel;
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
