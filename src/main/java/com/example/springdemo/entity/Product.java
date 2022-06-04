package com.example.springdemo.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "products")
public class Product {
        @Id
        private String id;
        private String name;
        private String slug;
        private String description;
        private String detail;
        private String price;
        private String thumbnail;
        private String manufacturer;
        @CreationTimestamp
        private LocalDateTime createdAt;
        @UpdateTimestamp
        private LocalDateTime updatedAt;
        private int status;
}
