<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!-- Thêm các tệp CSS của Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form:form method="post" action="/cua-hang/add" modelAttribute="cuahang" class="container">

    <div class="mb-3">
        <label class="form-label">Ma</label>
        <form:input path="ma" class="form-control"/>
    </div>

    <div class="mb-3">
        <label class="form-label">Ten</label>
        <form:input path="ten" class="form-control"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Dia chi</label>
        <form:input path="diaChi" class="form-control"/>
    </div>
    <div class="mb-3">
        <label class="form-label">ThanhPho</label>
        <form:input path="thanhPho" class="form-control"/>
    </div>
    <div class="mb-3">
        <label class="form-label">Quoc gia</label>
        <form:input path="quocGia" class="form-control"/>
    </div>

    <button type="submit" class="btn btn-primary">Add</button>
</form:form>

<!-- Nhúng các tệp JavaScript của Bootstrap -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-EmiKZ8IiWYcIKF//e6pT8u7zOLpJvKbtG4W9shVHa7LW0QQj2QaF7zr6wArxTgMl"
        crossorigin="anonymous"></script>
</body>
</html>