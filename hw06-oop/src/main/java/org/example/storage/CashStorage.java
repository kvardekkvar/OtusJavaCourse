package org.example.storage;

import lombok.extern.java.Log;
import org.example.money.Banknote;
import org.example.money.WithdrawalResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log
public abstract class CashStorage implements MoneyStorage {

    public Map<Integer, CashStorageCell> storageCells = new HashMap<>();

    @Override
    public int getTotalBalance() {
        return storageCells.values().stream().mapToInt(CashStorageCell::getTotalMoneyAmount).sum();
    }

    @Override
    public boolean put(List<Banknote> banknotes) {
        try {
            for (Banknote banknote : banknotes) {
                CashStorageCell storageCell = storageCells.get(banknote.getValue());
                boolean result = storageCell.putBanknotes(List.of(banknote));
                if (!result) {
                    return false;
                }
            }
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public WithdrawalResult withdraw(int moneyAmountToWithdraw) {

        WithdrawalResult result = new WithdrawalResult();

        List<Integer> sortedBanknoteValues = storageCells.keySet().stream().sorted((x, y) -> Integer.compare(y, x)
        ).toList();

        log.info(sortedBanknoteValues.toString());

        int remainingToWithdraw = moneyAmountToWithdraw;
        for (int value : sortedBanknoteValues) {

            StorageCell cell = storageCells.get(value);

            while (remainingToWithdraw > 0 && cell.getNumberOfBanknotes() > 0 && remainingToWithdraw >= cell.getBanknoteValue()) {

                WithdrawalResult withdrawalResult = cell.withdrawBanknotes(1);
                if (withdrawalResult.isSuccess()) {
                    Banknote banknote = withdrawalResult.getBanknotes().get(0);
                    result.addBanknote(banknote);

                    remainingToWithdraw -= value;
                } else {
                    result.setSuccess(false);
                    return result;
                }
            }
        }
        if (remainingToWithdraw == 0) {
            result.setSuccess(true);
            return result;
        } else {
            return new WithdrawalResult().setSuccess(false);
        }

    }
}
