

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.servlet.demo.Student;

public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String age = request.getParameter("age");
	List<Student> list = new ArrayList<Student>();
	Student s = new Student();
	s.setId(id);
	s.setName(name);
	s.setAddress(address);
	s.setAge(age);
list.add(s);
request.setAttribute("studentList", list);
RequestDispatcher rd = request.getRequestDispatcher("updateData.jsp");
rd.forward(request, response);

	}

	
}
