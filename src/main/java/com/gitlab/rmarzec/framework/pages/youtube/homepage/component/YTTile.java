package com.gitlab.rmarzec.framework.pages.youtube.homepage.component;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class YTTile {
    String title;
    String channel;
    String length;

    @Override
    public String toString() {
        return "\nTitle: " + getTitle() + ",\n" +
                "Channel: " + getChannel() + ",\n" +
                "Lenght: " + getLength() + "\n";
    }
}
