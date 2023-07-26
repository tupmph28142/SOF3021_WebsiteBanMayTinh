<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
    <title>Document</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <form>
        <div class="row">
            <div class="col-md-4">
                <div class="form-group">
                    <label for="idGioHang">Id gio hang: </label>
                    <input type="text" class="form-control" id="idGioHang" value="${nv.id.idGioHang}">
                </div>
            </div>

            <div class="col-md-4">
                <div class="form-group">
                    <label for="idChiTietSanPham">Id Chi Tiet san pham: </label>
                    <input type="text" class="form-control" id="idChiTietSanPham" value="${nv.id.idChiTietSanPham}">
                </div>
            </div>

            <div class="col-md-4">
                <div class="form-group">
                    <label for="soLuong">So luong: </label>
                    <input type="text" class="form-control" id="soLuong" value="${nv.soLuong}">
                </div>
            </div>

            <div class="col-md-4">
                <div class="form-group">
                    <label for="donGia">Don gia: </label>
                    <input type="text" class="form-control" id="donGia" value="${nv.donGia}">
                </div>
            </div>

            <div class="col-md-4">
                <div class="form-group">
                    <label for="donGiaKhiGiam">Don gia khi giam: </label>
                    <input type="text" class="form-control" id="donGiaKhiGiam" value="${nv.donGiaKhiGiam}">
                </div>
            </div>
        </div>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-9cXQsLjZ8rZ9b4TNZ5a5fQs7kMW9tTcVX8VzLX0Jm+Bw6dVtNvA8wL8Fg5K7eZwL"
        crossorigin="anonymous"></script>
</body>
</html>