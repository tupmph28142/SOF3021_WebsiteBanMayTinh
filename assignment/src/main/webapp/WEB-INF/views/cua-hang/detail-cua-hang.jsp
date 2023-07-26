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
            <input type="text" class="form-control" name="tuoi" value="${nv.ma}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ten</label>
            <input type="text" class="form-control" name="hoTen" value="${nv.ten}">
        </div>
    </div>
 <div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Dia chi</label>
            <input type="text" class="form-control" name="tuoi" value="${nv.diaChi}">
        </div>
        <div class="mb-3">
            <label class="form-label">Thanh PHo</label>
            <input type="text" class="form-control" name="hoTen" value="${nv.thanhPho}">
        </div>
    </div>
 <div class="mb-3">
        <div class="mb-3">
            <label class="form-label">Quoc gia</label>
            <input type="text" class="form-control" name="tuoi" value="${nv.quocGia}">
        </div>

    </div>

</form>
</body>
</html>