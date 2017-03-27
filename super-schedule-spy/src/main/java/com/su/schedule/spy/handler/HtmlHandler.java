package com.su.schedule.spy.handler;

import com.su.schedule.spy.resolver.HtmlResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shj on 2017/3/27.
 */
@Component
public class HtmlHandler {
    @Autowired
    private HtmlResolver htmlResolver;




    public void setHtmlResolver(HtmlResolver htmlResolver) {
        this.htmlResolver = htmlResolver;
    }
}
