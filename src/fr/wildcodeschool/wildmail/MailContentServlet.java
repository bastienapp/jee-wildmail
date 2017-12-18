package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MailContentServlet")
public class MailContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");


        MailBean mailBean = new MailBean();

        // TODO : récupérer l'email en BDD grâce à son ID

        request.setAttribute("mailBean", mailBean);

        this.getServletContext().getRequestDispatcher("/mail_content.jsp").forward(request, response);
    }
}
