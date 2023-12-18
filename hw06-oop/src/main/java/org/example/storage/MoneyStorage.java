package org.example.storage;

import org.example.money.Banknote;
import org.example.money.WithdrawalResult;

import java.util.List;

public interface MoneyStorage {

    boolean put(List<Banknote> banknotes);

    WithdrawalResult withdraw(int moneyAmountToWithdraw);

    int getTotalBalance();
}
