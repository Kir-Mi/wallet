package com.kirmi.wallet.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Wallet {
    private UUID id;
    private Integer balance;
}
