package com.example.bankapppro.dto;

import com.example.bankapppro.entity.ClientStatus;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ClientDto {
    private Long id;
    private ClientStatus status;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
