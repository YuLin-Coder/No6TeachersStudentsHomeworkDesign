package cn.smxy.listener;

import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener {

	public RequestListener () {
		
	}
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		String url = ((HttpServletRequest)arg0.getServletRequest()).getRequestURL().toString();
		System.out.println("���������ʱ�䣺" + url +","+ new Date().toString());
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		//�����ʼ��---����Э��Http
		String url = ((HttpServletRequest)arg0.getServletRequest()).getRequestURL().toString();
		System.out.println("����ʼ��ʱ�䣺" + url +","+ new Date().toString());
	}

}
