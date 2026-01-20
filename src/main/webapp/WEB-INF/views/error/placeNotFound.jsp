<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Dojo - Lugar não encontrado</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center vh-100">
<div class="p-4" style="max-width: 420px; text-align: justify;">
    <h1 class="display-6 mb-3 text-nowrap">Lugar não encontrado</h1>
    <p class="text-muted mb-4">O lugar que você tentou acessar não existe ou foi removido.</p>

    <div class="text-end">
        <a href="/place" class="text-decoration-underline text-muted">Voltar para lista de lugares</a>
    </div>
</div>
</body>
</html>