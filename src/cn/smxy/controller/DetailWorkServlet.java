package cn.smxy.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/detailwork.do")
public class DetailWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailWorkServlet() {
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
		
		request.getRequestDispatcher("lookWork.jsp").forward(request, response);
		/*
		String wname=request.getParameter("wname");
		String wcontent=request.getParameter("wcontent");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		Date date=new Date();
		String p_time=sdf.format(date);
		
		String f_time=request.getParameter("f_time");
		HttpSession session=request.getSession();
			
		try {
			WorksDAO worksDAO=new WorksDAO();
			int wid = 0;
			boolean issave = worksDAO.saveUser(new Works(wid,wname,wcontent,p_time,f_time));
			if(issave){
				request.setAttribute("msg", "作业发布成功");
				request.getRequestDispatcher("takework.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "作业发布失败");
				request.getRequestDispatcher("takework.jsp").forward(request, response);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
		/*	try {
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
			}*/
	}
}
