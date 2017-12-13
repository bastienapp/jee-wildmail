package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // check GET parameter and set session and cookie
        String loginEmailValue = request.getParameter("loginEmailValue");
        if (loginEmailValue != null && !loginEmailValue.isEmpty()) {
            request.getSession().setAttribute("userEmail", loginEmailValue);
            Cookie cookie = new Cookie("userEmail", loginEmailValue);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        } else {
            // check cookie
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userEmail")) {
                        request.getSession().setAttribute("userEmail", cookie.getValue());
                    }
                }
            }
        }
        request.getRequestDispatcher("/user_login.jsp").forward(request, response);
    }
}
