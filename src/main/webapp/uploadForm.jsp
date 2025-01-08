<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Image Upload</title>
</head>
<body>
    <h1>Upload Image</h1>

	<form action="/uploadImage" method="post" enctype="multipart/form-data">
	        <label for="imageFile">Choose an image to upload:</label>
	        <input type="file" name="imageFile" id="imageFile" accept="image/*" required>
	        <button type="submit">Upload</button>
	    </form>

    <br>
    <p>${message}</p> <!-- Show the message passed from the controller -->

    <!-- Show uploaded image if available -->
    <c:if test="${not empty imagePath}">
        <h3>Uploaded Image:</h3>
        <img src="file://${imagePath}" alt="Uploaded Image" width="300px">
    </c:if>
</body>
</html>