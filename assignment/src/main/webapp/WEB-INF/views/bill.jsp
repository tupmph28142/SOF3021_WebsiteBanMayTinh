<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bill</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-Gfd0l9t4wVv9+KpPX7EaWtS0aL9l+Wb3w/6p6UZ+0VjU8lV+HJW1YQixvI+LyTlq" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-info p-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">TDZ Shop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class=" collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav ms-auto ">
                <li class="nav-item">
                    <a class="nav-link mx-2 active" aria-current="page" href="/list-product">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link mx-2" href="#">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link mx-2" href="#">Pricing</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link mx-2 dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Company
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <li><a class="dropdown-item" href="#">Blog</a></li>
                        <li><a class="dropdown-item" href="#">About Us</a></li>
                        <li><a class="dropdown-item" href="#">Contact us</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto d-none d-lg-inline-flex">
                <li class="nav-item mx-2">
                    <a class="nav-link text-dark h5" href="" target="blank"><i
                            class="fab fa-google-plus-square"></i></a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link text-dark h5" href="" target="blank"><i class="fab fa-twitter"></i></a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link text-dark h5" href="" target="blank"><i class="fab fa-facebook-square"></i></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body">
                    <div class="invoice-title">
                        <h4 class="float-end font-size-15">Ma HD: ${hd.ma} <span
                                class="badge bg-success font-size-12 ms-2">Paid</span></h4>
                        <div class="mb-4">
                            <h2 class="mb-1 text-muted">TDZ.com</h2>
                        </div>
                        <div class="text-muted">
                            <p class="mb-1">80 Xuan Phuong, Nam Tu Liem, Ha Noi</p>
                            <p class="mb-1"><i class="uil uil-envelope-alt me-1"></i> tupmph28142@gmail.com</p>
                            <p><i class="uil uil-phone me-1"></i> 012-345-6789</p>

                        </div>
                    </div>

                    <hr class="my-4">

                    <div class="row">
                        <div class="col-sm-6">
                            <div class="text-muted">
                                <h5 class="font-size-16 mb-3">Khach hang:</h5>
                                <h5 class="font-size-15 mb-2">${hd.tenNguoiNhan}</h5>
                                <p class="mb-1">${hd.diaChi}</p>

                                <p>${hd.sdt}</p>
                                <p><a href="/guest-info" class="btn btn-primary">Edit</a> </p>
                            </div>
                        </div>
                        <!-- end col -->
                        <div class="col-sm-6">
                            <div class="text-muted text-sm-end">
                                <div>
                                    <h5 class="font-size-15 mb-1">Ma Hoa Don:</h5>
                                    <p>${hd.ma}</p>
                                </div>
                                <div class="mt-4">
                                    <h5 class="font-size-15 mb-1">Ngay Tao:</h5>
                                    <p>${hd.ngayTao}</p>
                                </div>

                            </div>
                        </div>
                        <!-- end col -->
                    </div>
                    <!-- end row -->

                    <div class="py-2">
                        <h5 class="font-size-15">Tong tien</h5>

                        <div class="table-responsive">
                            <table class="table align-middle table-nowrap table-centered mb-0">
                                <thead>
                                <tr>
                                    <th style="width: 70px;">No.</th>
                                    <th>Ten san pham</th>
                                    <th>Don gia</th>
                                    <th>So luong</th>
                                    <th class="text-end" style="width: 120px;">Tong tien</th>
                                </tr>
                                </thead><!-- end thead -->
                                <tbody>
                                <c:forEach items="${listhdct}" var="hdct" varStatus="index">
                                <tr>
                                    <th scope="row">${index.index+1}</th>
                                    <td>
                                        <div>
                                            <h5 class="text-truncate font-size-14 mb-1">${hdct.id.chiTietSanPham.sanPham.ten}</h5>
                                            <p class="text-muted mb-0">${hdct.id.chiTietSanPham.dongSanPham.ten}, ${hdct.id.chiTietSanPham.mauSac.ten}</p>
                                        </div>
                                    </td>
                                    <td>${hdct.donGia}</td>
                                    <td>${hdct.soLuong}</td>
                                    <td class="text-end">${hdct.donGia*hdct.soLuong}</td>
                                </tr>
                                <!-- end tr -->

                                    <c:set var="sum" value="${sum + hdct.donGia*hdct.soLuong}" />

                                </c:forEach>
                                <tr>
                                    <th scope="row" colspan="4" class="border-0 text-end">Total</th>
                                    <td class="border-0 text-end"><h4 class="m-0 fw-semibold">${sum}VND</h4></td>
                                </tr>
                                <!-- end tr -->
                                </tbody><!-- end tbody -->
                            </table><!-- end table -->
                        </div><!-- end table responsive -->
                        <div class="d-print-none mt-4">
                            <div class="float-end">

                                <a href="#" onclick="dathang('/bill-success')" class="btn btn-success w-md">Dat hang</a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- end col -->
    </div>
</div>
<footer class="text-center text-lg-start bg-light text-muted">
    <!-- Section: Social media -->
    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
        <!-- Left -->
        <div class="me-5 d-none d-lg-block">
            <span>Get connected with us on social networks:</span>
        </div>
        <!-- Left -->

        <!-- Right -->
        <div>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-facebook-f"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-twitter"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-google"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-instagram"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-linkedin"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-github"></i>
            </a>
        </div>
        <!-- Right -->
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
        <div class="container text-center text-md-start mt-5">
            <!-- Grid row -->
            <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Content -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        <i class="fas fa-gem me-3"></i>Company name
                    </h6>
                    <p>
                        Here you can use rows and columns to organize your footer content. Lorem ipsum
                        dolor sit amet, consectetur adipisicing elit.
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Products
                    </h6>
                    <p>
                        <a href="#!" class="text-reset">Angular</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">React</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Vue</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Laravel</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Useful links
                    </h6>
                    <p>
                        <a href="#!" class="text-reset">Pricing</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Settings</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Orders</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Help</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                    <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                    <p>
                        <i class="fas fa-envelope me-3"></i>
                        info@example.com
                    </p>
                    <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                    <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                </div>
                <!-- Grid column -->
            </div>
            <!-- Grid row -->
        </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
        © 2021 Copyright:
        <a class="text-reset fw-bold" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
</footer>
<script>
    function dathang(url) {
        var confirmed = false;
        var answer=confirm("Ban co muon dat hang?");
        if (answer){
            confirmed=true;
            alert("Dat hang thanh  cong!");
        } else {
            confirmed=false;

        }
        if (confirmed){
            window.location.href=url;
        }
    }
</script>

</body>
</html>

