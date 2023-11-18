package cn.smxy.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/LogFilter")
public class LogFilter implements Filter {

	private FilterConfig config;
    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
        System.out.println("�����������");
		HttpServletRequest hRequest=(HttpServletRequest)request;
		//�ų�index.jspҳ��ķ��ʼ�¼
		String requestUri=hRequest.getRequestURI();
		String path=config.getInitParameter("path");
		if(requestUri.indexOf(path)==-1){
			// pass the request along the filter chain
			//��¼�û��ķ�����־����ʱ�䡢���ʵ�ַ����Դ
			String date=new Date().toString();
			String clientIP=request.getRemoteAddr();//ȡ�ÿͻ���IP
			//String requestUri=hRequest.getRequestURI();
			System.out.println("����ʱ�䣺"+date+"���ͻ��˵�ַ��"+clientIP+",�������Դ��"+requestUri);
			chain.doFilter(request, response);
		}else{
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config=fConfig;
	}

}
