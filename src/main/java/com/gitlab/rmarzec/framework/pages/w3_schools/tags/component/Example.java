package com.gitlab.rmarzec.framework.pages.w3_schools.tags.component;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.openqa.selenium.WebElement;

@Getter
@ToString
@Builder
public class Example {
    private String description;
    private WebElement bodyLocator;
    private WebElement tryItYourselfButton;
}
