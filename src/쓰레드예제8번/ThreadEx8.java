package 쓰레드예제8번;

public class ThreadEx8 {
    public static void main(String[] args) {
        SharedThread sharedThread = new SharedThread();

        // 익명의 클래스로 쓰레드 만들기
        Thread thread = new Thread() {
            @Override
            public void run() {
                sharedThread.setValue(30);
            }
        };
        thread.setName("쓰레드 0");
        thread.start();

        // 익명의 클래스로 쓰레드 만들기(람다식)
        Thread thread1 = new Thread(() -> {
            sharedThread.setValue(100);
        });
        Thread thread2 = new Thread(() -> {
            sharedThread.setValue(10);
        });
        thread1.setName("쓰레드 1");
        thread2.setName("쓰레드 2");
        thread1.start();
        thread2.start();
    }
}

class SharedThread{
    private int value = 0;

    public int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){}
        System.out.println(Thread.currentThread().getName() + "의 value 값은 "+ this.value + "입니다.");
    }
}
