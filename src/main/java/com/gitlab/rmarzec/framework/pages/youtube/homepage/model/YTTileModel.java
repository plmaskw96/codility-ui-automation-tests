package com.gitlab.rmarzec.framework.pages.youtube.homepage.model;

import com.gitlab.rmarzec.framework.pages.youtube.homepage.component.YTTile;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public YTTileModel(WebDriver driver, WebElement wrapper) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(wrapper), this);
    }

    public YTTile toModel() {
        return YTTile.builder()
                .title(title.getText())
                .channel(channel.getText())
                .length(length.getText())
                .build();
    }
}
