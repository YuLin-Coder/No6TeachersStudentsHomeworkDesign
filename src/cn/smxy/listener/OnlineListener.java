package cn.smxy.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


//HttpSessionListener--session，在线人数
//ServletContextListener--application，历史访问人数

public class OnlineListener implements HttpSessionListener,ServletContextListener{
	
	//在线人数存到application里
	ServletContext servletContext;  //相当于application，全局，整个Web共享
	
	/*计数流程：
	1、当web应用启动，在线人数和历史访问人数初始化---application
	2、当创建会话时，交互开始，用户上线了---在线人数累加，历史访问人数累加---session
	3、当销毁会话时，交互结束了，用户下线了---在线人数累减，历史访问人数不变---session
	4、当整个Web应用关闭，历史访问人数写入数据库---application
	*/
	
	//整个Web应用关闭的时候
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		String online = servletContext.getAttribute("online").toString();
		String count = servletContext.getAttribute("count").toString();
		System.out.println("在线人数："+online+","+"历史访问人数："+count);
	}

	//整个Web应用启动的时候--application
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//1、
		servletContext = arg0.getServletContext(); //==application
		servletContext.setAttribute("online", "0");//给在线人数初始化为0
		servletContext.setAttribute("count", "20");//给历史人数初始化为20
	}

	//Session会话创建的时候，上线
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//2、
		//（1）在线人数累加
		String online = servletContext.getAttribute("online").toString();
		int onlinecount = Integer.parseInt(online);
		onlinecount++;
		servletContext.setAttribute("online", onlinecount);
		
		//（2）历史访问人数累加
		String count = servletContext.getAttribute("count").toString();
		int countcount = Integer.parseInt(count);
		countcount++;
		servletContext.setAttribute("count", countcount);
		
	}

	//Session会话销毁的时候，下线
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//3、
		//在线人数累减
		String online = servletContext.getAttribute("online").toString();
		int onlinecount = Integer.parseInt(online);
		onlinecount--;
		servletContext.setAttribute("online", onlinecount);
	}
	
	

	
}
