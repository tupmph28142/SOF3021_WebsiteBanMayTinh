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
<form   class="container">

    <div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Ma</label>
            <input type="text" class="form-control" name="v" value="${nv.ma}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ho ten</label>
            <input type="text" class="form-control" name="b" value="${nv.ho} ${nv.tenDem} ${nv.ten}">
        </div>
    </div>
    <div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Ngay sinh</label>
            <input type="text" class="form-control" name="c" value="${nv.ngaySinh}">
        </div>
        <div class="mb-3">
            <label class="form-label">SDT</label>
            <input type="text" class="form-control" name="d" value="${nv.sdt}">
        </div>
    </div>
    <div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Dia chi</label>
            <input type="text" class="form-control" name="e" value="${nv.diaChi}">
        </div>
        <div class="mb-3">
            <label class="form-label">Thanh pho</label>
            <input type="text" class="form-control" name="f" value="${nv.thanhPho}">
        </div>
    </div>
<div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Quoc gia</label>
            <input type="text" class="form-control" name="e" value="${nv.quocGia}">
        </div>
        <div class="mb-3">
            <label class="form-label">Mat khau</label>
            <input type="text" class="form-control" name="f" value="${nv.matKhau}">
        </div>
    </div>


</form>
</body>
</html>