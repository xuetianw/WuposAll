package com.wupos.ucd.repository;

import com.wupos.ucd.entity.Compliance;
import com.wupos.ucd.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByPcp(Long pcp);
    @Query("SELECT u.compliance FROM User u WHERE u.pcp = :pcp")
    Compliance findComplianceByPcp(@Param("pcp") long pcp);
}
