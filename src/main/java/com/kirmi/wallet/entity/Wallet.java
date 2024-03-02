package com.kirmi.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "wallet")
public class Wallet {
    @Id
    private UUID id;
    private Integer balance;
}
