package org.example;

import org.checkerframework.checker.units.qual.A;
import org.example.dispenser.CashDispenser;
import org.example.dispenser.MoneyDispenser;
import org.example.input.CashInput;
import org.example.input.MoneyInput;
import org.example.storage.CashStorageFactory;
import org.example.storage.MoneyStorage;

public class ATMFactory {

    public static ATM newRubleCashATM() {
        MoneyStorage storage = CashStorageFactory.newRubleCashStorage();
        MoneyInput input = new CashInput(storage);
        MoneyDispenser dispenser = new CashDispenser(storage);

        return new ATM(storage, input, dispenser);
    }

}
