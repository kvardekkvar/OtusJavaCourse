package org.example.storage;

import org.example.money.Banknote;
import org.example.money.WithdrawalResult;

import java.util.List;
import java.util.Map;

public abstract class CashStorage implements MoneyStorage {

    public Map<Integer, CashStorageCell> storageCells;

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

        int remainingToWithdraw = moneyAmountToWithdraw;
        for (int value : sortedBanknoteValues) {

            StorageCell cell = storageCells.get(value);

            while (remainingToWithdraw > 0 && cell.getNumberOfBanknotes() > 0) {
                Banknote banknote = cell.withdrawBanknotes(1).getBanknotes().get(1);
                result.addBanknote(banknote);

                remainingToWithdraw -= value;
            }
        }
        if (remainingToWithdraw == 0) {
            return result;
        } else {
            return new WithdrawalResult().setSuccess(false);
        }

    }
}
