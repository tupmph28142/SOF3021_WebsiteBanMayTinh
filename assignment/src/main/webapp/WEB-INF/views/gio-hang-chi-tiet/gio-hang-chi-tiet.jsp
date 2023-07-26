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
<form action="/gio-hang-chi-tiet/search" method="post" class="container">

    <div class="mb-3">
        <label class="form-label"> Ma</label>
        <input type="text" class="form-control" name="hoTen">
    </div>

    <button type="submit" class="btn btn-primary">Search</button>
</form>
<form action="/gio-hang-chi-tiet/view-add" class="container">
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table container">
    <thead>
    <tr>
        <td>Id gio hang</td>
        <td>Id chi tiet san pham</td>


        <td>So luong</td>
        <td>Don gia</td>
        <td>Don gia khi giam</td>



        <td>Action</td>
    </tr>
    </thead>
    <tbdoy>
        <c:forEach items="${listGH}" var="gh" varStatus="index">
            <tr>
                <td>${gh.id.idGioHang}</td>
                <td>${gh.id.idChiTietSanPham}</td>
                <td>${gh.soLuong}</td>
                <td>${gh.donGia}</td>
                <td>${gh.donGiaKhiGiam}</td>


                <td>
                    <a href="/gio-hang-chi-tiet/xoa/${gh.id.idGioHang}/${gh.id.idChiTietSanPham}" class="btn btn-primary">Xoa</a>
                    <a class="btn btn-primary" href="/gio-hang-chi-tiet/detail/${gh.id.idGioHang}/${gh.id.idChiTietSanPham}">Detail</a>
                    <a class="btn btn-primary" href="/gio-hang-chi-tiet/update/${gh.id.idGioHang}/${gh.id.idChiTietSanPham}">Update</a>

                </td>
            </tr>
        </c:forEach>
    </tbdoy>
</table>
</body>
</html>