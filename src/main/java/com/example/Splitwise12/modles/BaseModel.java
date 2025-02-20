package com.example.Splitwise12.modles;

import jakarta.persistence.*;
import lombok.Data;
@Data
@MappedSuperclass
public class BaseModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
}