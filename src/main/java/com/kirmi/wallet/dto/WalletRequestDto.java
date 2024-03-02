package com.kirmi.wallet.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.UUID;

@Data
public class WalletRequestDto {
    @Pattern(regexp = "\\b[0-9A-F]{8}-[0-9A-F]{4}-[0-9A-F]{4}-[0-9A-F]{4}-[0-9A-F]{12}\\b", message = "Некорректный id")
    private UUID id;
    private String operationType;
    @Positive(message = "Сумма должна быть положительной")
    private Integer amount;
}
