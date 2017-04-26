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

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import bean.LoginData;


public class Login extends HttpServlet
{

	private String returnLocal;
	
	 /** 
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
		System.out.println("================������Login��doPost()=============");
		
		LoginData loginData =new LoginData();

		loginData.setTxtUserName(request.getParameter("txtUserName"));
		loginData.setTextBox2(request.getParameter("TextBox2"));
		loginData.setTxtSecretCode(request.getParameter("txtSecretCode"));
		
		String  url =  (String) request.getSession().getAttribute("url");
		
		
		PostMethod post = new PostMethod("http://172.16.25.35"+url);
		post.addRequestHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		post.addRequestHeader("Accept-Encoding","gzip, deflate");
		post.addRequestHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		post.addRequestHeader("Connection","keep-alive");
//		post.addRequestHeader("Host","172.16.25.35");
		post.addRequestHeader("Referer","http://172.16.25.35"+url);
		post.addRequestHeader("Upgrade-Insecure-Requests","1");
		post.addRequestHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
		
		NameValuePair[]  nvps = new NameValuePair[9];
		
		nvps[0] = new NameValuePair("__VIEWSTATE",loginData.getViewState());
		nvps[1] = new NameValuePair("Button1","");
		nvps[2] = new NameValuePair("hidPdrs","");
		nvps[2] = new NameValuePair("hidPdrs","");
		nvps[3] = new NameValuePair("hidsc","");
		nvps[4] = new NameValuePair("lbLanguage","");
		nvps[5] = new NameValuePair("RadioButtonList1","Ñ§Éú");
		nvps[6] = new NameValuePair("TextBox2",loginData.getTextBox2());
		nvps[7] = new NameValuePair("txtSecretCode",loginData.getTxtSecretCode());
		nvps[8] = new NameValuePair("txtUserName",loginData.getTxtUserName());
		
		post.setRequestBody(nvps);
		
		
		new HttpClientLog().printRequestHeadersLog(post);
		HttpClient httpClient = new HttpClient();
		httpClient.executeMethod(post);
		new HttpClientLog().printResponseHeadersLog(post);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(post.getResponseBodyAsStream()));
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			if(line.contains("��֤�벻��ȷ��"))
			{
				request.getSession().setAttribute("errorInfo", "�Բ������������֤������Ŷ��");
				response.sendRedirect("fill.jsp");
				return;
			}
		}
		System.out.println(post.getResponseBodyAsString());
		//    /xs_main.aspx?xh=13101010115
		Header header = post.getResponseHeader("Location");
		if(header==null)
		{
			request.getSession().setAttribute("errorInfo", "无重定向地址!!");
			response.sendRedirect("fill.jsp");
			return;
		}
		returnLocal=header.getValue();
		if(!returnLocal.contains("xs_main.aspx"))
		{
			System.out.println("����ȷ�ķ���===��Location: "+returnLocal);
			String errorInfo = post.getResponseBodyAsString();
			request.setAttribute("errorInfo", errorInfo);
			request.getRequestDispatcher("LoginError.jsp").forward(request, response);
			post.releaseConnection();
			return;
		}
		System.out.println("Location: "+returnLocal);
		post.releaseConnection();
		
		
		GetMethod get = new GetMethod("http://172.16.25.35"+returnLocal);
		new HttpClientLog().printRequestHeadersLog(get);
		httpClient.executeMethod(get);
		new HttpClientLog().printResponseLog(get);
		System.out.println(get.getResponseBodyAsString());
	}

}
