package pl.edu.wszib.authentication.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.edu.wszib.domain.entity.Customer;
import pl.edu.wszib.domain.repository.CustomerRepository;
import pl.edu.wszib.util.Const;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Customer customer = customerRepository.findByEmail(authentication.getName());
        response.addCookie(new Cookie(Const.AUTHENTICATION_COOKIE, "true"));
        response.addCookie(new Cookie(Const.CUSTOMER_SESSION_ID, "" + customer.getId()));
        response.sendRedirect("/");
    }
}
