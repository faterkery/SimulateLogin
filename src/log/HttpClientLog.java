package log;

import java.io.IOException;
import java.util.Enumeration;


import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.URIException;

public class HttpClientLog
{
	public void printRequestLog(HttpServletRequest request)
	{
		System.out.println();
		System.out.println("======================Cookie��Ϣ��======================");
		if(request.getCookies()!=null)
		{
			for(javax.servlet.http.Cookie cookie : request.getCookies())
	  		{
	  			System.out.println(cookie.getName()+":"+cookie.getValue());
	  		}
		}
		System.out.println("======================����"+request.getRemoteAddr()+"��ͷ����Ϣ��");
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements())
		{
			String name = headers.nextElement();
			System.out.println(name+":"+request.getHeader(name));
		}
		
		System.out.println();
	}
	
	public void printRequestHeadersLog(HttpMethod method) throws URIException
	{
		System.out.println();
		System.out.println("======================����"+method.getURI()+"��ͷ����Header��==================");
		for(Header header :method.getRequestHeaders())
		{
			System.out.println(header.getName()+":"+header.getValue());
		}
		System.out.println();
	}
	
	
	public void printResponseLog(HttpMethod method) throws IOException
	{
		System.out.println();
		System.out.println("======================����"+method.getURI()+"����Ӧ==================");
		System.out.println("======================��Ӧ��Header===================");
		for(Header header : method.getResponseHeaders())
		{
			System.out.println(header.getName()+"="+header.getValue());
		}
		System.out.println("======================��Ӧ��Body=====================");
		System.out.print(method.getResponseBodyAsString());
		System.out.println();
	}
	
	
	public void printResponseHeadersLog(HttpMethod method) throws IOException
	{
		System.out.println();
		System.out.println("======================����"+method.getURI()+"��ͷ����Header��==================");
		for(Header header :method.getResponseHeaders())
		{
			System.out.println(header.getName()+":"+header.getValue());
		}
		System.out.println();
	}
}
