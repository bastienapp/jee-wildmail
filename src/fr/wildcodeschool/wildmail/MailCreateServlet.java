package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "MailCreateServlet")
public class MailCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get POST mail params
        request.setCharacterEncoding("UTF-8");
        String userEmail = (String) request.getSession().getAttribute("userEmail");
        String createToValue = request.getParameter("createToValue");
        String createSubjectValue = request.getParameter("createSubjectValue");
        String createContentValue = request.getParameter("createContentValue");
        // create a bean
        MailBean mailBean = new MailBean();
        mailBean.setFrom(userEmail);
        mailBean.setTo(createToValue);
        mailBean.setSubject(createSubjectValue);
        mailBean.setContent(createContentValue);

        try {
            Class driverClass = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) driverClass.newInstance();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wildmail", "root", "xi3!prst4");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mail VALUES(null, ?, ?, ?, ?);");
            preparedStatement.setString(1, mailBean.getFrom());
            preparedStatement.setString(2, mailBean.getTo());
            preparedStatement.setString(3, mailBean.getSubject());
            preparedStatement.setString(4, mailBean.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        // redirect to /mail/list
        response.sendRedirect(request.getContextPath() + "/mail/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/mail_create.jsp").forward(request, response);
    }
}
