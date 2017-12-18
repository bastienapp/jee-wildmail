package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MailListServlet")
public class MailListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<MailBean> mailList = new ArrayList<>();

        // TODO : récupérer la liste des emails en BDD

        request.setAttribute("mailList", mailList);

        this.getServletContext().getRequestDispatcher("/mail_list.jsp").forward(request, response);
    }
}
