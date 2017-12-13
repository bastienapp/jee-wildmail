package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "MailCreateServlet")
public class MailCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get POST mail params
        request.setCharacterEncoding("UTF-8");
        String createFromValue = request.getParameter("createFromValue");
        String createToValue = request.getParameter("createToValue");
        String createSubjectValue = request.getParameter("createSubjectValue");
        String createContentValue = request.getParameter("createContentValue");
        // create a bean
        MailBean mailBean = new MailBean();
        mailBean.setFrom(createFromValue);
        mailBean.setTo(createToValue);
        mailBean.setSubject(createSubjectValue);
        mailBean.setContent(createContentValue);
        // if mail list does not exists, create it
        List<MailBean> mailList = new ArrayList<>();
        if (request.getSession().getAttribute("mailList") != null) {
            mailList = (List<MailBean>) request.getSession().getAttribute("mailList");
            // TODO : gestion de la base de données
        }
        // add bean id
        mailBean.setId(mailList.size());
        // add bean in mail list
        mailList.add(mailBean);
        // add mail list in session
        request.getSession().setAttribute("mailList", mailList);
        // redirect to /mail/list
        response.sendRedirect(request.getContextPath() + "/mail/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/mail_create.jsp").forward(request, response);
    }
}
