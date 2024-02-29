package com.kirmi.wallet.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class WalletResponseDto {
    private UUID id;
    private Integer balance;
}
