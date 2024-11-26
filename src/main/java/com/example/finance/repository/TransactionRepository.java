package com.example.finance.repository;

import com.example.finance.entity.Transaction;
import com.example.finance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserAndDateBetween(User user, LocalDate startDate, LocalDate endDate);
}
