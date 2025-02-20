package com.example.Splitwise12.dto;

import lombok.Data;

@Data
public class RegisterUserRequestDto {
   public String UserName;
   public String password;
   public String phoneNumber;
}