package com.gitlab.rmarzec.stepdefs;

import com.gitlab.rmarzec.framework.pages.youtube.homepage.YoutubeHomePage;
import com.gitlab.rmarzec.framework.pages.youtube.homepage.windows.YouTubeCookieWindow;
import org.openqa.selenium.WebDriver;

public class YoutubeStepdefs extends BaseStepdefs {

    public YoutubeStepdefs(WebDriver driver) {
        super(driver);
    }

    public YoutubeStepdefs openHomePage() {
        driver.get("https://www.youtube.com/");
        new YoutubeHomePage(driver).isAtWithCookie();
        return this;
    }

    public YoutubeStepdefs agreeCookies() {
        new YouTubeCookieWindow(driver)
                .isAt()
                .clickAgreeButton();
        return this;
    }

    public YoutubeStepdefs printFirstTilesTitleChannelAndLenghtByNumber(int numberOfTiles) {
        new YoutubeHomePage(driver).scrollToTile(numberOfTiles);
        new YoutubeHomePage(driver).printFirstTilesTitleChannelAndLenghtByNumber(numberOfTiles);
        return this;
    }
}
