package 클래스기본2;

public class Car {
    static String manufacture; // 클래스 필드
    String productName; // 인스턴스 필드
    String color; // 인스턴스 필드
    int maxSpeed; // 인스턴스 필드
    // 생성자는 클래스 이름과 동일하고 반환 타입이 없음, void도 없음
    // 생성자는 클래스가 객체로 만들어 질 때 호출되고, 생성자를 만들지 않으면 보이지 않는 생성자 호출
    // 생성자는 여라개 만들어 필요에 따라 적절한 생성자를 호출 가능(생성자 오버로딩)
    // 생성자 매개변수는 클래스를 객체로 만드는 위치에서 전달
    // 생성자의 목적은 클래스가 객체로 만들어 질때 해당 인스턴스 필드를 초기화 하는것*
    Car() {
        productName = "이름없는 차";
        color = "색상도 없음";
        maxSpeed = 0;
    }
    Car(String name, String color, int speed ){
        productName = name;
        this.color = color; // 매개변수로 전달된 변수와 인스턴스 필드의 이름이 같은 경우 this 필요
        maxSpeed = speed;
    }
    // setter 메소드
    void setName(String name) {
        productName = name;
    }
    void setColor(String color) {
        this.color = color;
    }
    void viewCar() {
        System.out.println("이름 : " + productName);
        System.out.println("색상 : " + color);
        System.out.println("최고 속도 : " + maxSpeed);
    }
}
