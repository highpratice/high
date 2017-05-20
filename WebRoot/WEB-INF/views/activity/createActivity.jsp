<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建活动</title>
<script type="text/javascript">
	function appendDataForTopCategory(){
		$.each(data.list, function(key, val) {
            $.("#selTopCat").append('<option value="' + val.id + '">' + val.name + '</option>');
        });
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/activity/createActivity.do">
		<table>
			<tr><th>活动类别</th>
				<th><select name="category.topCategory" id="selTopCat"></select></th>
			</tr>
		</table>
		类别：<select>
		
		</select>
	</form>
</body>
</html>