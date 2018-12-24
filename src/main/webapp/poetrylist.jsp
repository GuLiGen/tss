<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>

<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
</head>
<body>
<span style="color: #808080;font-size: 10px">
	为您找到相关结果为${sessionScope.count}条
</span>
<div>
	<c:forEach items="${sessionScope.list}" var="list">

		<div style="border: 1px #164616 solid">
			<span style="color:black">${list.title}</span><br>
			<span style="font-size: 15px">--${list.poet.name}</span><br>
			<span>&nbsp;&nbsp;&nbsp;&nbsp;${list.content}</span>
			<hr>
		</div>

	</c:forEach>
	<div style="text-align: center;">

		<a href="${pageContext.request.contextPath}/poetry/find?text=${sessionScope.text}&type=${sessionScope.type}&page=${sessionScope.page-1}&pageSize=${sessionScope.pageSize}"><input type="button" value="上一页"></a>
		<span>当前页: <input type="text" style="width: 25px" value="${sessionScope.page}"></span>  共  ${sessionScope.pages}页
		<a href="${pageContext.request.contextPath}/poetry/find?text=${sessionScope.text}&type=${sessionScope.type}&page=${sessionScope.page+1}&pageSize=${sessionScope.pageSize}"><input type="button" value="下一页"></a>
	</div>

	</div>

</body>
</html>