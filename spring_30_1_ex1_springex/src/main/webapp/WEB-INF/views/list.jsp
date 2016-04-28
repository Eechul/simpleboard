<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="js/board.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
	<p>
		총 게시글 수 : ${list.size() }
	</p>
	<tr>
		<td>글번호</td>
		<td>작성자</td>
		<td>제목</td>
		<td>게시날짜</td>
		<td>조회수</td>
	<tr>
	<c:forEach items="${list}" var="dto">
	<tr>
		<td>${dto.bId}</td>
		<td>${dto.bName}</td>
		<td><a href="content_view?bId=${dto.bId}">${dto.bTitle}</a></td>
		<td>${dto.bDate}</td>
		<td>${dto.bHit}</td>
	<tr>
	</c:forEach>
</table>
	<span> <a href="write_view">글작성</a></span>
	<span>
		<form action="search" method="get">
			<input type="radio" name="searchType" value="bTitle">제목
			<input type="radio" name="searchType" value="bContent">내용
			<input type="radio" name="searchType" value="bName">작성자
			<input type="text" name="bSearch" placeholder="검색하기">
			<input type="submit" value="검색"/> 
		</form>
		</span>

</body>
</html>