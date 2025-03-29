package guru.qa.niffler.test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SpendingTest {

    static {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void doLogin() {
        Selenide.open("http://127.0.0.1:3000/");
        $("input[name='username']").setValue("andrey1");
        $("input[name='password']").setValue("12345");
        $("button[type='submit']").click();
    }

    @Test
    void spendingShouldBeDeletedAfterTableAction() {
        SelenideElement rowWithSpending = $(".MuiTable-root tbody").$$("tr")
                .find(text("Advanced"));
        rowWithSpending.$$("td").first().click();
        $("#delete").click();
        $(".MuiTable-root tbody").$$("tr").shouldHave(CollectionCondition.size(0));
    }
}
