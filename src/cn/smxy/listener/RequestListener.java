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
		System.out.println("请求结束的时间：" + url +","+ new Date().toString());
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		//请求初始化---基于协议Http
		String url = ((HttpServletRequest)arg0.getServletRequest()).getRequestURL().toString();
		System.out.println("请求开始的时间：" + url +","+ new Date().toString());
	}

}
