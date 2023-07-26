package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Table(name = "mau_sac")
@Entity
@Data
public class MauSac {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String ma;

    private String ten;

    @Override
    public String toString() {
        return "MauSac{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                '}';
    }
}
