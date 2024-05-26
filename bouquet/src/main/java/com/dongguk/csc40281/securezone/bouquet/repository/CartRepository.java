package com.dongguk.csc40281.securezone.bouquet.repository;

import com.dongguk.csc40281.securezone.bouquet.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
