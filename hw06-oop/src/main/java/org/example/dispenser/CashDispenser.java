package org.example.dispenser;

import org.example.money.WithdrawalResult;
import org.example.storage.MoneyStorage;

public class CashDispenser implements MoneyDispenser {

    private MoneyStorage storage;

    public CashDispenser(MoneyStorage storage) {
        this.storage = storage;
    }

    @Override
    public WithdrawalResult withdraw(int moneyAmountToWithdraw) {
        return storage.withdraw(moneyAmountToWithdraw);
    }
}
