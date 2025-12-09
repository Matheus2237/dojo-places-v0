<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dojo - Lugares</title>
</head>
<body>
<h1>Lugares</h1>

<a href="/place/create">Cadastrar novo lugar</a>

<table border="1" cellpadding="4" cellspacing="0">
    <thead>
    <tr>
        <th>id</th>
        <th>nome</th>
        <th>codigo</th>
        <th>dataCriacao</th>
        <th>dias desde a última atualização</th>
        <th>ações</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="place" items="${places}">
        <tr>
            <td>${place.id}</td>
            <td>${place.name}</td>
            <td>${place.code}</td>
            <td>${place.formattedCreationDate}</td>
            <td>${place.formattedDaysSinceLastUpdate}</td>
            <td>
                <form action="/place/${place.id}/edit" method="get" style="display:inline;">
                    <button type="submit">
                        Editar
                    </button>
                </form>
                <form action="/place/${place.id}/delete" method="post" style="display:inline;">
                    <button type="submit" onclick="return confirm('Tem certeza que deseja remover este lugar?');">
                        Remover
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>