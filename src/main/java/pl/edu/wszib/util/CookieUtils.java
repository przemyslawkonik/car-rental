package pl.edu.wszib.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CookieUtils {

    public static Optional<Cookie> getCookie(HttpServletRequest request, String cookieName) {
        if (request != null) {
            Cookie[] requestCookies = request.getCookies();
            if (requestCookies != null) {
                List<Cookie> cookies = Arrays.asList(requestCookies);
                return cookies.stream().filter(cookie -> cookie.getName().equals(cookieName)).findFirst();
            }
        }
        return Optional.empty();
    }
}
