package com.codeborne.selenide.commands;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.ScreenShotLaboratory;
import com.codeborne.selenide.impl.WebElementSource;

import javax.annotation.Nullable;
import java.awt.image.BufferedImage;

public class TakeScreenshotAsImage implements Command<BufferedImage> {
  @Override
  @Nullable
  public BufferedImage execute(SelenideElement proxy, WebElementSource element, Object[] args) {
    return ScreenShotLaboratory.getInstance().takeScreenshotAsImage(element.driver(), element.getWebElement());
  }
}
