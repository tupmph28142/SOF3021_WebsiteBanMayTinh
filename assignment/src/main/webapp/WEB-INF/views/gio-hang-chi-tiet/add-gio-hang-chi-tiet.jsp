<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Document</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <form:form method="post" action="/gio-hang-chi-tiet/add" modelAttribute="giohangchitiet">
        <div class="form-group">
            <label for="idGioHang">Id Gio hang:</label>
            <form:select path="id.idGioHang" class="form-control" id="idGioHang">
                <c:forEach items="${listGH}" var="nv">
                    <form:option value="${nv.id}">${nv.id}</form:option>
                </c:forEach>
            </form:select>
        </div>

        <div class="form-group">
            <label for="idChiTietSanPham">Id Chi tiet san pham:</label>
            <form:select path="id.idChiTietSanPham" class="form-control" id="idChiTietSanPham">
                <c:forEach items="${listCTSP}" var="nv">
                    <form:option value="${nv.id}">${nv.id}</form:option>
                </c:forEach>
            </form:select>
        </div>

        <div class="form-group">
            <label for="soLuong">So luong:</label>
            <form:input path="soLuong" class="form-control" id="soLuong"/>
        </div>

        <div class="form-group">
            <label for="donGia">Don gia:</label>
            <form:input path="donGia" class="form-control" id="donGia"/>
        </div>

        <div class="form-group">
            <label for="donGiaKhiGiam">Dong gia khi giam:</label>
            <form:input path="donGiaKhiGiam" class="form-control" id="donGiaKhiGiam"/>
        </div>

        <button type="submit" class="btn btn-primary">Add</button>
    </form:form>
</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>