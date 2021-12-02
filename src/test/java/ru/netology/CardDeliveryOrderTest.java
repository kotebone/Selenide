package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryOrderTest {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldRegisterPstv() {
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        String day = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(day);
        $(byName("name")).setValue("Екатерина Федосеева");
        $(byName("phone")).setValue("+79123456789");
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id=notification]").shouldHave(exactText("Успешно! Встреча успешно забронирована на " + day), Duration.ofSeconds(15));
    }

    @Test
    void shouldRegisterNgtvPhone(){
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        String day = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(day);
        $(byName("name")).setValue("Екатерина Федосеева");
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id='phone'] .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldRegisterNgtvName(){
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        String day = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(day);
        $(byName("phone")).setValue("+79123456789");
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id='name'] .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldRegisterNgtvCity(){
    String day = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
    $("[placeholder='Дата встречи']").setValue(day);
    $(byName("name")).setValue("Екатерина Федосеева");
    $(byName("phone")).setValue("+79123456789");
    $("[data-test-id=agreement]").click();
    $("[class='button__text']").click();
    $(byClassName("input__sub")).shouldHave(exactText("Поле обязательно для заполнения"));
}

    @Test
    void shouldRegisterNgtvCBox(){
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        String day = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(day);
        $(byName("name")).setValue("Екатерина Федосеева");
        $(byName("phone")).setValue("+79123456789");
        $("[class='button__text']").click();
        $("[data-test-id=agreement]").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных"));
    }

    @Test
    void shouldRegisterNgtvCity2() {
        $("[data-test-id=city] input").setValue("Saint P");
        String day = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(day);
        $(byName("name")).setValue("Екатерина Федосеева");
        $(byName("phone")).setValue("+79123456789");
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $(byClassName("input__sub")).shouldHave(exactText("Доставка в выбранный город недоступна"));
    }

    @Test
    void shouldRegisterNgtvName2() {
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        String day = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(day);
        $(byName("name")).setValue("Ekaterina Fedoseeva");
        $(byName("phone")).setValue("+79123456789");
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id='name'] .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldRegisterNgtvPhone2() {
        $("[data-test-id=city] input").setValue("Санкт-Петербург");
        String day = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(day);
        $(byName("name")).setValue("Екатерина Федосеева");
        $(byName("phone")).setValue("+791234567890");
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id='phone'] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
}