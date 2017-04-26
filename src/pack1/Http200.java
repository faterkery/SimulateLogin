package pack1;

import java.net.HttpURLConnection;
import java.net.URL;

public class Http200 {
	public String getUrl(){
		String location="";
		try {  
		String url = "http://172.16.25.35";  
        System.out.println("访问地址:" + url);  
        URL serverUrl = new URL(url);  
        HttpURLConnection conn = (HttpURLConnection) serverUrl  
                .openConnection();  
        conn.setRequestMethod("GET");  
        // 必须设置false，否则会自动redirect到Location的地址  
        conn.setInstanceFollowRedirects(false);  

        conn.addRequestProperty("Accept-Charset", "UTF-8;");  
        conn.addRequestProperty("User-Agent",  
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");  
        conn.addRequestProperty("Referer", "http://172.16.25.35");  
        conn.connect();  
        location = conn.getHeaderField("Location");
        return location;
		}catch(Exception e){
			e.printStackTrace();
		}
		return location;
	}
	public static void main(String[] args) {  
        try {  
            String url = "http://172.16.25.35";  
            System.out.println("访问地址:" + url);  
            URL serverUrl = new URL(url);  
            HttpURLConnection conn = (HttpURLConnection) serverUrl  
                    .openConnection();  
            conn.setRequestMethod("GET");  
            // 必须设置false，否则会自动redirect到Location的地址  
            conn.setInstanceFollowRedirects(false);  
  
            conn.addRequestProperty("Accept-Charset", "UTF-8;");  
            conn.addRequestProperty("User-Agent",  
                    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");  
            conn.addRequestProperty("Referer", "http://172.16.25.35");  
            conn.connect();  
            String location = conn.getHeaderField("Location");  
  
            serverUrl = new URL("http://172.16.25.35"+location);  
            conn = (HttpURLConnection) serverUrl.openConnection();  
            conn.setRequestMethod("GET");  
  
            conn.addRequestProperty("Accept-Charset", "UTF-8;");  
            conn.addRequestProperty("User-Agent",  
                    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");  
            conn.addRequestProperty("Referer", "http://zuidaima.com/");  
            conn.connect();  
            System.out.println("跳转地址:" + location);  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
