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
<form action="/chi-tiet-san-pham/search" method="post" class="container">

    <div class="mb-3">
        <label class="form-label"> Ma</label>
        <input type="text" class="form-control" name="hoTen">
    </div>

    <button type="submit" class="btn btn-primary">Search</button>
</form>
<form action="/chi-tiet-san-pham/view-add" class="container">
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table container">
    <thead>
    <tr>
        <td>Ten san pham</td>
        <td> Nha san xuat</td>


        <td> Mau sac</td>
        <td>Dong san pham</td>
        <td>Nam Bh</td>
        <td>Mo ta</td>
        <td>So luong ton</td>
        <td>gia nhap</td>
        <td>gia ban</td>


        <td>Action</td>
    </tr>
    </thead>
    <tbdoy>
        <c:forEach items="${listCTSP}" var="ctsp" varStatus="index">
            <tr>
                <td>${ctsp.sanPham.ten}</td>
                <td>${ctsp.nhaSanXuat.ten}</td>


                <td>${ctsp.mauSac.ten}</td>
                <td>${ctsp.dongSanPham.ten}</td>
                <td>${ctsp.namBH}</td>
                <td>${ctsp.moTa}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>${ctsp.giaNhap}</td>
                <td>${ctsp.giaBan}</td>

                <td>
                    <a href="/chi-tiet-san-pham/xoa/${ctsp.id}" class="btn btn-primary">Xoa</a>
                    <a class="btn btn-primary" href="/chi-tiet-san-pham/detail/${ctsp.id}">Detail</a>
                    <a class="btn btn-primary" href="/chi-tiet-san-pham/update/${ctsp.id}">Update</a>
<%--                    <a class="btn btn-success bi bi-cart" href="/cart/add?idCtsp=${ctsp.id}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-plus" viewBox="0 0 16 16">--%>
<%--                        <path d="M9 5.5a.5.5 0 0 0-1 0V7H6.5a.5.5 0 0 0 0 1H8v1.5a.5.5 0 0 0 1 0V8h1.5a.5.5 0 0 0 0-1H9V5.5z"/>--%>
<%--                        <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zm3.915 10L3.102 4h10.796l-1.313 7h-8.17zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>--%>
<%--                    </svg></a>--%>


                </td>
            </tr>
        </c:forEach>
    </tbdoy>
</table>
<%--<a class="btn btn-primary" href="/cart/view">Di den gio hang</a>--%>

</body>
</html>