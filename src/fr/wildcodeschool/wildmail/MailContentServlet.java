package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MailContentServlet")
public class MailContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        boolean success = false;
        if (id != null && !id.isEmpty()) {
            List<MailBean> mailList = new ArrayList<>();
            // TODO : récupère la liste des emails en session



            int position = Integer.parseInt(id);
            MailBean mailBean = mailList.get(position);
            success = true;
            request.setAttribute("mailBean", mailBean);
            this.getServletContext().getRequestDispatcher("/mail_content.jsp").forward(request, response);
        }
        if (!success) {
            response.sendRedirect(request.getContextPath() + "/mail/list");
        }
    }
}
