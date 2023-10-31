package seminars.five.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberModule {
    Random random = new Random();

    public List<Integer> getList(int numbersQty) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbersQty; i++) {
            list.add(random.nextInt(10));
        }
        return list;
    }
}
