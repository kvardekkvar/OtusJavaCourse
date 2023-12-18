package org.example.storage;

import org.example.money.Banknote;
import org.example.money.WithdrawalResult;

import java.util.List;

public class RubleCashStorage extends CashStorage {
    public static final List<Integer> rubleBanknoteValues = List.of(10, 50, 100, 200, 500, 1000, 2000, 5000);


}
