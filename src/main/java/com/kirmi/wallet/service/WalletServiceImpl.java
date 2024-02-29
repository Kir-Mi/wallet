package com.kirmi.wallet.service;

import com.kirmi.wallet.dto.WalletRequestDto;
import com.kirmi.wallet.dto.WalletResponseDto;
import com.kirmi.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    public WalletResponseDto updateWallet(WalletRequestDto walletRequestDto) {

    }

    public WalletResponseDto getBalance(UUID id) {

    }
}
