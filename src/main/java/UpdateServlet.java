

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.servlet.demo.DbConnect;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String age = request.getParameter("age");
		try {
			Connection con = DbConnect.getConnection();
			String query = "update userdetail set name=?,address=?,age=? where id=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			st.setString(2, address);
			st.setString(3, age);
			st.setString(4, id);
			st.executeUpdate();

			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
