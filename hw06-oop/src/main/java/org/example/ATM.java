package org.example;

import org.example.dispenser.MoneyDispenser;
import org.example.input.MoneyInput;
import org.example.money.Banknote;
import org.example.money.WithdrawalResult;
import org.example.storage.MoneyStorage;

import java.util.List;

public class ATM {
    MoneyStorage storage;
    MoneyInput input;
    MoneyDispenser dispenser;

    public ATM(MoneyStorage storage, MoneyInput input, MoneyDispenser dispenser) {
        this.storage = storage;
        this.input = input;
        this.dispenser = dispenser;
    }

    public boolean put(List<Banknote> banknotes) {
        return input.put(banknotes);
    }

    public WithdrawalResult withdraw(int moneyAmountToWithdraw) {
        return dispenser.withdraw(moneyAmountToWithdraw);
    }

    public int getTotalBalance() {
        return storage.getTotalBalance();
    }
}
