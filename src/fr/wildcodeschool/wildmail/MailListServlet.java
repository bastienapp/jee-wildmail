package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MailListServlet")
public class MailListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userEmail = (String) request.getSession().getAttribute("userEmail");
        try {
            Class driverClass = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) driverClass.newInstance();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wildmail", "root", "mysql");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mail where mail_from = ?");
            preparedStatement.setString(1, userEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<MailBean> mailList = new ArrayList<>();
            while (resultSet.next()) {
                MailBean mailBean = new MailBean();
                mailBean.setId(resultSet.getInt("mail_id"));
                mailBean.setFrom(resultSet.getString("mail_from"));
                mailBean.setTo(resultSet.getString("mail_to"));
                mailBean.setSubject(resultSet.getString("mail_subject"));
                mailBean.setContent(resultSet.getString("mail_content"));
                mailList.add(mailBean);
            }

            request.setAttribute("mailList", mailList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/mail_list.jsp").forward(request, response);
    }
}
