package org.example.input;

import org.example.money.Banknote;

import java.util.List;

public interface MoneyInput {

    boolean put(List<Banknote> banknotes);
}
