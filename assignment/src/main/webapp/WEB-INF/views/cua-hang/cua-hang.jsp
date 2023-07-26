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
    <!-- Thêm các tệp CSS vàJavaScript của Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form action="/cua-hang/search" method="post" class="container">

    <div class="mb-3">
        <label class="form-label"> Ten</label>
        <input type="text" class="form-control" name="hoTen">
    </div>

    <button type="submit" class="btn btn-primary">Search</button>
</form>
<form action="/cua-hang/view-add" class="container">
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table container">
    <thead>
    <tr>
        <td>Ma</td>
        <td>Ten</td>
        <td>Dia chi</td>
        <td>Thanh pho</td>
        <td>Quoc gia</td>

        <td>Action</td>
    </tr>
    </thead>
    <tbdoy>
        <c:forEach items="${listCV}" var="cv" varStatus="index">
            <tr>

                <td>${cv.ma}</td>
                <td>${cv.ten}</td>
                <td>${cv.diaChi}</td>
                <td>${cv.thanhPho}</td>
                <td>${cv.quocGia}</td>

                <td>
                    <a href="/cua-hang/xoa/${cv.id}" class="btn btn-primary">Xoa</a>
                    <a class="btn btn-primary" href="/cua-hang/detail/${cv.id}">Detail</a>
                    <a class="btn btn-primary" href="/cua-hang/update/${cv.id}">Update</a>

                </td>
            </tr>
        </c:forEach>
    </tbdoy>
</table>

<!-- Nhúng các tệp JavaScript của Bootstrap -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-EmiKZ8IiWYcIKF//e6pT8u7zOLpJvKbtG4W9shVHa7LW0QQj2QaF7zr6wArxTgMl"
        crossorigin="anonymous"></script>
</body>
</html>