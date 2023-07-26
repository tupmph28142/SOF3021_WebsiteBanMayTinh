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
<form action="/hoa-don/search" method="post" class="container">

    <div class="mb-3">
        <label class="form-label"> Ma</label>
        <input type="text" class="form-control" name="hoTen">
    </div>

    <button type="submit" class="btn btn-primary">Search</button>
</form>
<form action="/hoa-don/view-add" class="container">
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table container">
    <thead>
    <tr>
        <td>Id khach hang</td>
        <td>Id nhan vien</td>
        <td>Ma</td>
        <td>Ngay tao</td>
        <td>Ngay thanh toan</td>
        <td>Ngay ship</td>
        <td>Ngay nhan</td>
        <td>Tinh trang</td>
        <td>Ten nguoi nhan</td>
        <td>Dia chi</td>
        <td>SDT</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbdoy>
        <c:forEach items="${listGH}" var="gh" varStatus="index">
            <tr>
                <td>${gh.khachHang.ten}</td>
                <td>${gh.nhanVien.ten}</td>


                <td>${gh.ma}</td>
                <td>${gh.ngayTao}</td>
                <td>${gh.ngayThanhToan}</td>
                <td>${gh.ngayShip}</td>
                <td>${gh.ngayNhan}</td>
                <td>${gh.tinhTrang==1?"Da xac nhan":"Cho xac nhan"}</td>
                <td>${gh.tenNguoiNhan}</td>
                <td>${gh.diaChi}</td>
                <td>${gh.sdt}</td>

                <td>
                    <a href="/hoa-don/xoa/${gh.id}" class="btn btn-primary">Xoa</a>
                    <a class="btn btn-primary" href="/hoa-don/detail/${gh.id}">Detail</a>
                    <a class="btn btn-primary" href="/hoa-don/update/${gh.id}">Update</a>

                </td>
            </tr>
        </c:forEach>
    </tbdoy>
</table>
</body>
</html>