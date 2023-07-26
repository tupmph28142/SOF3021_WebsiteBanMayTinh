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
<form class="container">
    <div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Id Khach Hang</label>
            <input type="text" class="form-control" name="tuoi" value="${nv.khachHang.id}">
        </div>
        <div class="mb-3">
            <label class="form-label">Id nhan vien</label>
            <input type="text" class="form-control" name="a" value="${nv.nhanVien.id}">
        </div>
    </div>
    <div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Ma</label>
            <input type="text" class="form-control" name="v" value="${nv.ma}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ngay tao</label>
            <input type="text" class="form-control" name="b" value="${nv.ngayTao}">
        </div>
    </div>
    <div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Ngay thanh toan</label>
            <input type="text" class="form-control" name="c" value="${nv.ngayThanhToan}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ten nguoi nhan</label>
            <input type="text" class="form-control" name="d" value="${nv.tenNguoiNhan}">
        </div>
    </div>
    <div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Dia chi</label>
            <input type="text" class="form-control" name="e" value="${nv.diaChi}">
        </div>
        <div class="mb-3">
            <label class="form-label">SDT</label>
            <input type="text" class="form-control" name="f" value="${nv.sdt}">
        </div>
    </div>
    <div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Ngay ship</label>
            <input type="text" class="form-control" name="e" value="${nv.ngayShip}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ngay nhan</label>
            <input type="text" class="form-control" name="f" value="${nv.ngayNhan}">
        </div>
    </div>
    <div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Tinh trang</label>
            <input type="text" class="form-control" name="e" value="${nv.tinhTrang}">
        </div>

    </div>


</form>
</body>
</html>