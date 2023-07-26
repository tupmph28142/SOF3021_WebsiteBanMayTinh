
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<form action="/nhan-vien/search" method="post"  class="container">

    <div class="mb-3">
        <label class="form-label">Ho Ten</label>
        <input type="text" class="form-control" name="hoTen">
    </div>

    <button type="submit" class="btn btn-primary">Search</button>
</form>
<form action="/nhan-vien/view-add" class="container">
    <button type="submit" class="btn btn-primary">Add</button>
</form>

<%--<form action="/sinh-vien/add" method="post" class="container">--%>
<%--    Ma: <input type="text" name="ma">--%>
<%--    Ten: <input type="text" name="ten">--%>
<%--    Ho: <input type="text" name="ho">--%>

<%--    SDT: <input type="text" name="sdt">--%>
<%--    Dia chi: <input type="text" name="diaChi">--%>
<%--<button type="submit" class="btn btn-primary">Add</button>--%>
<%--</form>--%>
<%--<form:form method="post" action="/nhan-vien/add" modelAttribute="nhanvien">--%>

<%--  Ma:  <form:input path="ma"/>--%>
<%--  Ten:  <form:input path="name"/>--%>
<%--  Ho:  <form:input path="ho"/>--%>
<%--  SDT:  <form:input path="sdt"/>--%>
<%--  Dia chi:  <form:input path="diaChi"/>--%>
<%--    <button type="submit" class="btn btn-primary">Add</button>--%>
<%--</form:form>--%>
<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Ma</td>
        <td>Ho Ten</td>
        <td>Ngay sinh</td>
        <td>SDT</td>
        <td>Dia Chi</td>
        <td>Mat khau</td>
        <td>Chuc vu</td>

        <td>Trang thai</td>
        <td>Gioi Tinh</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbdoy>
        <c:forEach items="${listNV}" var="nv" varStatus="index">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.ma}</td>
                <td>${nv.ho} ${nv.tenDem} ${nv.ten} </td>
                <td>${nv.ngaySinh}</td>
                <td>${nv.sdt}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.matKhau}</td>
                <td>${nv.chucVu.ten}</td>
                <td>${nv.trangThai==1?'con lam':'da nghi'}</td>
                <td>
                        ${nv.gioiTinh}
                </td>
                <td>
                    <a href="/nhan-vien/xoa/${nv.id}" class="btn btn-primary">Xoa</a>
                    <a class="btn btn-primary" href="/nhan-vien/detail/${nv.id}">Detail</a>
                    <a class="btn btn-primary" href="/nhan-vien/update/${nv.id}">Update</a>

                </td>
            </tr>
        </c:forEach>
    </tbdoy>
</table>
</body>
</html>
