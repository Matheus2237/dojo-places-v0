<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dojo - Lugares</title>
</head>
<body>
    <h1>Lugares</h1>
    <table border="1" cellpadding="4" cellspacing="0">
        <thead>
        <tr>
            <th>id</th>
            <th>nome</th>
            <th>codigo</th>
            <th>dataCriacao</th>
            <th>dias desde a última atualização</th>
        </tr>
        </thead>
        <c:forEach var="place" items="${places}">
            <tbody>
                <td>${place.id}</td>
                <td>${place.name}</td>
                <td>${place.code}</td>
                <td>${place.formattedCreationDate}</td>
                <td>${place.formattedDaysSinceLastUpdate}</td>
            </tbody>
        </c:forEach>
    </table>
</body>
</html>
