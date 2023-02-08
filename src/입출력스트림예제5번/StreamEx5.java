package 입출력스트림예제5번;

import java.io.*;

public class StreamEx5 {
    public static void main(String[] args) {
//        try {
//            InputStream is = new FileInputStream("src/입출력스트림예제5번/StreamEx5.java");
//            int data;
//            while((data = is.read()) != -1) {
//                System.out.write(data);
//            }
//            is.close();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
        // FileOutputStream : 바이트 단위로 데이터를 파일에 저장 할 때 사용하는 바이트 기반 출력 스트림
        // 바이트 단위로 저장하기 때문에 그림,오디오,텍스트 등 모든 종류의 데이터를 파일 저장 할 수 있다
       String originalFileName = "src/입출력스트림예제5번/dog.png";
       String targetFileName = "src/cloneDog.png";
       try {
           InputStream is = new FileInputStream(originalFileName);
           OutputStream os = new FileOutputStream(targetFileName);
           int readByteNo;
           byte[] readBuff = new byte[100];
           while((readByteNo = is.read(readBuff)) != -1) {
               os.write(readBuff, 0 ,readByteNo);
           }
           os.flush();
           os.close();
           is.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}

