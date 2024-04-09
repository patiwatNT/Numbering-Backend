package com.billng.numbering.repository;

import com.billng.numbering.entities.NumberingUsers;
import com.billng.numbering.repositoryCustom.NumberingUsersRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface NumberingUsersRepository extends JpaRepository<NumberingUsers, BigDecimal>, JpaSpecificationExecutor<NumberingUsers> , NumberingUsersRepositoryCustom {

}