import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {
	
	public static void main(String[] args) {
        String clientId = "hOBAjjmz9dUkwoGrp6pS";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
        String clientSecret = "ZjcaMrNM5I";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
        try {
            String addr = URLEncoder.encode("정자", "UTF-8");
//            String addr2 = URLEncoder.encode("127.1157168,37.5365521","UTF-8");
            String apiURL = "https://openapi.naver.com/v1/map/geocode?query=" + addr; //json
//            String apiURL2 = "https://openapi.naver.com/v1/map/reversegeocode?query="+addr2;
            //String apiURL = "https://openapi.naver.com/v1/map/geocode.xml?query=" + addr; // xml
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // ���� ȣ��
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // ���� �߻�
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}