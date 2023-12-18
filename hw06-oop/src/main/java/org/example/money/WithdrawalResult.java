package org.example.money;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalResult {

    private boolean isSuccess;

    private List<Banknote> banknotes = new ArrayList<>();

    public void addBanknote(Banknote banknote){
        banknotes.add(banknote);
    }
}
