<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:scriptlet>pageContext.setAttribute("newline","\n");</jsp:scriptlet>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify" method="post">
			<input type="hidden" name="bId" value="${modify_view.bId}">
			<tr>
				<td> 글번호 </td>
				<td> ${modify_view.bId} </td>
			</tr>
			<tr>
				<td> 작성자 </td>
				<td> <input type="text" name="bName" value ="${modify_view.bName}"size = "50"></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="bTitle" value ="${modify_view.bTitle}"size = "50"> </td>
			</tr>
			<tr>
				<td colspan="2"> 
					<textarea name="bContent" rows="10" cols="40">${fn:replace(modify_view.bContent,'<br/>', newline)}</textarea> 
				</td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="완료"> &nbsp;&nbsp; <a href="list">목록보기</a></td>
			</tr>
		</form>
	</table>
	
</body>
</html>