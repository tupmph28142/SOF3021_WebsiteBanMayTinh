package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.IdHoaDonChiTiet;
import com.example.demo.model.Item;
import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.repository.HoaDonRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller

public class GiaoDienGioHangController {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    private UUID maGet;

    @GetMapping("/cart")
    public String theme() {
        return "giao-dien-gio-hang";
    }

    @GetMapping("/list-product")
    public String getProduct(Model model) {
        ArrayList<ChiTietSanPham> listctsp = (ArrayList<ChiTietSanPham>) chiTietSanPhamRepository.findAll();


        model.addAttribute("listCTSP", listctsp);


        return "danh-sach-san-pham";
    }

    @GetMapping("/thanh-toan")
    public String thanhToan() {
        return "check-out";
    }


    @GetMapping("/cart/add")
    public String addToCart(@RequestParam("idCtsp") UUID id) {
        // lấy ctsp từ repo
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id).get();
        // tạo ra giỏ hàng chi tiết
        Item item = new Item(chiTietSanPham.getId(),
                chiTietSanPham.getSanPham().getTen(),
                chiTietSanPham.getMauSac().getTen(),
                1,
                chiTietSanPham.getGiaBan()
        );
        //lấy gior hàng từ session
        Cart cartSession = (Cart) httpSession.getAttribute("cart");
        if (cartSession == null) {// nếu chưa có giỏ hàng
            Cart cart = new Cart();
            List<Item> list = new ArrayList<>();
            list.add(item);
            cart.setItems(list);
            httpSession.setAttribute("cart", cart);
        } else {// nếu có giỏ hàng
            Cart cart = (Cart) httpSession.getAttribute("cart");
            List<Item> listItem = cart.getItems();
            // kieemr tra sản phẩm đã có trong giỏ hàng chưa
            // nếu có thì tăng số lwonjg lên 1

            for (Item itemTmp : listItem) {
                if (itemTmp.getIdCtsp().equals(id)) {
                    if (itemTmp.getSoLuong() < 10) { // Kiểm tra số lượng trước khi tăng lên
                        itemTmp.setSoLuong(itemTmp.getSoLuong() + 1);
                    }

                    return "redirect:/list-product";
                }
            }
            // không có thì thêm sản phẩm vào
            listItem.add(item);


        }
        return "redirect:/list-product";
    }
    @GetMapping("/giam")
    public String giam(){
        return null;
    }

    @GetMapping("cart/view")
    public String addToCart(Model model) {
        Cart cart = (Cart) httpSession.getAttribute("cart");

        List<Item> list = cart.getItems();
        model.addAttribute("gioHangChiTiet", list);
        return "giao-dien-gio-hang";
    }
    @GetMapping("/check-out")
    public String taoHoaDon(){
        Random random = new Random();
        //random ma hoa don
        int maHDRandom = random.nextInt(900) + 100;
        String maHD = "HD" + String.valueOf(maHDRandom);
        //tao ngay
        LocalDate localDate = LocalDate.now();

        Integer tinhTrang = 0;
        String tenNguoiNhan = "Minh Tu";
        String diaChi = "1 Trinh Van Bo, Nam Tu Liem";
        String sdt = "098999999";
        HoaDon hoaDon = new HoaDon(maHD, Date.valueOf(localDate), tinhTrang, tenNguoiNhan, diaChi, sdt);
        hoaDonRepository.save(hoaDon);
        System.out.println(hoaDon);
        maGet = hoaDon.getId();
        UUID idHoaDon = hoaDon.getId();
        System.out.println(maGet);

        Cart cart = (Cart) httpSession.getAttribute("cart");
        List<Item> lists = cart.getItems();
        List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
        for (Item item : lists) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            HoaDon hoaDon1 = new HoaDon();
            hoaDon1.setId(idHoaDon);
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
            chiTietSanPham.setId(item.getIdCtsp());
            hoaDonChiTiet.setId(new IdHoaDonChiTiet(hoaDon1,chiTietSanPham));
            hoaDonChiTiet.setSoLuong(item.getSoLuong());
            hoaDonChiTiet.setDonGia(item.getGiaBan());
            hoaDonChiTiets.add(hoaDonChiTiet);

        }
        hoaDonChiTietRepository.saveAll(hoaDonChiTiets);
        return "redirect:/bill-theme";
    }


    @GetMapping("/guest-info")
    public String thanhToan(Model model

    ) {




//        for (Item item: list){
//          UUID maCTSP=  item.getIdCtsp();
//        }
//
//        Item item = new Item();
//
//       int soLuong= item.getSoLuong();


        return "check-out";
    }
    @PostMapping("/check-out/add")
    public String addHD(@RequestParam("tenNguoiNhan") String ten1,
                        @RequestParam("sdt") String sdt1,
                        @RequestParam("diaChi") String diaChi1){
        HoaDon hoaDon1 = hoaDonRepository.findById(maGet).get();

        hoaDon1.setId(maGet);
        hoaDon1.setTenNguoiNhan(ten1);
        hoaDon1.setSdt(sdt1);
        hoaDon1.setDiaChi(diaChi1);

        hoaDonRepository.save(hoaDon1);
        System.out.println("Ma HD:"+maGet);
        return "redirect:/bill-theme";

    }

    @GetMapping("/bill-theme")
    public String bill(Model model) {


        HoaDon hoaDon = hoaDonRepository.findById(maGet).get();
        model.addAttribute("hd", hoaDon);
        List<HoaDonChiTiet> hoaDonChiTiets = hoaDonChiTietRepository.findAll();
        model.addAttribute("listhdct",hoaDonChiTiets);


        return "bill";

    }

    @GetMapping("/bill-success")
    public String billSuccess() {
        HoaDon hoaDon = hoaDonRepository.findById(maGet).get();
        hoaDon.setTinhTrang(1);
        hoaDonRepository.save(hoaDon);
        return "redirect:/list-product";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") UUID id){
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id).get();
        model.addAttribute("ctsp",chiTietSanPham);
        return "detail";
    }

    @GetMapping("/order-history")
    public String history(Model model){
       List<HoaDonChiTiet> hoaDonChiTiet = hoaDonChiTietRepository.findAll();

        model.addAttribute("hdct",hoaDonChiTiet);
        return  "order-history";
    }


}

