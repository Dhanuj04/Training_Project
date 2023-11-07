package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

}