<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dojo - Lugares</title>
</head>
<body>
<h1>Cadastro de lugares</h1>
<form:form method="POST" action="/place/create" modelAttribute="registerPlaceForm">

    <div class="form-group">
        <label for="name">Nome:</label>
        <form:input path="name" id="name" maxlength="100"/>
        <form:errors path="name" cssClass="error"/>
    </div>

    <div class="form-group">
        <label for="code">Código:</label>
        <form:input path="code" id="code"/>
        <form:errors path="code" cssClass="error"/>
    </div>

    <div class="form-group">
        <label for="neighborhood">Bairro:</label>
        <form:input path="neighborhood" id="neighborhood" maxlength="100"/>
        <form:errors path="neighborhood" cssClass="error"/>
    </div>

    <div class="form-group">
        <label for="city">Cidade:</label>
        <form:input path="city" id="city" maxlength="100"/>
        <form:errors path="city" cssClass="error"/>
    </div>

    <button type="submit">Cadastrar</button>

</form:form>
</body>
</html>