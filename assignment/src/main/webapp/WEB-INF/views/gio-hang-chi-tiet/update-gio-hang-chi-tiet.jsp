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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</head>
<body>
<form:form class="container mt-3" method="post"
           action="/gio-hang-chi-tiet/update/${giohangchitietupdate.id.idGioHang}/${giohangchitietupdate.id.idChiTietSanPham}"
           modelAttribute="giohangchitietupdate">
    <div class="form-group">
        <label for="idGioHang">Id Gio hang:</label>
        <form:select class="form-control" id="idGioHang" path="id.idGioHang">
            <c:forEach items="${listGH}" var="nv">
                <form:option value="${nv.id}">${nv.id}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <div class="form-group">
        <label for="idChiTietSanPham">Id Chi tiet san pham:</label>
        <form:select class="form-control" id="idChiTietSanPham" path="id.idChiTietSanPham">
            <c:forEach items="${listCTSP}" var="nv">
                <form:option value="${nv.id}">${nv.id}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <div class="form-group">
        <label for="soLuong">So luong:</label>
        <form:input class="form-control" id="soLuong" path="soLuong"/>
    </div>

    <div class="form-group">
        <label for="donGia">Don gia:</label>
        <form:input class="form-control" id="donGia" path="donGia"/>
    </div>

    <div class="form-group">
        <label for="donGiaKhiGiam">Dong gia khi giam:</label>
        <form:input class="form-control" id="donGiaKhiGiam" path="donGiaKhiGiam"/>
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
</form:form>
</body>
</html>