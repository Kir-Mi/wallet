package com.kirmi.wallet.mapper;

import com.kirmi.wallet.dto.WalletResponseDto;
import com.kirmi.wallet.entity.Wallet;
import org.mapstruct.Mapper;

@Mapper
public interface WalletMapper {
    Wallet dtoToWallet(WalletResponseDto dto);

    WalletResponseDto walletToDto(Wallet wallet);
}
