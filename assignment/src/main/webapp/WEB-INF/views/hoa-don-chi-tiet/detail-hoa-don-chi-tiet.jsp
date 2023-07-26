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
    <!-- Thêm các tệp CSS và JavaScript củaBootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<!-- Sử dụng các lớp CSS của Bootstrap để tạo ra các thành phần UI đẹp hơn -->
<form class="container">
    <div class="row">
        <div class="col-3">
            <label for="idHoaDon">Id Hoa don:</label>
            <input type="text" class="form-control" id="idHoaDon" value="${nv.id.hoaDon.id}">
        </div>

        <div class="col-3">
            <label for="idChiTietSanPham">Id Chi tiet san pham:</label>
            <input type="text" class="form-control" id="idChiTietSanPham" value="${nv.id.chiTietSanPham.id}">
        </div>

        <div class="col-3">
            <label for="soLuong">So luong:</label>
            <input type="text"class="form-control" id="soLuong" value="${nv.soLuong}">
        </div>

        <div class="col-3">
            <label for="donGia">Don gia:</label>
            <input type="text" class="form-control" id="donGia" value="${nv.donGia}">
        </div>
    </div>
</form>
<!-- Nhúng các tệp JavaScript của Bootstrap -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-EmiKZ8IiWYcIKF//e6pT8u7zOLpJvKbtG4W9shVHa7LW0QQj2QaF7zr6wArxTgMl"
        crossorigin="anonymous"></script>
</body>
</html>