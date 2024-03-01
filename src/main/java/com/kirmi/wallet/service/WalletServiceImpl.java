package com.kirmi.wallet.service;

import com.kirmi.wallet.dto.WalletRequestDto;
import com.kirmi.wallet.dto.WalletResponseDto;
import com.kirmi.wallet.entity.Wallet;
import com.kirmi.wallet.exception.MyApplicationException;
import com.kirmi.wallet.mapper.WalletMapper;
import com.kirmi.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final WalletMapper mapper = Mappers.getMapper(WalletMapper.class);

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Retryable(value = Throwable.class, exclude = {MyApplicationException.class})
    public WalletResponseDto updateWallet(WalletRequestDto dto) {
        Wallet wallet = walletRepository.findById(dto.getId())
                .orElseThrow(() -> new MyApplicationException("Кошелёк не найден", HttpStatus.BAD_REQUEST));
        Integer balance = wallet.getBalance();
        Integer amount = dto.getAmount();

        switch (dto.getOperationType()) {
            case "DEPOSIT" -> balance += amount;
            case "WITHDRAW" -> {
                if (balance < amount) {
                    throw new MyApplicationException("На балансе недостаточно средств", HttpStatus.BAD_REQUEST);
                } else {
                    balance -= amount;
                }
            }
            default ->
                    throw new MyApplicationException("Доступны операции DEPOSIT и WITHDRAW", HttpStatus.BAD_REQUEST);
        }
        wallet.setBalance(balance);
        walletRepository.save(wallet);
        return mapper.walletToDto(wallet);
    }

    @Override
    @Transactional
    @Retryable(value = Throwable.class, exclude = {MyApplicationException.class})
    public WalletResponseDto getBalance(UUID id) {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new MyApplicationException("Кошелёк не найден", HttpStatus.BAD_REQUEST));
        return mapper.walletToDto(wallet);
    }
}
