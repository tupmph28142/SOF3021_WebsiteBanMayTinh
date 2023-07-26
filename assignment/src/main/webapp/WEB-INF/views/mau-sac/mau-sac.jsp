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
<form action="/mau-sac/search" method="post" class="container">

    <div class="mb-3">
        <label class="form-label"> Ten</label>
        <input type="text" class="form-control" name="hoTen">
    </div>

    <button type="submit" class="btn btn-primary">Search</button>
</form>
<form action="/mau-sac/view-add" class="container">
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table container">
    <thead>
    <tr>
        <td>Ma</td>
        <td>Ten</td>

        <td>Action</td>
    </tr>
    </thead>
    <tbdoy>
        <c:forEach items="${listSP}" var="sp" varStatus="index">
            <tr>

                <td>${sp.ma}</td>
                <td>${sp.ten}</td>

                <td>
                    <a href="/mau-sac/xoa/${sp.id}" class="btn btn-primary">Xoa</a>
                    <a class="btn btn-primary" href="/mau-sac/detail/${sp.id}">Detail</a>
                    <a class="btn btn-primary" href="/mau-sac/update/${sp.id}">Update</a>

                </td>
            </tr>
        </c:forEach>
    </tbdoy>
</table>
</body>
</html>