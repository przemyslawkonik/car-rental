package pl.edu.wszib.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.domain.repository.CustomerRepository;
import pl.edu.wszib.util.Const;
import pl.edu.wszib.util.CookieUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/login")
    public Boolean isUserLogged(HttpServletRequest request) {
        Optional<Cookie> cookie = CookieUtils.getCookie(request, Const.AUTHENTICATION_COOKIE);
        return cookie.isPresent() ? Boolean.valueOf(cookie.get().getValue()) : false;
    }

    @GetMapping("/customer")
    public Customer getLoggedCustomer(HttpServletRequest request) {
        Optional<Cookie> cookie = CookieUtils.getCookie(request, Const.CUSTOMER_SESSION_ID);
        return cookie.isPresent() ? customerRepository.findOne(Integer.parseInt(cookie.get().getValue())) : null;
    }
}
