package org.example.storage;

import org.example.money.Banknote;
import org.example.money.WithdrawalResult;

import java.util.List;

public interface StorageCell {


    int getTotalMoneyAmount();

    int getNumberOfBanknotes();

    int getBanknoteValue();

    boolean putBanknotes(List<Banknote> banknotes);

    WithdrawalResult withdrawBanknotes(int numberOfBanknotesToWithdraw);
}
