package com.example.springbootproject.sell.domain;

import com.example.springbootproject.auth.domain.User;
import com.example.springbootproject.product.domain.Product;
import com.example.springbootproject.size.domain.Size;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
@Table(name = "SELLS")
public class Sell {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "SELL_ID")
    private Long id;

    @JoinColumn(name = "SIZE_ID")
    @ManyToOne
    private Size size;

    @JoinColumn(name = "USER_ID")
    @OneToOne
    private User user;

    @Column(name = "SELL_PRICE")
    private Long price;

    @Column(name = "SELL_CREATED_AT")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "SELL_MATCH_YN")
    private Boolean matchYn;

}
