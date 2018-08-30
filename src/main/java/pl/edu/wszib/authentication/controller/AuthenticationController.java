package pl.edu.wszib.authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.util.Const;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @GetMapping("/login")
    public Boolean isUserLogged(HttpServletRequest request) {
        if (request != null) {
            Cookie[] requestCookies = request.getCookies();
            if (requestCookies != null) {
                List<Cookie> cookies = Arrays.asList(requestCookies);
                Optional<Cookie> authenticationCookie = cookies.stream().filter(cookie -> cookie.getName().equals(Const.AUTHENTICATION_COOKIE)).findFirst();
                if (authenticationCookie.isPresent()) {
                    return Boolean.valueOf(authenticationCookie.get().getValue());
                }
            }
        }
        return false;
    }
}
