package seminars.finalHw;

import java.util.List;

public class CalcService {
    public double getAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) return 0;
        int res = 0;
        for (Integer number : numbers) {
            res += number;
        }
        return (double) res / numbers.size();
    }
}
