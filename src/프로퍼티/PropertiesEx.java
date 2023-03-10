package 프로퍼티;

import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

// Properties? 내부의 정보 저장용으로 사용되며, 키와 값이 모두 String 타입으로 제한됨
// HashTable의 하위 클래스
public class PropertiesEx {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        String path = PropertiesEx.class.getResource("예외처리2번/database.properties").getPath(); // 절대 경로
        path = URLDecoder.decode(path, "utf-8");
        properties.load(new FileReader(path));
        String driver = properties.getProperty(("driver"));
        String url = properties.getProperty(("url"));
        String username = properties.getProperty(("username"));
        String password = properties.getProperty(("password"));

        System.out.println("드라이버 : " + driver);
        System.out.println("URL : " + url);
        System.out.println("이름 : " + username);
        System.out.println("비밀번호 : " + password);
    }
}
