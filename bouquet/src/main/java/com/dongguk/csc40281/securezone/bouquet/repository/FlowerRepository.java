package com.dongguk.csc40281.securezone.bouquet.repository;

import com.dongguk.csc40281.securezone.bouquet.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FlowerRepository extends JpaRepository<Flower, Long> {

    @Query(value = "SELECT * FROM flower ORDER BY setseed(?2), random() LIMIT 1", nativeQuery = true)
    Optional<Flower> findRandomFLower(double seed);

    List<Flower> findByNameContaining(String keyword);

}
