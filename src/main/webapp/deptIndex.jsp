<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!doctype html>
            <html lang="en">

            <head>
                <title>Departments</title>
                <!-- Required meta tags -->
                <meta charset="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

                <!-- Bootstrap CSS v5.2.1 -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                    crossorigin="anonymous" />
            </head>

            <body>
                <header>
                    <!-- place navbar here -->
                </header>
                <main>

                    <h1>Departments <a
                        name=""
                        id=""
                        class="btn btn-primary"
                        href="dept/add"
                        role="button"
                        >Add </a
                    >
                    </h1>
                    <div class="table-responsive">
                        <table class="table table-striped table-hover table-borderless table-primary align-middle">
                            <thead class="table-light">
                                <caption>
                                    Departments
                                </caption>
                                <tr>
                                    <th>ID </th>
                                    <th>Name </th>
                                    <th>Action </th>
                                </tr>
                            </thead>
                            <tbody class="table-group-divider">
                                <c:forEach var="dept" items="${departments}">
                                <tr class="table-primary">
                                    <td scope="row"> ${dept.id}</td>
                                    <td scope="row"> ${dept.name} </td>
                                    <td>
                                        <a href="dept/edit/${dept.id}"
                                                class="btn btn-warning btn-sm">Edit</a>
                                            <a href="dept/delete/${dept.id}"
                                                class="btn btn-danger btn-sm">Delete</a>
                                        
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>

                            </tfoot>
                        </table>
                    </div>



                </main>
                <footer>
                    <!-- place footer here -->
                </footer>
                <!-- Bootstrap JavaScript Libraries -->
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                    crossorigin="anonymous"></script>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
                    integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
                    crossorigin="anonymous"></script>
            </body>

            </html>