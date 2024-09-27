<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Comment</title>
</head>
<body>
    <h1>Add a New Comment</h1>
    
    <form action="comment?action=add" method="post">
        <input type="hidden" name="videoId" value="${param.videoId}" />
        
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required /><br/>
        
        <label for="content">Content:</label>
        <textarea id="content" name="content" rows="5" cols="30" required></textarea><br/>
        
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required /><br/>
        
        <input type="submit" value="Add Comment" />
    </form>
    
    <br/>
    <a href="comment?action=list&videoId=${param.videoId}">Back to Comments List</a>
</body>
</html>
