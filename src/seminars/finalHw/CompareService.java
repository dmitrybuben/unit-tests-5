package seminars.finalHw;

public class CompareService {

    public String compare(double aveOne, double aveTwo) {
        if (aveOne > aveTwo) return "Первый список имеет большее среднее значение";
        else if(aveOne < aveTwo) return "Второй список имеет большее среднее значение";
        else return "Средние значения равны";
    }
}
