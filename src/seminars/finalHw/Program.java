package seminars.finalHw;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        CalcService calcService = new CalcService();
        CompareService compareService = new CompareService();
        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();
        listOne.add(1);
        listOne.add(2);
        listOne.add(3);
        listTwo.add(2);
        listTwo.add(3);
        listTwo.add(4);
        double aveNumOne = calcService.getAverage(listOne);
        double aveNumTwo = calcService.getAverage(listTwo);
        System.out.println(compareService.compare(aveNumOne, aveNumTwo));
    }
}
