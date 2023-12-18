package org.example.storage;

import lombok.extern.java.Log;
import org.example.money.Banknote;
import org.example.money.WithdrawalResult;

import java.util.ArrayList;
import java.util.List;
@Log
public class CashStorageCell implements StorageCell {

    public final Integer banknoteValue;

    private Integer numberOfBanknotes;

    private List<Banknote> banknotes;

    public CashStorageCell(int banknoteValue) {
        this.banknoteValue = banknoteValue;
        this.numberOfBanknotes = 0;
        this.banknotes = new ArrayList<>();
    }

    @Override
    public int getTotalMoneyAmount() {
        return getNumberOfBanknotes() * getBanknoteValue();
    }

    @Override
    public int getNumberOfBanknotes() {
        return numberOfBanknotes;
    }

    @Override
    public int getBanknoteValue() {
        return banknoteValue;
    }

    @Override
    public boolean putBanknotes(List<Banknote> newBanknotes) {
        try {
            this.numberOfBanknotes += newBanknotes.size();
            this.banknotes.addAll(newBanknotes);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public WithdrawalResult withdrawBanknotes(int numberOfBanknotesToWithdraw) {
        log.info("WITHDRAWING " + banknoteValue + " x " + numberOfBanknotesToWithdraw);
        WithdrawalResult result = new WithdrawalResult();

        if (numberOfBanknotesToWithdraw > numberOfBanknotes) {
            result.setSuccess(false);
            return result;
        }

        try {
            List<Banknote> withdrawnBanknotes = banknotes.subList(0, numberOfBanknotesToWithdraw);
            banknotes = banknotes.subList(numberOfBanknotesToWithdraw, numberOfBanknotes);
            numberOfBanknotes -= numberOfBanknotesToWithdraw;

            result.setBanknotes(withdrawnBanknotes);
            result.setSuccess(true);
        } catch (Exception exception) {
            result.setBanknotes(new ArrayList<>());
            result.setSuccess(false);
        }

        return result;
    }


}
