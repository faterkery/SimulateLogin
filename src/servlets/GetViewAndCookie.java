package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import log.HttpClientLog;
import pack1.Http200;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import bean.LoginData;
public class GetViewAndCookie extends HttpServlet
{

	HttpClientLog log = new HttpClientLog();
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LoginData loginData = new LoginData();
		
		Http200 htt =new Http200();String url=htt.getUrl();
  
		ServletContext servletcontent =this.getServletContext();
		servletcontent.setAttribute("url", url);
		
 		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod("http://172.16.25.35"+url);
		
		getMethod.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		getMethod.addRequestHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.3; WOW64; Trident/7.0; .NET4.0E; .NET4.0C; .NET CLR 3.5.30729; .NET CLR 2.0.50727; .NET CLR 3.0.30729; GWX:QUALIFIED; Shuame)");
		getMethod.addRequestHeader("Accept-Encoding", "gzip, deflate");
		getMethod.addRequestHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		getMethod.addRequestHeader("Upgrade-Insecure-Requests", "1");
		getMethod.addRequestHeader("Connection", "Keep-Alive");
		getMethod.addRequestHeader("Pragma", "no-cache");	
		log.printRequestHeadersLog(getMethod);
		
		httpClient.executeMethod(getMethod);
		
		log.printResponseLog(getMethod);
		String content;
		BufferedReader bufr = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream(),"utf-8"));
		while((content=bufr.readLine())!=null)
		{
			if(content.contains("__VIEWSTATE"))
			{
				String result = content.substring(content.indexOf("value=\"")+7, 
						content.lastIndexOf("\""));
				content=result;
				loginData.setViewState(result);
				break;
			}
		}
		request.getSession().setAttribute("url", url);
		response.sendRedirect("fill.jsp");//�ض���
	}

}
