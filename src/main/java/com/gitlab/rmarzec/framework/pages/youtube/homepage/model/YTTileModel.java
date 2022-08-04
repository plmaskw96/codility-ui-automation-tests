package com.gitlab.rmarzec.framework.pages.youtube.homepage.model;

import com.gitlab.rmarzec.framework.pages.youtube.homepage.component.YTTile;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class YTTileModel extends WebPage {

    @FindBy(xpath = ".//yt-formatted-string[@id='video-title']")
    private WebElement title;

    @FindBy(xpath = ".//div[contains(@class, 'ytd-channel-name')]//a")
    private WebElement channel;

    @FindBy(xpath = ".//ytd-thumbnail-overlay-time-status-renderer/span")
    private WebElement length;

    @FindBy(xpath = ".//div[contains(@class, 'badge-style-type-live-now-alternate')]//span")
    private WebElement live;

    public YTTileModel(WebDriver driver, WebElement wrapper) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(wrapper), this);
    }

    public YTTile toModel() {
        return YTTile.builder()
                .title(title.getText())
                .channel(channel.getText())
                .length(isDisplayed(live) ? live.getAttribute("innerHTML").trim() : length.getAttribute("innerHTML").trim())
                .build();
    }
}
