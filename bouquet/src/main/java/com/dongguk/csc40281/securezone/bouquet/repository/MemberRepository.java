package com.dongguk.csc40281.securezone.bouquet.repository;

import com.dongguk.csc40281.securezone.bouquet.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);

}
