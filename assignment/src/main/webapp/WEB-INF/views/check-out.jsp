<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    <title>Check Out</title>
</head>
<body>

<div class="container mt-5">
    <form action="/check-out/add" method="post">
        <h4 class="mb-3">Billing address</h4>
        <div class="row">

            <div class="col-md-6 mb-3">
                <label for="tenNguoiNhan">Ten nguoi nhan</label>
                <input type="text" class="form-control" name="tenNguoiNhan" id="tenNguoiNhan"  >

            </div>
        </div>

        <div class="mb-3">
            <label for="sdt">So dien thoai</label>
            <input type="sdt" class="form-control" id="sdt" name="sdt" >

        </div>

        <div class="mb-3">
            <label for="address">Dia chi</label>
            <input type="text" class="form-control" id="address" name="diaChi">

        </div>
<%--        <a href="/bill-theme" class="btn btn-success" type="submit">Continue checkout</a>--%>
        <button type="submit" class="btn btn-success">Continue to checkout</button>
    </form>
</div>
</body>
</html>