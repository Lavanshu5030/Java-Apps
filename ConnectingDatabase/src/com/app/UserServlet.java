package com.app;

import java.io.IOException;
import java.sql.DriverManager;//
import java.sql.PreparedStatement;//
import java.sql.Connection; //
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 String username = request.getParameter("username");
	        String email = request.getParameter("email");

	        // Database connection parameters
	        String jdbcUrl = "jdbc:mysql://localhost:3306/dbjava";
	        String dbUser = "root";
	        String dbPassword = "Lsd@5030";

	        try {
	            // Load the JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish a connection
	            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
	                // Prepare the SQL query
	                String sql = "INSERT INTO user (username, email) VALUES (?, ?)";
	                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	                    // Set parameters
	                    preparedStatement.setString(1, username);
	                    preparedStatement.setString(2, email);

	                    // Execute the query
	                    preparedStatement.executeUpdate();
	                }
	            }

	            response.getWriter().println("Data inserted successfully!");
	        } catch (Exception e) {
	            throw new ServletException("Error processing the request", e);
	        }
	}

}
