package com.app;

import java.io.IOException;
import java.sql.Connection;//
import java.sql.DriverManager;//
import java.sql.PreparedStatement;//
import java.sql.ResultSet;//

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String userIdParam = request.getParameter("StudentPRN");

        if (userIdParam == null || userIdParam.isEmpty()) {
            response.getWriter().println("Please provide a Student ID.");
            return;
        }

        int studentPRN = Integer.parseInt(userIdParam);

        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/dbjava";
        String dbUser = "root";
        String dbPassword = "Lsd@5030";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection using java.sql.Connection
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                // Prepare the SQL query to retrieve user by ID
                String sql = "SELECT id, name, maths, physics, percentages FROM student WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, studentPRN);

                    // Execute the query
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            // Display user details
                            response.getWriter().println("Student Id: " + resultSet.getInt("id"));
                            response.getWriter().println("Name: " + resultSet.getString("name"));
                            response.getWriter().println("Maths: " + resultSet.getString("maths"));
                            response.getWriter().println("Physics: " + resultSet.getString("physics"));
                            response.getWriter().println("Percentage: " + resultSet.getString("percentages"));
                        } else {
                            response.getWriter().println("Student not found with ID: " + studentPRN);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new ServletException("Error processing the request", e);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
