package com.comdolidoli.shoppingmall.demo.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comdolidoli.shoppingmall.demo.domain.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByEmail(String email);
}
