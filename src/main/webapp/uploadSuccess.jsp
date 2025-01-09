<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Successful</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEJx3X1+KkAc5n8f3quFZ0QF5+w/7k8J+Xmg41Gr47iHwwFddOxU9lS4j5E87" crossorigin="anonymous">
    
    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Arial', sans-serif;
        }

        .container {
            max-width: 600px;
            margin-top: 50px;
        }

        .card {
            border-radius: 10px;
            box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1);
        }

        .btn-custom {
            background-color: #007bff;
            color: white;
            border-radius: 50px;
            padding: 12px 30px;
            width: 100%;
        }

        .card-header {
            background-color: #007bff;
            color: white;
            text-align: center;
            font-size: 1.5rem;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }
    </style>
</head>

<body>

    <div class="container">
        <div class="card">
            <div class="card-header">
                <h4>Upload Successful</h4>
            </div>
            <div class="card-body text-center">
                <h5 class="mb-4">Your file has been uploaded successfully!</h5>
                
                <div class="mb-4">
                    <p><strong>File Name:</strong> ${param.fileName}</p>
                    <p><strong>File Size:</strong> ${param.fileSize} MB</p>
                </div>
				<img src="data:image/jpeg;base64,${image}" alt="Image" />
                <!-- Return to Upload Page Button -->
                <a href="/file" class="btn btn-custom">Return to Upload Form</a>
            </div>
        </div>
    </div>
	
	<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
	  <div class="carousel-inner">
		<c:forEach var="image" items="${images}" varStatus="status">
		      <div class="carousel-item ${status.first ? 'active' : ''}">
		        <img src="data:image/jpeg;base64,${image}" class="d-block w-100" alt="Image">
		      </div>
		    </c:forEach>
			</div>
			  
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
			      <span class="carousel-control-next-icon" aria-hidden="true"></span>
			      <span class="visually-hidden">Next</span>
			    </button>
				</div>

    <!-- Bootstrap 5 JS & Popper (for dropdowns, modals, tooltips) -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz4fnFO9gybB6fRrF2X4wV37iBvJkFq5lZB88MIl7B0jMlQ6c3wQpS3ro+M" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-pzjw8f+ua7Kw1TIq0+2w2rc7v9UlQsVnIYy5pK6t1mCgFw5auV2fr2tuVsUpV3f1" crossorigin="anonymous"></script>

</body>

</html>
