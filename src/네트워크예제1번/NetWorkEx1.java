package 네트워크예제1번;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetWorkEx1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress local = InetAddress.getLocalHost();
        System.out.println("내 컴퓨터의 IP주소 : " + local.getHostAddress());

        InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
        for(InetAddress remote : iaArr) {
            System.out.println("네이버 Ip 주소 : " + remote.getHostAddress());
        }
    }
}
