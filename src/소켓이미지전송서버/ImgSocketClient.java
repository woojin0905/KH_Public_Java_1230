package 소켓이미지전송서버;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImgSocketClient {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int port = 6556;
        Scanner sc = new Scanner(System.in);
        System.out.print("전송할 파일을 선택하세요(경로/파일명) : ");
        String path = sc.nextLine();
        System.out.println("파일명 : " + path);
        try {
            Socket socket = serverSocket.accept();
            System.out.println("[클라이언트 : " +socket.getRemoteSocketAddress() +"연결 되었습니다.]" );

        }catch (ConnectException e) {
        }catch (IOException e) {}
    }
}
class ImgServerTh extends Thread {
    Socket socket;
    String fileName;
    static List<Socket> sockets = new ArrayList<>(); //클래스 소속의 리스트(즉, 클래스 만들어 질 떄 한번 생성)
    public ImgServerTh(Socket socket,String fileName) {
        this.socket = socket; // 클라이언트에 대한 소켓 식별자
        this.fileName = fileName; // 전송할 파일이름을 키보드로부터 입력 받아 매개변수로 전달
        sockets.add(socket); // 클래스 소속의 리스트에 생성된 소켓의 식별자를 추가함
    }
    @Override
    public void run() {
        int len;
        byte[] buffer = new byte[1024];
        try {
            FileInputStream fis = new FileInputStream(fileName);
            for(int i = 0; i <ImgServerTh.sockets.size(); i++) {
                OutputStream os = sockets.get(i).getOutputStream();
                while((len = fis.read(buffer)) != -1){
                    os.write(buffer, 0, len);
                }
                os.flush();
                os.close();
                System.out.println(sockets.get(i).getRemoteSocketAddress() + "에게 전송 완료.");
            }
        }catch(IOException e){}
    }

}