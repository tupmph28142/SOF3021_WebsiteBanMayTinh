<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="iedge">
    <title>Document</title>
    <!-- Thêm các tệp CSS và JavaScript của Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<form:form method="post" action="/hoa-don-chi-tiet/update/${hoadonchitietupdate.id.hoaDon.id}/${hoadonchitietupdate.id.chiTietSanPham.id}" modelAttribute="hoadonchitietupdate" class="container">
    <div class="row">
        <div class="col-3">
            <label for="idHoaDon">Id Hoa don:</label>
            <form:select path="id.hoaDon.id" class="form-control">
                <c:forEach items="${listHD}" var="nv">
                    <form:option value="${nv.id}">${nv.ma}</form:option>
                </c:forEach>
            </form:select>
        </div>

        <div class="col-3">
            <label for="idChiTietSanPham">Id Chi tiet san pham:</label>
            <form:select path="id.chiTietSanPham.id" class="form-control">
                <c:forEach items="${listCTSP}" var="nv">
                    <form:option value="${nv.id}">${nv.id}</form:option>
                </c:forEach>
            </form:select>
        </div>

        <div class="col-3">
            <label for="soLuong">So luong:</label>
            <form:input path="soLuong" class="form-control"/>
        </div>

        <div class="col-3">
            <label for="donGia">Don gia:</label>
            <form:input path="donGia" class="form-control"/>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </div>
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