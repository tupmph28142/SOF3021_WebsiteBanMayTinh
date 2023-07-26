<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<form action="/hoa-don-chi-tiet/search" method="post" class="container">

    <div class="mb-3">
        <label class="form-label"> Ma</label>
        <input type="text" class="form-control" name="hoTen">
    </div>

    <button type="submit" class="btn btn-primary">Search</button>
</form>
<form action="/hoa-don-chi-tiet/view-add" class="container">
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table container">
    <thead>
    <tr>
        <td>Id Hoa don</td>
        <td>Id chi tiet san pham</td>
        <td>So luong</td>
        <td>Don gia</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbdoy>
        <c:forEach items="${listHDCT}" var="gh" varStatus="index">
            <tr>
                <td>${gh.id.hoaDon.id}</td>
                <td>${gh.id.chiTietSanPham.id}</td>
                <td>${gh.soLuong}</td>
                <td>${gh.donGia}</td>


                <td>
                    <a href="/hoa-don-chi-tiet/xoa/${gh.id.hoaDon.id}/${gh.id.chiTietSanPham.id}" class="btn btn-primary">Xoa</a>
                    <a class="btn btn-primary"
                       href="/hoa-don-chi-tiet/detail/${gh.id.hoaDon.id}/${gh.id.chiTietSanPham.id}">Detail</a>
                    <a class="btn btn-primary"
                       href="/hoa-don-chi-tiet/update/${gh.id.hoaDon.id}/${gh.id.chiTietSanPham.id}">Update</a>

                </td>
            </tr>
        </c:forEach>
    </tbdoy>
</table>
</body>
</html>