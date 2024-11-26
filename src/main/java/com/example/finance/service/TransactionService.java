package com.example.finance.service;

import com.example.finance.dto.TransactionDTO;
import com.example.finance.entity.Transaction;
import com.example.finance.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    public TransactionService(TransactionRepository transactionRepository, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    @Transactional
    public TransactionDTO createTransaction(TransactionDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setUser(userService.getCurrentUser());
        transaction.setDate(dto.getDate());
        transaction.setDescription(dto.getDescription());
        transaction.setType(dto.getType());
        transaction.setCategory(dto.getCategory());
        transaction.setAmount(dto.getAmount());
        transaction.setNotes(dto.getNotes());

        Transaction saved = transactionRepository.save(transaction);
        return convertToDTO(saved);
    }

    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transaction.getId());
        dto.setDate(transaction.getDate());
        dto.setDescription(transaction.getDescription());
        dto.setType(transaction.getType());
        dto.setCategory(transaction.getCategory());
        dto.setAmount(transaction.getAmount());
        dto.setNotes(transaction.getNotes());
        return dto;
    }
}