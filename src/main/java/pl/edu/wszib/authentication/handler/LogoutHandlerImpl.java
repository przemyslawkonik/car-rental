package pl.edu.wszib.authentication.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import pl.edu.wszib.util.Const;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogoutHandlerImpl implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        response.addCookie(new Cookie(Const.AUTHENTICATION_COOKIE, "false"));
        response.addCookie(new Cookie(Const.CUSTOMER_SESSION_ID, ""));
    }
}
