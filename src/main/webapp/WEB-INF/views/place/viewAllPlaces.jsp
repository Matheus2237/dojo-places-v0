<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/modal" prefix="modal" %>

<html>
<head>
    <title>Dojo - Lugares</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

<div class="d-flex flex-column align-items-center p-4" style="max-height: calc(100vh - 4rem); overflow-y: auto;">
    <div class="d-flex align-items-center justify-content-between mb-4 w-100">
        <h1 class="m-0">Lugares</h1>

        <a href="/place/create" class="btn btn-success">
            Cadastrar novo lugar
        </a>
    </div>

    <table class="table table-borderless w-auto">
        <thead class="border-bottom">
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Código</th>
            <th>Data de criação</th>
            <th>Dias desde a última atualização</th>
            <th>Ações</th>
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
                    <form action="/place/${place.id}/edit" method="get" class="d-inline">
                        <button class="btn btn-sm btn-primary">Editar</button>
                    </form>
                    <form action="/place/${place.id}/delete" method="post" class="d-inline delete-form">
                        <button type="button" class="btn btn-sm btn-danger"
                                onclick="openDeleteModal(this)">
                            Remover
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<modal:deleteConfirm></modal:deleteConfirm>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/assets/js/deleteModal.js"></script>

</body>
</html>