class Bus extends Car{
    int max_customer = 40; // 최대 손님
    int now_customer; // 시작손님
    int cost = 1200; // 요금 1200원
    static int bus_number; // 버스 번호
    int oil; // 기름 양
    int speed; // 현재 속도
    String state; // 운행, 운행중, 차고지행, 종료

    public Bus() {
        this.max_customer = max_customer;
        this.now_customer = (int)(Math.random()*20);
        ++this.bus_number;
        this.oil =(int)(Math.random()*20);
        this.speed = 0;
        this.state = "운행";
        System.out.println(bus_number+"번 버스입니다.");
    }

    void Check() {
        if (oil<10) {
            System.out.println("주유가 필요하다");
            state = "차고지행";
        }
        if (state.equals("종료")) {
            System.out.println("운행을 종료합니다.");
            state = "차고지행";
        }
        System.out.println("기름이 : "+ oil+" 남았습니다.");
    }

    void Ride () {
        int customer = (int)(Math.random()*20);
        if (state.equals("운행") || state.equals("운행중")) {
            for (int i=0; i<customer; i++) {
                ++now_customer;
                if (max_customer<now_customer) {
                    System.out.print("승객 초과  ");
                    --now_customer;
                    state= "운행중";
                    break;
                }
            }
            System.out.println("현재 승객 : "+now_customer);
        }
    }

    void Speed (int input_speed) {
        if (oil>=10) {
            System.out.print("현재 속도는 "+speed);

            if (speed + input_speed <= 0)
                speed=0;
            else
                speed += input_speed;
            System.out.println("  변경할 속도는 "+speed);
            if (speed + input_speed >200) {
                speed = 200;
                System.out.println("속도를 200으로 제한합니다.");
            }
        }
        else {
            System.out.println("주유량을 확인해주세요");
        }

    }
}