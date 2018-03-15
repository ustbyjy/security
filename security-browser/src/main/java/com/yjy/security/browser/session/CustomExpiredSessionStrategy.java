package com.yjy.security.browser.session;

import org.apache.http.entity.ContentType;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

public class CustomExpiredSessionStrategy implements SessionInformationExpiredStrategy {

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent eventØ) throws IOException, ServletException {
        eventØ.getResponse().setContentType(ContentType.APPLICATION_JSON.toString());
        eventØ.getResponse().getWriter().write("并发登录！");
    }
}
