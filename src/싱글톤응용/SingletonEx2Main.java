package 싱글톤응용;

public class SingletonEx2Main {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        test1.setInfo("정우진", 26);
        test2.viewInfo();
    }
}
