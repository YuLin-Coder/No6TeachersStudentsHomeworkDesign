package cn.smxy.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.smxy.fzw.Student;
import cn.smxy.fzw.StudentDAO;
import cn.smxy.fzw.Teacher;
import cn.smxy.fzw.TeacherDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//避免乱码 ，！！！！！尽量不用中文噢
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		String role=request.getParameter("role");
		HttpSession session=request.getSession();
		
		//WEB-INF:受保护的文件夹，客户端无法直接访问，必须在服务器内部请求访问
		if(role!=null&&role.equals("1")){	
			try {
				TeacherDAO teacherDAO=new TeacherDAO();
				Teacher teacher=teacherDAO.queryUsers(username);
				//System.out.println(teacher.getTname()+"  "+teacher.getTpwd());
				if(teacher!=null&&pwd.equals(teacher.getTpwd()))
				{
					session.setAttribute("username", username);
					session.setAttribute("role", "1");
					request.getRequestDispatcher("WEB-INF/teacher/index.jsp").forward(request, response);
					//response.sendRedirect("WEB-INF/admin/index.jsp");
				}else{
					request.setAttribute("msg", "登录失败");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(role!=null&&role.equals("2")){
			try {
				StudentDAO studentDAO=new StudentDAO();
				Student student=studentDAO.queryUsers(username);
				if(student!=null&&pwd.equals(student.getspwd()))
				{
					session.setAttribute("username", username);
					session.setAttribute("role", "2");
					request.getRequestDispatcher("WEB-INF/student/index.jsp").forward(request, response);
					//response.sendRedirect("WEB-INF/admin/index.jsp");
				}else{
					request.setAttribute("msg", "登录失败");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
