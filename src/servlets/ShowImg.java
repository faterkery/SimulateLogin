package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import log.HttpClientLog;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class ShowImg extends HttpServlet
{

	
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
		System.out.println("================������Servlet��doGet()=============");
		doPost(request,response);
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

		httpclient h =new httpclient();
		h.Getu("http://172.16.25.35/(acjz3hrwavq2f5n2e5dtto45)/default2.aspx",0);  
		
		HttpClient httpClient = new HttpClient();
		GetMethod getMethodImg = new GetMethod("http://172.16.25.35/(acjz3hrwavq2f5n2e5dtto45)/CheckCode.aspx");
		
		new HttpClientLog().printRequestHeadersLog(getMethodImg);
		httpClient.executeMethod(getMethodImg);
		byte[] img = getMethodImg.getResponseBody();
		response.getOutputStream().write(img);
		getMethodImg.releaseConnection();
	}
}
