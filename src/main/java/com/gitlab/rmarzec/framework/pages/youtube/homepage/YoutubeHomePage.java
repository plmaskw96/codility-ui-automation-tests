package com.gitlab.rmarzec.framework.pages.youtube.homepage;

import com.gitlab.rmarzec.framework.pages.youtube.homepage.model.YTTileModel;
import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;
import java.util.stream.Collectors;

public class YoutubeHomePage extends WebPage {

    private By navigationProgress = By.xpath("//yt-page-navigation-progress[@hidden]");

    @FindBy(xpath = "//ytd-page-manager")
    private WebElement pageContainer;

    @FindBy(xpath = ".//ytd-thumbnail-overlay-time-status-renderer")
    private WebElement tileTimeLenght;

    @FindBy(xpath = ".//ytd-rich-item-renderer//div[contains(@class,'ytd-rich-item-renderer')]")
    private List<WebElement> listOfYoutubeFilms;

    public YoutubeHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public YoutubeHomePage isAt() {
        webWaitUtils.waitForPresenceOfAllElementsBy(navigationProgress, Timeouts.MEDIUM);
        return this;
    }

    public YoutubeHomePage isAtWithCookie() {
        webWaitUtils.waitForVisible(tileTimeLenght, Timeouts.MEDIUM);
        return this;
    }

    public YoutubeHomePage scrollToTile(int numberOfTiles) {
        scrollToElement(listOfYoutubeFilms.get(numberOfTiles));
        return new YoutubeHomePage(driver).isAt();
    }

    public YoutubeHomePage printFirstTilesTitleChannelAndLenghtByNumber(int numberOfTiles) {
        System.out.println(listOfYoutubeFilms.stream().parallel().map(webelement -> new YTTileModel(driver, webelement).toModel()).limit(numberOfTiles).collect(Collectors.toList()));
        return this;
    }
}
