package ucu.edu.ua.atm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public abstract class Banknote {
    private Banknote nextItem;
    private int banknoteNominale;
    public void process(int amount) {
        int quantity = amount / banknoteNominale;
        int rest = amount % banknoteNominale;
        if (nextItem != null){
            nextItem.process(rest);
        }else{
            if (rest > 0) {
                throw new IllegalArgumentException();
            }
        }
        if (quantity != 0) {
            System.out.format("Pleaser recieve %d x %d\n", quantity, banknoteNominale);
        }
    }
}