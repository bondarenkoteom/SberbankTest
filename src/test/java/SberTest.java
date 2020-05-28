
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SberTest extends SettingsSberTest {


    @Parameterized.Parameters()
    public static Collection<Object[]> fio() {
        Object[] first = {"Петров", "Перт", "Петрович"};
        Object[] second = {"Иванов", "Иван", "Иванович"};
        Object[] third = {"Александр", "Александр", "Александрович"};
        return Arrays.asList(first, second, third);
    }

    @Parameterized.Parameter(0)
    public String lastName;
    @Parameterized.Parameter(1)
    public String name;
    @Parameterized.Parameter(2)
    public String middleName;


    @Test
    public void firstTest() {

        toPage(mainPage);  // переходим на сайт | 1 пункт ДЗ
        waitUtilClick(insuranceXpath);
        clickXpath(insuranceXpath); // переходим в страхование  | 2 пункт ДЗ

        waitUtilVisible(clickInsuranceXpath); // ждем отображения пункта "Страхование путешественников"
        clickXpath(clickInsuranceXpath); // переходим в пункт "Страхование путешественников" | 3 пункт ДЗ

        waitUtilVisible(waitElementInsuranceXpath);
        Assert.assertTrue("Нет надписи", isDisplayed(waitElementInsuranceXpath));// проверяем надпись на странице "Страхование путешетсвенников" | 4 пункт ДЗ

        waitUtilClick(buttonOnlineCheckOut);
        clickXpath(buttonOnlineCheckOut); // нажимаем на кнопку "Оформить Онлайн" | 5 пункт ДЗ

        waitUtilVisible(minCostXpath);
        waitUtilClick(minCostXpath);
        clickXpath(minCostXpath); // выбираем сумму страховой защиты минимальную, во вкладке "Выбор полиса  выбрать сумму страховой защиты" | 6 пункт ДЗ

        waitUtilClick(buttonCheckOut);
        clickXpath(buttonCheckOut); // нажимаем кнопку "Оформить" | 7 пункт ДЗ

        waitUtilVisible(inputLastName);
        waitUtilClick(inputLastName);
        clickXpath(inputLastName);
        sendKey(inputLastName, "Ivanov"); // ввод фамилии  в поле "Surname" | 8 пункт ДЗ

        waitUtilClick(inputName);
        clickXpath(inputName);
        sendKey(inputName, "Ivan"); // ввод имени  в поле "Name" | 8 пункт ДЗ

        waitUtilClick(dateBirth);
        clickXpath(dateBirth);
        sendKey(dateBirth, "13_04_2000"); // вводим дату рождения в 'Застрахованные' | 8 пункт ДЗ

        waitUtilClick(ru);
        clickXpath(ru); // выбираем граджанство

        clickXpath(sex); // выбираем пол | 8 пункт ДЗ

        waitUtilClick(insLastNameXpath);
        clickXpath(insLastNameXpath);
        sendKey(insLastNameXpath, lastName);// вводим фамилию в поле "Фамилия" во вкладе "Страхователь" | 8 пункт ДЗ

        waitUtilClick(insNameXpath);
        clickXpath(insNameXpath);
        sendKey(insNameXpath, name);// вводим имя в поле "Имя" во вкладе "Страхователь" | 8 пункт ДЗ

        waitUtilClick(insMiddleNameXpath);
        clickXpath(insMiddleNameXpath);
        sendKey(insMiddleNameXpath, middleName);// вводим отчество в поле "Отчество" во вкладе "Страхователь" | 8 пункт ДЗ

        waitUtilClick(inputDateIns);
        clickXpath(inputDateIns);
        sendKey(inputDateIns, "18_08_1980");// вводим дату рождения в 'Страхователь' | 8 пункт ДЗ


        waitUtilClick(inputPasSer);
        clickXpath(inputPasSer);
        sendKey(inputPasSer, "1111");// вводим серию паспорта  в 'Страхователь' | 8 пункт ДЗ

        waitUtilClick(inputPasNam);
        clickXpath(inputPasNam);
        sendKey(inputPasNam, "111_111");// вводим номер паспорта в 'Страхователь' | 8 пункт ДЗ

        waitUtilClick(giveDatePas);
        clickXpath(giveDatePas);
        sendKey(giveDatePas, "10_10_2000");// вводим дату в "Дату выдачи"  в 'Страхователь' | 8 пункт ДЗ

        waitUtilClick(givePas);
        clickXpath(givePas);
        sendKey(givePas, "Кем то");// вводим в поле "Кем выдан" в Страхователь' | 8 пункт ДЗ

        Assert.assertEquals("Поле 'Surname' не соответствует ожиданию", "Ivanov",
                getAttribute(inputLastName, "value")); // проверяем поле 'Surname' в 'Застрахованные' | 9 пункт ДЗ

        Assert.assertEquals("Поле 'Name' не соответствует ожиданию", "Ivan",
                getAttribute(inputName, "value"));  // проверяем поле 'Name'  в 'Застрахованные'| 9 пункт ДЗ

        Assert.assertEquals("Поле 'Дата рождения'не соответствует ожиданию",
                "13.04.2000", getAttribute(dateBirth, "value")); // проверяем поле 'Дата рождения' в 'Застрахованные' | 9 пункт ДЗ

        Assert.assertEquals("Поле 'Фамилия' не соответствует ожиданию",
                lastName, getAttribute(insLastNameXpath, "value")); // проверяем поле 'Фамилия' в 'Страхователь' | 9 пункт ДЗ

        Assert.assertEquals("Поле 'Имя' не соответствует ожиданию",
                name, getAttribute(insNameXpath, "value")); // проверяем поле 'Имя' в 'Страхователь' | 9 пункт ДЗ

        Assert.assertEquals("Поле 'Отчество' не соответствует ожиданию",
                middleName, getAttribute(insMiddleNameXpath, "value")); // проверяем поле 'Отчество' в 'Страхователь' | 9 пункт ДЗ

        Assert.assertEquals("Поле 'Дата рождения' не соответствует ожиданию",
                "18.08.1980", getAttribute(inputDateIns, "value")); // проверяем поле 'Дата рождения' в 'Страхователь' | 9 пункт ДЗ

        Assert.assertEquals("Поле 'Серия' не соответствует ожиданию",
                "1111", getAttribute(inputPasSer, "value")); // проверяем поле 'Серия' в 'Паспортные данные' | 9 пункт ДЗ

        Assert.assertEquals("Поле 'Номер' не соответствует ожиданию",
                "111111", getAttribute(inputPasNam, "value")); // проверяем поле 'Номер' в 'Паспортные данные' | 9 пункт ДЗ

        Assert.assertEquals("Поле 'Дата выдачи' не соответствует ожиданию",
                "10.10.2000", getAttribute(giveDatePas, "value")); // проверяем поле 'Дата выдачи' в 'Паспортные данные' | 9 пункт ДЗ

        Assert.assertEquals("Поле 'Кем выдан' не соответствует ожиданию",
                "Кем то", getAttribute(givePas, "value")); // проверяем поле 'Кем выдан' в 'Паспортные данные' | 9 пункт ДЗ

        waitUtilClick(butCon);
        clickXpath(butCon); // нажимаем кнопку "Продолжить"| 10 пункт ДЗ

        waitUtilVisible(wrongMes);
        Assert.assertTrue("Нет надписи", isDisplayed(wrongMes)); // проверка сообщения ,что поле не заполнено | 11 пункт ДЗ


    }


}
