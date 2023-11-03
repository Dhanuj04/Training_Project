package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Insurance;


@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long>{

}
