package com.kirmi.wallet.service;

import com.kirmi.wallet.dto.WalletRequestDto;
import com.kirmi.wallet.dto.WalletResponseDto;

import java.util.UUID;

public interface WalletService {
    WalletResponseDto updateWallet(WalletRequestDto walletRequestDto);

    WalletResponseDto getBalance(UUID id);
}
