package com.dongguk.csc40281.securezone.bouquet.repository;

import com.dongguk.csc40281.securezone.bouquet.domain.Cart;
import com.dongguk.csc40281.securezone.bouquet.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findCartByMember(Member member);

}
