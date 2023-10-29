package seminars.five;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.contains;

//Почитать: DOM дерево в Selenium

/*Напишите автоматизированный тест, который выполнит следующие шаги:
        1. Открывает главную страницу Google.
        2. Вводит "Selenium" в поисковую строку и нажимает кнопку "Поиск в Google".
        3. В результатах поиска ищет ссылку на официальный сайт Selenium
        (https://www.selenium.dev) и проверяет, что ссылка действительно присутствует среди
        результатов поиска.*/

public class SeleniumTest {
    WebDriver webDriver;

    @BeforeEach
    void setUp() {
        webDriver = new ChromeDriver();
    }

    @Test
    void checkSeleniumGoogleSearch() throws InterruptedException {
        //1
        webDriver.get("https://www.google.com");
        //2 поиск элемента Поисковая строка - name = "q"
        WebElement element = webDriver.findElement(By.name("q"));
        element.sendKeys("Selenium");
        element.submit();
        //3
        WebElement SeleniumElement = webDriver.findElement(By.tagName("cite"));

        assertThat(SeleniumElement.getText()).isEqualTo("https://www.selenium.dev");

        // Второй вариант поиска - более общий через список элементов, входящих в div.
        List<WebElement> elements = webDriver.findElements(By.cssSelector("div"));
        boolean f = false;
        for (WebElement el: elements) {
            if (el.getText().contains("https://www.selenium.dev")) {
                f = true;
                break;
            }
        }
        assertThat(f).isTrue();
        webDriver.quit();
    }

    /*Нужно написать сквозной тест с использованием Selenium, который авторизует пользователя на
    сайте https://www.saucedemo.com/.
    Данные для входа - логин: "standard_user", пароль: "secret_sauce".
    Проверить, что авторизация прошла успешно и отображаются товары.
    Вам необходимо использовать WebDriver для открытия страницы и методы sendKeys() для ввода
    данных в поля формы, и submit() для отправки формы. После этого, проверьте, что на странице
    отображаются продукты (productsLabel.getText() = "Products")*/
    @Test
    void checkAuthorization() throws InterruptedException {
        //1 поиск
        webDriver.get("https://www.saucedemo.com/");
        WebElement usernameElement = webDriver.findElement(By.id("user-name"));
        WebElement passwordElement = webDriver.findElement(By.id("password"));
        /*варианты поиска:
        webDriver.findElement(By.cssSelector("#user-name"));
        webDriver.findElement(By.xpath("input[@id='user-name']"));*/
        //2 отправка
        usernameElement.sendKeys("standard_user");
        passwordElement.sendKeys("secret_sauce");
        passwordElement.submit();

        //3 утверждение
        WebElement productsLabel = webDriver.findElement(By.cssSelector(".title"));
        assertThat(productsLabel.getText()).isEqualTo("Products");

        Thread.sleep(10000);

        webDriver.quit();
    }
}