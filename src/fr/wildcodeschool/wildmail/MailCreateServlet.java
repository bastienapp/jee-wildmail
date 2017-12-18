package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MailCreateServlet")
public class MailCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get POST mail params
        request.setCharacterEncoding("UTF-8");
        String userEmail = (String) request.getSession().getAttribute("userEmail");
        String createToValue = request.getParameter("createToValue");
        String createSubjectValue = request.getParameter("createSubjectValue");
        String createContentValue = request.getParameter("createContentValue");

        // TODO : ajouter l'email en BDD

        // redirect to /mail/list
        response.sendRedirect(request.getContextPath() + "/mail/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/mail_create.jsp").forward(request, response);
    }
}
