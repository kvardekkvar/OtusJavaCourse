package org.example.storage;

import java.util.List;

public class CashStorageFactory {


    public static RubleCashStorage newRubleCashStorage() {
        RubleCashStorage storage = new RubleCashStorage();
        storage = populateCells(RubleCashStorage.rubleBanknoteValues, storage);
        return storage;
    }

    private static <T extends CashStorage> T populateCells(List<Integer> banknoteValues, T storage) {
        for (int banknoteValue : banknoteValues) {
            CashStorageCell storageCell = new CashStorageCell(banknoteValue);
            storage.storageCells.put(banknoteValue, storageCell);
        }
        return storage;
    }

}
