package org.example;

import org.example.money.Banknote;
import org.example.money.RubleBanknote;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Banknote> wage = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Banknote banknote = new RubleBanknote().setValue(5000);
            wage.add(banknote);
        }

        wage.add(new RubleBanknote().setValue(500));
        wage.add(new RubleBanknote().setValue(1000));
        wage.add(new RubleBanknote().setValue(500));

        ATM atm = ATMFactory.newRubleCashATM();
        System.out.printf("Total deposit: %s\n", atm.getTotalBalance());
        atm.put(wage);
        System.out.printf("Total deposit: %s\n", atm.getTotalBalance());
        var result = atm.withdraw(1500);
        System.out.printf("SUCCESS: %s\n",result.isSuccess());
        System.out.printf("Total deposit: %s\n", atm.getTotalBalance());

    }
}