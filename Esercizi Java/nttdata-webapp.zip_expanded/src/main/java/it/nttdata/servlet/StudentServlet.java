package it.nttdata.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.nttdata.form.business.StudentManagementForm;
import it.nttdata.form.model.ExamDetailsForm;
import it.nttdata.form.model.StudentForm;

@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {
		System.out.println("StudentServlet.init()");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentServlet.doGet() IN");
		
		String action = request.getServletPath();

		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertStudent(request, response);
			break;
		case "/delete":
			deleteStudent(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateStudent(request, response);
			break;
		case "/exam":
			listExam(request, response);
			break;	
		default:
			listStudent(request, response);
			break;
		}
		
		System.out.println("StudentServlet.doGet() OUT");
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("StudentServlet.listStudent() IN");
		
		List<StudentForm> listUser = StudentManagementForm.selectAllStudentForm();

		request.setAttribute("listStudent", listUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");

		System.out.println("StudentServlet.listStudent() OUT");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");

		dispatcher.forward(request, response);
	}
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("StudentServlet.insertStudent() IN");
		
		try {
			
			StudentManagementForm.insertStudentForm(request);
			
		} catch (Exception e) {
			 e.printStackTrace();
		}

		System.out.println("StudentServlet.listStudent() OUT");
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentServlet.showEditForm() IN");
		
		String matricola = request.getParameter("id");

		StudentForm existingStudent = StudentManagementForm.findStudentByIDForm(matricola);

		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");

		request.setAttribute("studente", existingStudent);

		System.out.println("StudentServlet.showEditForm() OUT");
		dispatcher.forward(request, response);
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("StudentServlet.deleteStudent() IN");
		
		String matricola = request.getParameter("id");

		StudentManagementForm.deleteStudentForm(matricola);

		System.out.println("StudentServlet.deleteStudent() OUT");
		response.sendRedirect("list");
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("StudentServlet.updateStudent() IN");
		
		try {
			StudentManagementForm.updateStudentForm(request);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("StudentServlet.updateStudent() OUT");
		response.sendRedirect("list");
	}
	
	private void listExam(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("StudentServlet.listExam() IN");
		
		String matricola = request.getParameter("id");

		List<ExamDetailsForm> listExam = StudentManagementForm.selectAllExamForm(matricola);

		request.setAttribute("listExam", listExam);

		RequestDispatcher dispatcher = request.getRequestDispatcher("exam-list.jsp");
		
		System.out.println("StudentServlet.listExam() OUT");
		dispatcher.forward(request, response);
	}
	
}
