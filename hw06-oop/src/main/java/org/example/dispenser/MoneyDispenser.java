package org.example.dispenser;

import org.example.money.WithdrawalResult;

public interface MoneyDispenser {

    WithdrawalResult withdraw(int moneyAmountToWithdraw);
}
