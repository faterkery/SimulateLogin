package servlets;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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
import org.jsoup.nodes.Document;

import com.sun.java.swing.plaf.windows.resources.windows;

import bean.LoginData;


public class Login_1 extends HttpServlet
{

	private String returnLocal;
	public static httpclient http =null;
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

		String username=request.getParameter("txtUserName");
		String password =request.getParameter("TextBox2");
		String txt=request.getParameter("txtSecretCode");
		
		http=new httpclient();
		http.set(username, password);http.setTxtSecretCode(txt);
		int ret_h=http.Login();
		System.out.println(ret_h);
		if(ret_h==0){
			request.getRequestDispatcher("fill.jsp").forward(request, response);
		}else if(ret_h==1){
		String name=http.setname(1);
		
//		http.setcj("2", "2");
//		Document doc=http.Getcj();
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println(doc);
		System.out.println("909"+name);
		request.setAttribute("name",name);
		request.getRequestDispatcher("Xs_main.jsp").forward(request, response);
	}
	}

}
