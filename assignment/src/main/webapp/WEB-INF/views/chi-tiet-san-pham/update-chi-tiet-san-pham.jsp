<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form:form method="post" action="/chi-tiet-san-pham/update/${chitietsanphamupdate.id}" modelAttribute="chitietsanphamupdate" class="container">
    <div class="mb-3">
        <label class="form-label">Ten San Pham</label>
        <form:select path="sanPham" class="form-control">
            <c:forEach items="${listSP}" var="sp">
                <form:option value="${sp.id}">${sp.ten}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <div class="mb-3">
        <label class="form-label">Nha san xuat</label>
        <form:select path="nhaSanXuat" class="form-control">
            <c:forEach items="${listNSX}" var="nsx">
                <form:option value="${nsx.id}">${nsx.ten}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <div class="mb-3">
        <label class="form-label">Mau Sac</label>
        <form:select path="mauSac" class="form-control">
            <c:forEach items="${listMS}" var="ms">
                <form:option value="${ms.id}">${ms.ten}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <div class="mb-3">
        <label class="form-label">Dong san pham</label>
        <form:select path="dongSanPham" class="form-control">
            <c:forEach items="${listDSP}" var="dsp">
                <form:option value="${dsp.id}">${dsp.ten}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <div class="mb-3">
        <label class="form-label">Nam BH</label>
        <form:input path="namBH" class="form-control"/>
    </div>

    <div class="mb-3">
        <label class="form-label">Mo ta</label>
        <form:input path="moTa" class="form-control"/>
    </div>

    <div class="mb-3">
        <label class="form-label">So luong ton</label>        <form:input path="soLuongTon" class="form-control"/>
    </div>

    <div class="mb-3">
        <label class="form-label">Gia nhap</label>
        <form:input path="giaNhap" class="form-control"/>
    </div>

    <div class="mb-3">
        <label class="form-label">Gia ban</label>
        <form:input path="giaBan" class="form-control"/>
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
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