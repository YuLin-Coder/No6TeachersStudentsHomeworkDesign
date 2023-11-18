package cn.smxy.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


//HttpSessionListener--session����������
//ServletContextListener--application����ʷ��������

public class OnlineListener implements HttpSessionListener,ServletContextListener{
	
	//���������浽application��
	ServletContext servletContext;  //�൱��application��ȫ�֣�����Web����
	
	/*�������̣�
	1����webӦ��������������������ʷ����������ʼ��---application
	2���������Ựʱ��������ʼ���û�������---���������ۼӣ���ʷ���������ۼ�---session
	3�������ٻỰʱ�����������ˣ��û�������---���������ۼ�����ʷ������������---session
	4��������WebӦ�ùرգ���ʷ��������д�����ݿ�---application
	*/
	
	//����WebӦ�ùرյ�ʱ��
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		String online = servletContext.getAttribute("online").toString();
		String count = servletContext.getAttribute("count").toString();
		System.out.println("����������"+online+","+"��ʷ����������"+count);
	}

	//����WebӦ��������ʱ��--application
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//1��
		servletContext = arg0.getServletContext(); //==application
		servletContext.setAttribute("online", "0");//������������ʼ��Ϊ0
		servletContext.setAttribute("count", "20");//����ʷ������ʼ��Ϊ20
	}

	//Session�Ự������ʱ������
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//2��
		//��1�����������ۼ�
		String online = servletContext.getAttribute("online").toString();
		int onlinecount = Integer.parseInt(online);
		onlinecount++;
		servletContext.setAttribute("online", onlinecount);
		
		//��2����ʷ���������ۼ�
		String count = servletContext.getAttribute("count").toString();
		int countcount = Integer.parseInt(count);
		countcount++;
		servletContext.setAttribute("count", countcount);
		
	}

	//Session�Ự���ٵ�ʱ������
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//3��
		//���������ۼ�
		String online = servletContext.getAttribute("online").toString();
		int onlinecount = Integer.parseInt(online);
		onlinecount--;
		servletContext.setAttribute("online", onlinecount);
	}
	
	

	
}
