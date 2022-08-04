package com.gitlab.rmarzec.framework.utils.locators_utils;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorListUtils {

    @Getter
    private List<WebElement> listOfWebelements;

    public LocatorListUtils (List<WebElement> listOfWebelements) {
        this.listOfWebelements = listOfWebelements;
    }

    public WebElement getElementFromListByName(String name) {
        return listOfWebelements
                .stream()
                .filter(webElement -> webElement.getText().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Element " + name + " not found!!!"));
    }

    public WebElement getElementFromListByValue(String value) {
        return listOfWebelements
                .stream()
                .filter(webElement -> webElement.getAttribute("value").equals(value))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Element with value " + value + " not found!!!"));
    }
}
