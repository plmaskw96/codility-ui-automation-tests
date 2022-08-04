package com.gitlab.rmarzec.framework.pages.youtube.homepage;

import com.gitlab.rmarzec.framework.pages.youtube.homepage.component.YTTile;
import com.gitlab.rmarzec.framework.pages.youtube.homepage.model.YTTileModel;
import com.gitlab.rmarzec.framework.pages.youtube.homepage.section.YouTubeTrendingSection;
import com.gitlab.rmarzec.framework.utils.Timeouts;
import com.gitlab.rmarzec.framework.utils.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;
import java.util.stream.Collectors;

public class YoutubeHomePage extends WebPage {

    @FindBy(xpath = "//ytd-page-manager")
    private WebElement pageContainer;

    @FindBy(xpath = ".//ytd-thumbnail-overlay-time-status-renderer")
    private WebElement tileTimeLenght;

    @FindBy(xpath = ".//ytd-thumbnail-overlay-time-status-renderer/ancestor::div[contains(@class,'ytd-rich-item-renderer')]")
    private List<WebElement> listOfYoutubeFilms;

    private List<YTTile> youTubeFilmsList;

    public YoutubeHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(pageContainer), this);
    }

    public YoutubeHomePage isAt() {
        webWaitUtils.waitForVisible(tileTimeLenght, Timeouts.MEDIUM);
        return this;
    }

    public YoutubeHomePage printFirstTilesTitleChannelAndLenghtByNumber(int numberOfTiles) {
        youTubeFilmsList = listOfYoutubeFilms.stream().map(webelement -> new YTTileModel(driver, webelement).toModel()).collect(Collectors.toList());

        //Some tiles are hidden, if last tile on the list has no readed lenght, move to and expand Trendings.
        if (youTubeFilmsList.get(youTubeFilmsList.size() - 1).getLength().isEmpty()) {
            getTrendingSection().expandTrendingSection();
            youTubeFilmsList = listOfYoutubeFilms.stream().map(webelement -> new YTTileModel(driver, webelement).toModel()).collect(Collectors.toList());
        }
        System.out.println(youTubeFilmsList.stream().map(YTTile::toString).limit(numberOfTiles).collect(Collectors.toList()));
        return this;
    }

    public YouTubeTrendingSection getTrendingSection() {
        return new YouTubeTrendingSection(driver);
    }
}
