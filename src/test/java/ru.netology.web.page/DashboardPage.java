package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");

    private SelenideElement card1Button = $$(By.className("button_view_extra")).first();
    private SelenideElement card2Button = $$(By.className("button_view_extra")).last();
    private SelenideElement balanceCard1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement balanceCard2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public void dashboardPageVisible() {
        heading.shouldBe(Condition.visible);
    }

    public MoneyTransfer card1() {
        card1Button.click();
        return new MoneyTransfer();
    }

    public MoneyTransfer card2() {
        card2Button.click();
        return new MoneyTransfer();
    }

    public int getBalanceCard1() {
        String text = balanceCard1.getText();
        String[] subtext = text.split(":");
        String balance = subtext[1].substring(0, subtext[1].indexOf("р.")).trim();
        return Integer.parseInt(balance);

    }

    public int getBalanceCard2() {
        String text = balanceCard2.getText();
        String[] subtext = text.split(":");
        String balance = subtext[1].substring(0, subtext[1].indexOf("р.")).trim();
        return Integer.parseInt(balance);

    }
}