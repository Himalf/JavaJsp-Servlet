

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.servlet.demo.DbConnect;

public class MyWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String age = request.getParameter("age");
		String query = "insert into userdetail(id,name,address,age) values(?,?,?,?)";
		try {
			Connection conn = DbConnect.getConnection();
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, id);
		stmt.setString(2, name);
		stmt.setString(3, address);
		stmt.setString(4, age);
		int res=stmt.executeUpdate();
		if(res>0) {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
		else {
			System.out.println("Cannot post Data");
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
