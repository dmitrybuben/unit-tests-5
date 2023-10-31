package seminars.finalHw;

/*Задание 1. Создайте программу на Python или Java, которая принимает два списка чисел и выполняет следующие действия:
        a. Рассчитывает среднее значение каждого списка.
        b. Сравнивает эти средние значения и выводит соответствующее сообщение:
        - ""Первый список имеет большее среднее значение"", если среднее значение первого списка больше.
        - ""Второй список имеет большее среднее значение"", если среднее значение второго списка больше.
        - ""Средние значения равны"", если средние значения списков равны.*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainTest {
    List<Integer>numbers;
    CalcService calcService = new CalcService();
    CompareService compareService = new CompareService();

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
    }

    @Test
    void checkCalculateAverageValuePositive() {
        numbers.add(2);
        numbers.add(2);

        double aveResult = calcService.getAverage(numbers);

        assertThat(aveResult).isEqualTo(2);
    }

    @Test
    void checkCalculateAverageValueEmpty() {
        double aveResult = calcService.getAverage(numbers);

        assertThat(aveResult).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"2.2, 2.3"})
    void checkCompareServiceTwo(double aveOne, double aveTwo) {

        String res = compareService.compare(aveOne, aveTwo);

        assertThat(res).isEqualTo("Второй список имеет большее среднее значение");
    }
    @ParameterizedTest
    @CsvSource({"2.3, 2.2"})
    void checkCompareServiceOne(double aveOne, double aveTwo) {

        String res = compareService.compare(aveOne, aveTwo);

        assertThat(res).isEqualTo("Первый список имеет большее среднее значение");
    }
    @ParameterizedTest
    @CsvSource({"2.2, 2.2"})
    void checkCompareServiceEqual(double aveOne, double aveTwo) {

        String res = compareService.compare(aveOne, aveTwo);

        assertThat(res).isEqualTo("Средние значения равны");
    }

    @Test
    void checkCalcServiceMock() {
        numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(2);
        numbers.add(2);

        CalcService calcServiceMock = mock(CalcService.class);
        when(calcServiceMock.getAverage(numbers)).thenReturn(1.0);

        Double expected = calcServiceMock.getAverage(numbers);

        assertThat(expected).isEqualTo(1);
    }

    @Test
    void checkProgramUsesCompareService() {

    }
}
