package com.kirmi.wallet.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class WalletRequestDto {
    private UUID id;
    private String operationType;
    private Integer amount;
}
