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
<form method="post" class="container">
    <div class="mb-3">
        <label class="form-label">Ma</label>
        <input type="text" class="form-control" name="ma" value="${nv.ma}">
    </div>
    <div class="mb-3">
        <label class="form-label">Ten</label>
        <input type="text" class="form-control" name="ten" value="${nv.ten}">
    </div>

    <button type="submit" class="btn btn-primary">Update</button>

</form>
</body>
</html>