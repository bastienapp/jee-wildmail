package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        String loginEmailValue = request.getParameter("loginEmailValue");
        if (loginEmailValue != null && !loginEmailValue.isEmpty())  {
            request.getSession().setAttribute("userEmail", loginEmailValue);
        }
        String userMail = (String) request.getSession().getAttribute("userEmail");
        if (userMail != null && !userMail.isEmpty()) {
            request.getRequestDispatcher("/mail/create").forward(request, response);
        } else {
            request.getRequestDispatcher("/user_login.jsp").forward(request, response);
        }
    }
}
