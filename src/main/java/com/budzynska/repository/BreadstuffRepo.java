package com.budzynska.repository;

import com.budzynska.domain.Breadstuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreadstuffRepo extends JpaRepository<Breadstuff, Long> {
}
