package com.cop.library_rent.repositories;

import com.cop.library_rent.entities.Rent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, String> {
    @Query("SELECT r FROM Rent r WHERE r.user.id = :userId")
    Page<Rent> getRentHistoryByUser(String userId, Pageable pageable);
}
