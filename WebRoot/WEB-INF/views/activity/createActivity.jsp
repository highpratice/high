<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建活动</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/jquery/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/laydate/laydate.js"></script>
<script>
	//页面加载完成，从后台获取顶级分类
	$(document).ready(function() {
		appendDataForTopCategory();
	});
	
	function appendDataForTopCategory() {
		$.ajax({
			type : "POST", //使用post方法访问后台  
			url : "${pageContext.request.contextPath}/category/findAllTopCategoryName.do", //要访问的后台地址  
			success : function(result) {//result为返回的数据  
				$("#selTopCat").append($("<option value=\"0\">－选择分类－</option>"));
				for (var i = 0; i < result.length; i++) {
					$("#selTopCat").append(
					$("<option value=\""+result[i]+"\">" + result[i] + "</option>"));
				}
			}
		});
	}
	var category;
	function loadSecCat(value){
		document.getElementById("selSecCat").options.length=0;		
		$.ajax({
			type : "POST", //使用post方法访问后台  
			url : "${pageContext.request.contextPath}/category/findAllSecCate.do", //要访问的后台地址  
			data : value,
			success : function(result) {//result为返回的数据  
				category=result;
				$("#selSecCat").append($("<option value=\"0\">－选择分类－</option>"));
				for (var i = 0; i < result.length; i++) {
					$("#selSecCat").append(
					$("<option value=\""+result[i].secondaryCategory+"\">" + result[i].secondaryCategory + "</option>"));
				}
			}
		});
	}
	function getCategoryId(id){
		$("#categotyId").val(category[id].id);
	}
	
	function checkData(){
// 		var a = $("#startTime");
// 		var time =a.val();
// 		alert(time);
		document.getElementById("startTime").value=$("#startTime").val();
		document.getElementById("endTime").value=$("#startTime").val();
// 		document.getElementById
	}
	
</script>
</head>
<body>
	<form
		action="${pageContext.request.contextPath }/activity/createActivity.do"
		method="post">
		<table>
			<tr>
				<!-- 页面加载之后 从后台 获取类别选项，onchange函数根据当前选择的值从后台获取次级分类 -->
				<td>活动类别</td>
				<td>
					<select name="category.topCategory" id="selTopCat" onchange="loadSecCat(this.options[this.options.selectedIndex].value)">
					</select>
				</td>
				<td>
				<!-- onchange 函数触发，给隐藏域 categotyId赋值-->
					<select name="category.secondaryCategory" id="selSecCat" onchange="getCategoryId(this.options[this.options.selectedIndex].index)">
						<option value="0">－选择分类－</option>
					</select>
				</td>
				<%
					//隐藏，利用js自动填充分类ID
				%>
				<td><input type="hidden" name="categotyId" id="categotyId"></td>
			</tr>
			<tr>
				<%
					//用户选择活动位置信息
				%>
				<td>活动位置</td>
				<td><input type="text" name="activityLocation.locationDescription">西电</td>
				<td><input type="text" name="activityLocation.longitude"></td>
				<td><input type="text" name="activityLocation.latitude"></td>
			</tr>
			<tr>
				<td>活动人数</td>
				<td><input type="text" placeholder="最少人数" name="minNum"></td>
				<td><input type="text" placeholder="最多人数" name="maxNum"></td>
				<td></td>
			</tr>
			<tr>
				<!-- 用户选择，再选择日期，然后利用给 startTime 赋值。 利用js的时间插件 -->
				<td>开始时间</td>
				<td><input id="startTime" name="startTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"></td>
<!-- 				<td><input type="text" ></td> -->
<!-- 				<td><input type="text" ></td> -->
<!-- 				<td><input type="hidden" name="startTime" ></td> -->
			</tr>
			<tr>
				<!-- 用户选择，再选择日期，然后利用给 startTime 赋值 -->
				<td>结束时间</td>
				<td><input name="endTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"></td>
<!-- 				<td><input type="text" placeholder="日期"></td> -->
<!-- 				<td><input type="text" placeholder="时间"></td> -->
<!-- 				<td><input type="hidden" name="endTime" ></td> -->
			</tr>
			<tr>
				<td colspan='3'><textarea rows="5" name="comment">备注</textarea></td>
			</tr>
			<tr>
			<!-- 触发 数据验证 -->
				<td><input type="submit" value="提交" onclick="checkData()" ></td>
			</tr>
		</table>
	</form>
</body>
</html>