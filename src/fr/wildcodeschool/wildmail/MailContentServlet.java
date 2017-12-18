package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "MailContentServlet")
public class MailContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        try {
            Class driverClass = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) driverClass.newInstance();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wildmail", "root", "mysql");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mail where mail_id = ?");
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MailBean mailBean = new MailBean();
                mailBean.setId(resultSet.getInt("mail_id"));
                mailBean.setFrom(resultSet.getString("mail_from"));
                mailBean.setTo(resultSet.getString("mail_to"));
                mailBean.setSubject(resultSet.getString("mail_subject"));
                mailBean.setContent(resultSet.getString("mail_content"));
                request.setAttribute("mailBean", mailBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/mail_content.jsp").forward(request, response);
    }
}
