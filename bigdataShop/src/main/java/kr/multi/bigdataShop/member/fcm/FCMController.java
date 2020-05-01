package kr.multi.bigdataShop.member.fcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FCMController {
	@Autowired
	FCMService service;
	@RequestMapping(value = "/fcm/fcm_check", method = RequestMethod.GET)
	public String getToken(String token) {
		int result = service.getToken(token);
		if(result==1) {
			System.out.println("저장완료");
		}
		return "redirect:/index.do";
	}
	@RequestMapping(value = "/fcm/sendClient", method = RequestMethod.GET)
	public String sendMessage(String id) {
		FCMDTO result = service.getClientToken(id); //select된 값
		String apiKey = "AAAAGeOazds:APA91bHk7xCiIYokRk9Znu4e1ty21lFHsXz8TSupTp1Xp9ll4ql0Gc5ArXdljnYc823bk8-52CnArw0ehjFdzUZOj04v0qAxBJNWIKrrF_7J7umj_XSXwuU0Z7J7sZh0R1BPtCHZgpbK";
		try {
		//전송 준비
			URL url = new URL("https://fcm.googleapis.com/fcm/send");
			HttpsURLConnection connection = 
					(HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type","application/json");
			connection.setRequestProperty("Authorization","key="+apiKey);
			
		//메세지 세팅
			MessageDTO msg = new MessageDTO("FCM테스트","위치 정보 조회"); 
			//메시지 정보를 셋팅한다.
			SendDataDTO senddto = new SendDataDTO(msg, result.getFcm_token());
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(senddto);
			System.out.println("변환===> "+jsonString);
			
			
		//서버로 데이터 전달하기
			OutputStream os = connection.getOutputStream();
			os.write(jsonString.getBytes("UTF-8"));
			os.flush();
			os.close();
			
		//firebase서버가 전달하는 응답메시지 받기
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			System.out.println("br====>"+br);
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				sb.append(line);
			}
			br.close();
			System.out.println(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/index.do";
	}
}







