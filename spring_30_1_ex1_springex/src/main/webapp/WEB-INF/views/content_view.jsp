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
<link rel="stylesheet" type="text/css" href="css/comment.css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify_view" method="post">
			<input type="hidden" name="bId" value="${content_view.bId}">
			<tr>
				<td> 글번호 </td>
				<td> ${content_view.bId} </td>
			</tr>
			<tr>
				<td> 조회수 </td>
				<td> ${content_view.bHit} </td>
			</tr>
			<tr>
				<td> 작성자 </td>
				<td> ${content_view.bName}</td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> ${content_view.bTitle}</td>
			</tr>
			<tr>
				<td colspan="2">
					<pre style="word-wrap: break-word;
						white-space: pre-wrap;
						white-space: -moz-pre-wrap;
						white-space: -pre-wrap;
						white-space: -o-pre-wrap;
						word-break:break-all;">${content_view.bContent}</pre>
				</td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="list">목록보기</a> &nbsp;&nbsp; <a href="delete?bId=${content_view.bId}">삭제</a></td>
			</tr>
			<tr>
				<td> 파일 다운로드 </td>
				<td> <a href="download_file">test </a> </td>
			</tr>
		</form>
	</table>
	
	<label> 댓글 수 - ${comment_view.size()} </label>
		<br/>	
		<c:choose>
			<c:when test="${comment_view.size() eq 0}">
        		<span style=> 댓글이 존재하지 않습니다. </span>
    		</c:when>
    		 <c:otherwise>
    		 	<c:forEach items="${comment_view}" var="comment">
					<table width="300" cellpadding="1" cellspacing="1" border="0" STYLE="table-layout: fixed;
																						position: relative; 
																						left : ${comment.cmIndent}px;">
								<tr>
									<td>작성자</td>
									<td colspan="4">${comment.cmName}</td>
								</tr>
								<tr >
									<td>내용</td>
									<td  style="width:100%; 
								    overflow: hidden;
								    text-overflow:ellipsis; overflow: hidden; 
								    white-space:nowrap;">
									<pre style="word-wrap: break-word;
												white-space: pre-wrap;
												white-space: -moz-pre-wrap;
												white-space: -pre-wrap;
												white-space: -o-pre-wrap;
												word-break:break-all;">${comment.cmContent} </pre>
									</td>
									<td><a href="">수정</a></td>
									<td><a href="">삭제</a></td>
									<td><input type="button" class="showHideComment" id="${comment.cmId}" value="답글"></td>
								</tr>
									
					</table>
				<div class="showHideBlock" id="showHide_${comment.cmId}" style="position: relative; left : ${comment.cmIndent+20}px;">
					<form action="comment_reply" method="post">
						<input type="hidden" name="cmId" value="${comment.cmId}"/>
						<input type="hidden" name="bId" value="${content_view.bId}">
						<input type="hidden" name="cmGroup" value="${comment.cmGroup}"/>
						<input type="hidden" name="cmStep" value="${comment.cmStep}"/>
						<input type="hidden" name="cmIndent" value="${comment.cmIndent}"/>
						<%-- <label> 댓글 아디: ${comment.cmId} </label>
						<label> 댓글 그룹아디: ${comment.cmGroup} </label>
						<label> 댓글 스텝: ${comment.cmStep} </label>
						<label> 댓글 들여쓰기: ${comment.cmIndent} </label> --%>
						<label>작성자</label>
						<input type="text" name="cmName" />
						<label>비밀번호</label>
						<input type="password" name="cmPassword"/>
						<br/>
						<label>내용</label>
						<textarea name="cmContent" rows="5" cols="40"></textarea>
						
						<input type="submit" value="쓰기"/>
					</form>				
				</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		
	<br/>
	
	<table width="600" cellpadding="0" cellspacing="0" border="0">
		<form action="comment_write" method="post">
			<input type="hidden" name="bId" value="${content_view.bId}">.
			<label>${content_view.bId} ?? 나오나</label>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="cmName" ></td>
				<td>비밀번호</td>
				<td><input type="password" name="cmPassword" ></td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td><textarea name="cmContent" rows="5" cols="40"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="쓰기"/></td>
			</tr>
		</form>
	</table>
	
</body>
</html>