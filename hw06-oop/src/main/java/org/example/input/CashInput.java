package org.example.input;

import org.example.money.Banknote;
import org.example.storage.MoneyStorage;

import java.util.List;

public class CashInput implements MoneyInput {

    private MoneyStorage storage;

    public CashInput(MoneyStorage storage){
        this.storage = storage;
    }

    @Override
    public boolean put(List<Banknote> banknotes) {
        return storage.put(banknotes);
    }
}
