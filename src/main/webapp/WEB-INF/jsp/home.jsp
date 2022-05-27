<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type"
          content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet"  href="${contextpath}/bootstrap/css/bootstrap.min.css">
        <title>Home Page</title>
        <style>
            .center {
                margin: auto;
                width: 60%;
                border: 5px solid #ABABAB;
                padding: 10px;
                margin-top: 100px;
            }
        </style>
    </head>
    <body>
    <div class="center">
         <h3>${msg}</h3>
     <table class="table table-bordered">
         <thead class="thead-light">
                    <tr>
                        <th>Feature Name</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${features}" var="feature">
                        <tr>
                            <td>${feature.name}</td>
                            <td>${feature.description}</td>
                        </tr>
                    </c:forEach>
                </tbody>
        </table>
        </div>
    </body>
</html>