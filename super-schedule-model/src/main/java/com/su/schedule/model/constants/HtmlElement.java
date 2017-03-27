package com.su.schedule.model.constants;

/**
 * Created by shj on 2017/3/27.
 */
public enum HtmlElement {
    TR("tr"),TD("td"),TITLE("title"),TBODY("tbody");

    private String name;

    HtmlElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
