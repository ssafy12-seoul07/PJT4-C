<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Comments List</title>
</head>
<body>
    <h1>Comments for Video ID: ${param.videoId}</h1>
    
    <c:if test="${empty comments}">
        <p>No comments yet.</p>
    </c:if>

    <c:forEach var="comment" items="${comments}">
        <div>
            <h3>${comment.title}</h3>
            <p>${comment.content}</p>
            <p>By: ${comment.author}</p>
            <form action="comment?action=delete" method="post">
                <input type="hidden" name="commentId" value="${comment.commentId}" />
                <input type="hidden" name="videoId" value="${param.videoId}" />
                <input type="submit" value="Delete" />
            </form>
        </div>
        <hr/>
    </c:forEach>
    
    <br/>
    <a href="addComment.jsp?videoId=${param.videoId}">Add a Comment</a>
</body>
</html>
