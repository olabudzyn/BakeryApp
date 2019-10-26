package com.budzynska.repository;

import com.budzynska.domain.BreadstuffType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreadstuffTypeRepo extends JpaRepository<BreadstuffType, Long> {
}
