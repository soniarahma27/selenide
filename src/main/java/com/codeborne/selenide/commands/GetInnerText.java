package com.codeborne.selenide.commands;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementSource;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;

public class GetInnerText implements Command<String> {
  @Override
  @Nonnull
  public String execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
    WebElement element = locator.getWebElement();
    if (locator.driver().browser().isIE()) {
      return element.getAttribute("innerText");
    }
    return element.getAttribute("textContent");
  }
}
