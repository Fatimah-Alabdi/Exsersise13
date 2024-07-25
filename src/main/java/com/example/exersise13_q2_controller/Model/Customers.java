package com.example.exersise13_q2_controller.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {
    private String id;
    private String username;
    private double balance;
}
