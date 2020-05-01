<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황제윤 수행평가</title>
<link rel="stylesheet" type="text/css"
	href="/bigdataShop/common/css/jqcloud.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="/bigdataShop/common/js/jqcloud-1.0.4.js"></script>
<script type="text/javascript">
	/*!
	 * Create an array of word objects, each representing a word in the cloud
	 */
	var word_array = new Array();
	
	<c:if test="${!empty comment_result}">
		<c:forEach var="result_data" items="${comment_result}">
			var data = new Object();
			data.text =	"${result_data.keyword}"
			data.weight ="${result_data.count}"
			word_array.push(data);
		</c:forEach>
	</c:if>


	$(function() {
		// When DOM is ready, select the container element and call the jQCloud method, passing the array of words as the first argument.
		$("#example").jQCloud(word_array);
	});
</script>
<style type="text/css">
.tableSetting {
	
}
</style>
</head>
<body>
	<h1>상품댓글분석</h1>
	<hr />

	<div class="container" style="">
		<table class="table" style="width: 50%">
			<thead>
				<tr>
					<th scope="col">키워드</th>
					<th scope="col">반복횟수</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty comment_result}">
					<c:forEach var="result_data" items="${comment_result}">
						<tr>
							<td>${result_data.keyword}</td>
							<td>${result_data.count}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div id="example" style="width: 650px; height: 350px;"></div>
	</div>
</body>
</html>
