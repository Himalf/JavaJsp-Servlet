import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servlet.demo.DbConnect;
import com.servlet.demo.Student;

@WebServlet("/MyWebServlet")
public class MyWebServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String age = request.getParameter("age");
        String query = "INSERT INTO userdetail(id, name, address, age) VALUES(?, ?, ?, ?)";
        try (Connection conn = DbConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, address);
            stmt.setString(4, age);
            int res = stmt.executeUpdate();
            if (res > 0) {
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);
            } else {
                response.getWriter().println("Cannot post data");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = new ArrayList<Student>();
        String query = "SELECT * FROM userdetail";
        try (Connection conn = DbConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String age = rs.getString("age");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAddress(address);
                student.setAge(age);
                list.add(student);
            }
            request.setAttribute("studentList", list);
            
            RequestDispatcher rd = request.getRequestDispatcher("getData.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
