package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.repository;

import com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity.MemberEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByNickname(String nickname);

    boolean existsByNickname(String nickname); //닉네임 중복체크

    boolean existsByPhoneNumber(String phoneNumber);

    MemberEntity findByNameAndPhoneNumber(String name, String phoneNumber);

    Optional<MemberEntity> findByUuid(String uuid);

    Optional<MemberEntity> findAllByNameAndPhoneNumber(String name, String phoneNumber);
}
