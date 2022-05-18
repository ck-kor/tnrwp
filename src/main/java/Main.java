public class Main {
    public static void main(String[] args) {

        Taxi taxi = new Taxi();
        Taxi taxi1 = new Taxi();
        taxi.Check();
        taxi.Ride(300);
        taxi.Speed(201);
        taxi.Payment();

        Bus bus = new Bus();
        Bus bus1 = new Bus();
        bus.Check();
        bus.Ride();bus.Ride();bus.Ride();bus.Ride();bus.Ride();bus.Ride();bus.Ride();
        bus.Speed(100);
        bus.Speed(-50);
        // 인터페이스로 Ride(), Check(), Speed() 메소드이름 정해주면 좋겠다.
        // 추상클래스 Car 만들어서 (차번호, 주유량, 속도, 상태) 변수를 선언해주면 좋겠다. //
        // class Bus extends Car Implement Routine
    }
}