package com.kirmi.wallet.controller;

import com.kirmi.wallet.dto.WalletRequestDto;
import com.kirmi.wallet.dto.WalletResponseDto;
import com.kirmi.wallet.service.WalletServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class WalletController {
    private final WalletServiceImpl walletService;

    @PostMapping("/wallet")
    public WalletResponseDto updateWallet(@RequestBody WalletRequestDto walletRequestDto) {
        return walletService.updateWallet(walletRequestDto);
    }

    @GetMapping("/wallets/{WALLET_UUID}")
    public WalletResponseDto getBalance(@PathVariable(value = "WALLET_UUID") UUID id) {
        return walletService.getBalance(id);
    }
}
