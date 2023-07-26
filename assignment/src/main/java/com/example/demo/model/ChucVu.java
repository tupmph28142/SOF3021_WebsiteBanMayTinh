package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Table(name = "chuc_vu")
@Entity
@Data
public class ChucVu {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Mã không được để trống")
    @Column(name = "ma")
    private String ma;

//    @NotBlank(message = "Tên không được để trống")
//    @Size(min = 4, message = "Tên chức vụ phải lớn hơn hoặc bằng 4 ký tự")
    @Column(name = "ten")
    private String ten;


}
