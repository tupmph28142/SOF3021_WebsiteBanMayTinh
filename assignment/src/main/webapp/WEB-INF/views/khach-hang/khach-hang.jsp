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
<form action="/khach-hang/search" method="post" class="container">

    <div class="mb-3">
        <label class="form-label"> Ma</label>
        <input type="text" class="form-control" name="hoTen">
    </div>

    <button type="submit" class="btn btn-primary">Search</button>
</form>
<form action="/khach-hang/view-add" class="container">
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table container">
    <thead>
    <tr>
        <td>Ma</td>
        <td>Ho va ten</td>

        <td>Ngay sinh</td>
        <td>SDT</td>
        <td>Dia chi</td>
        <td>Thanh pho</td>
        <td>Quoc gia</td>
        <td>Mat khau</td>


        <td>Action</td>
    </tr>
    </thead>
    <tbdoy>
        <c:forEach items="${listGH}" var="gh" varStatus="index">
            <tr>
                <td>${gh.ma}</td>
                <td>${gh.ho} ${gh.tenDem} ${gh.ten}</td>



                <td>${gh.ngaySinh}</td>
                <td>${gh.sdt}</td>
                <td>${gh.diaChi}</td>
                <td>${gh.thanhPho}</td>
                <td>${gh.quocGia}</td>
                <td>${gh.matKhau}</td>


                <td>
                    <a href="/khach-hang/xoa/${gh.id}" class="btn btn-primary">Xoa</a>
                    <a class="btn btn-primary" href="/khach-hang/detail/${gh.id}">Detail</a>
                    <a class="btn btn-primary" href="/khach-hang/update/${gh.id}">Update</a>

                </td>
            </tr>
        </c:forEach>
    </tbdoy>
</table>
</body>
</html>