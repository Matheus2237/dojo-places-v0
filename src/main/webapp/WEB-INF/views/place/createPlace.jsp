<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dojo - Cadastro de Lugares</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

<div class="p-4" style="min-width: 420px;">

    <div class="d-flex justify-content-center mb-4">
        <div class="d-flex align-items-center gap-4">
            <h1 class="h4 m-0">Cadastro de lugares</h1>

            <a href="/place" class="text-decoration-underline text-muted">
                Voltar para lista de lugares
            </a>
        </div>
    </div>

    <form:form method="POST" action="/place/create" modelAttribute="registerPlaceForm" class="d-flex flex-column gap-3">
        <div>
            <label for="name" class="form-label">Nome</label>
            <form:input path="name" id="name" maxlength="100" cssClass="form-control"/>
            <form:errors path="name" cssClass="text-danger small"/>
        </div>

        <div>
            <label for="code" class="form-label">Código</label>
            <form:input path="code" id="code" cssClass="form-control"/>
            <form:errors path="code" cssClass="text-danger small"/>
        </div>

        <div>
            <label for="cep" class="form-label">CEP</label>
            <form:input path="cep" id="cep" maxlength="9" onkeyup="formatCep()" onblur="findCep()" cssClass="form-control"/>
            <form:errors path="cep" cssClass="text-danger small"/>
        </div>

        <div>
            <label for="neighborhood" class="form-label">Bairro</label>
            <form:input path="neighborhood" id="neighborhood" maxlength="100" cssClass="form-control"/>
            <form:errors path="neighborhood" cssClass="text-danger small"/>
        </div>

        <div>
            <label for="city" class="form-label">Cidade</label>
            <form:input path="city" id="city" maxlength="100" cssClass="form-control"/>
            <form:errors path="city" cssClass="text-danger small"/>
        </div>

        <div class="d-flex justify-content-end gap-2 mt-3">
            <a href="/place" class="btn btn-outline-danger">
                Cancelar
            </a>
            <button type="submit" class="btn btn-success">
                Cadastrar
            </button>
        </div>

    </form:form>
</div>

<script src="/assets/js/cep.js"></script>
</body>
</html>