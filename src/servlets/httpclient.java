package servlets;

import java.io.IOException;  
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.Header;
import org.apache.http.HttpResponse;  
import org.apache.http.NameValuePair;  
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.impl.client.CloseableHttpClient;  
import org.apache.http.impl.client.HttpClients;  
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.util.EntityUtils;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;  
  
public class httpclient {  
    //模拟登录教务系统的网址  
    private  String url = "http://172.16.25.35/(acjz3hrwavq2f5n2e5dtto45)/default2.aspx";  
    //课表网址  
    private  String urlkb ="http://172.16.25.35/(acjz3hrwavq2f5n2e5dtto45)/xskbcx.aspx?xh="+txtUserName+"&xm="+name+"&gnmkdm=N121603";  
    //成绩网址  
    private  String urlcj = "http://172.16.25.35/(acjz3hrwavq2f5n2e5dtto45)/xscj_gc.aspx?xh="+txtUserName+"&xm="+name+"&gnmkdm=N121605";  
    //成绩，课表。。。的referer源地址  
    private  String urlrefer = "http://172.16.25.35/(acjz3hrwavq2f5n2e5dtto45)/xs_main.aspx?xh="+txtUserName;  
    //模拟登陆时所需要的参数 通过抓包可获取具体的值  
    private static String name;
    private static String __VIEWSTATE;  
    private static String __VIEWSTATEGENERATOR;
    private static String Button1 = "";  
    private static String hidpdrs = "";  
    private static String hidsc = "";  
    private static String lbLanguage = "";  
    private static String RadioButtonList1 = "%D1%A7%C9%FA";  
    private static String TextBox2;  
    private static String txtSecretCode = "";  
    public String getName(){
    	return name;
    }
    public static String getTxtSecretCode() {
		return txtSecretCode;
	}
	public static void setTxtSecretCode(String txtSecretCode) {
		httpclient.txtSecretCode = txtSecretCode;
	}
	private static String txtUserName;  
    private static String ddlXN;  
    private static String ddlXQ;  
    private static String cjButton1 ="按学期查询";  
    private static CloseableHttpClient client = HttpClients.createDefault();  
    public String setname(int val){
    	try {
    	
    	HttpGet httpget = new HttpGet(urlrefer);  
    	//利用client发送请求放回一个Httprespond的类型  
    	if(val==1)  
            httpget.setHeader("Referer",urlrefer);
        HttpResponse re2 = client.execute(httpget);
        //利用jsoup的类将response.getEntity获取得到html代码变成Doc文本  
        Document doc = Jsoup.parse(EntityUtils.toString(re2.getEntity(), "utf-8")); //jsoup 也可以去找相应的包
        Elements elements1 = doc.select("[class=info]");
        Elements elements2 = elements1.select("span");
        String name = elements2.get(1).text();
        name=name.substring(0, 3);
        System.out.println(name);
        urlkb ="http://172.16.25.35/(acjz3hrwavq2f5n2e5dtto45)/xskbcx.aspx?xh="+txtUserName+"&xm="+name+"&gnmkdm=N121603";
        urlcj = "http://172.16.25.35/(acjz3hrwavq2f5n2e5dtto45)/xscj_gc.aspx?xh="+txtUserName+"&xm="+name+"&gnmkdm=N121605";
        return name;
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
    	 return name;
    }
    //设置登录的id psd  
    public void set(String id, String psd){  
        TextBox2 = psd;  
        txtUserName = id;  
        urlkb+=id;  
        urlcj+=id;  
        urlrefer+=id;  
        System.out.println(txtUserName);
        urlrefer = "http://172.16.25.35/(acjz3hrwavq2f5n2e5dtto45)/xs_main.aspx?xh="+txtUserName;
    }  
    //查询成绩的年份  
    public void setcj(String year,String tern){  
        ddlXN=year;  
        ddlXQ=tern;  
//      System.out.println(ddlXN);  
//      System.out.println(ddlXQ);  
    }  
    //获取 __VIEWSTATE 总共两次获取 一次登录的时候 一次为获取成绩的时候  
    public  void Getu(String ur,int val) throws ClientProtocolException, IOException {  
        //先用get方法模拟登录ur  
        HttpGet httpget = new HttpGet(ur);  
        if(val==1)  
            httpget.setHeader("Referer",urlrefer); //第二次登陆的时候需要添加源地址防止出现302跳转  
        //利用client发送请求放回一个Httprespond的类型  
        HttpResponse re2 = client.execute(httpget);  
        //利用jsoup的类将response.getEntity获取得到html代码变成Doc文本  
        Document doc = Jsoup.parse(EntityUtils.toString(re2.getEntity(), "utf-8")); //jsoup 也可以去找相应的包  
        //查找 __VIEWSTATE这个的值  
        __VIEWSTATE = doc.select("input[name=__VIEWSTATE]").val(); 
        __VIEWSTATEGENERATOR = doc.select("input[name=__VIEWSTATEGENERATOR]").val(); 
        
        //释放get  
        httpget.abort();  
    }  
    //模拟登录  
    public int Login() throws ClientProtocolException, IOException {  
        //获取 __VIEWSTATE的值  
//        Getu(url,0);  
        //通过post方法模拟登陆  
        HttpPost post = new HttpPost(url);  
        System.out.println("------------------");
        Header[] g=post.getAllHeaders();
        for(Header g1:g){
        	System.out.println(g1.getName()+g1.getValue());
        }
        System.out.println("------------------");
        //post所需的参数存放到ArrayList  
        ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();  
        list.add(new BasicNameValuePair("__VIEWSTATE", __VIEWSTATE));  
        list.add(new BasicNameValuePair("__VIEWSTATEGENERATOR",__VIEWSTATEGENERATOR));
        list.add(new BasicNameValuePair("Button1", Button1));  
        list.add(new BasicNameValuePair("hidpdrs", hidpdrs));  
        list.add(new BasicNameValuePair("hidsc", hidsc));  
        list.add(new BasicNameValuePair("lbLanguage", lbLanguage));  
        list.add(new BasicNameValuePair("RadioButtonList1", RadioButtonList1));  
        list.add(new BasicNameValuePair("TextBox2", TextBox2));  
        list.add(new BasicNameValuePair("txtSecretCode", txtSecretCode));  
        list.add(new BasicNameValuePair("txtUserName", txtUserName));  
        //将参数通过post方法请求服务器  
        post.setEntity(new UrlEncodedFormEntity(list));  
        HttpResponse response = client.execute(post);  
        //释放post  
        post.abort();  
        
        Header[] h=response.getAllHeaders();
        for(Header h1:h){
        	System.out.println(h1.getName()+h1.getValue());
        }
        System.out.println(response.getStatusLine().getStatusCode());
        //当登陆返回码为302的时候登陆成功  
        if(response.getStatusLine().getStatusCode() == 302)  
            return 1;  
        else  
            return 0;  
    }  
    //获取课表  
    public Document  Getkb() throws ClientProtocolException, IOException {  
        //获取课表通过get方法  
        HttpGet get = new HttpGet(urlkb);  
        //设置referer 防止出现302跳转  
        get.setHeader("Referer",urlrefer);  
        HttpResponse res = client.execute(get);  
        Document doc = Jsoup.parse(EntityUtils.toString(res.getEntity(), "utf-8"));  
        get.abort();  
        //返回document文件  
        return doc;  
    }  
    //获取成绩  
    public Document Getcj() throws ClientProtocolException, IOException {  
        //__VIEWSTATE  
    	
        Getu(urlcj,1);  System.out.println(urlcj);
        //System.out.println(__VIEWSTATE);  
        //参数  
        ArrayList<NameValuePair> par = new ArrayList<NameValuePair>();  
        par.add(new BasicNameValuePair("__VIEWSTATE", __VIEWSTATE));  
        par.add(new BasicNameValuePair("Button1", cjButton1));  
        par.add(new BasicNameValuePair("ddlXN",ddlXN));  
        par.add(new BasicNameValuePair("ddlXQ",ddlXQ));  
        //post方法访问成绩url  
        HttpPost g = new HttpPost(urlcj);  
        //传参数  
        g.setEntity(new UrlEncodedFormEntity(par));  
        //设置urlrefer  
        g.setHeader("Referer",urlrefer);  
        HttpResponse r = client.execute(g);  
        Document doc = Jsoup.parse(EntityUtils.toString(r.getEntity(), "utf-8"));  
        return doc;  
    }  
}
