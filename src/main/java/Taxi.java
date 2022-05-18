class Taxi extends Car{
    static int taxi_number; // 택시 번호
    int oil; // 기름 양
    int speed; // 현재 속도
    int goal; // 승객이 입력할 목적지
    int basic_distance = 100; // 기본요금만 받는 거리
    int now_distance; // 현재 위치
    int goal_distance; // 목적지까지의 거리
    int basic_cost = 3000; // 기본요금
    int distance_cost = 500; // 거리당 추가요금
    int total_cost; // 총 결제할 요금
    boolean state; // 택시의 상태 (운행 중 or 일반 )


    public Taxi() {
        ++this.taxi_number;
        this.oil =(int)(Math.random()*20);
        this.speed = 0;
        this.now_distance = 0;
        this.state = true;
        System.out.println("택시의 번호는"+taxi_number+"번 입니다.");
    }

    public void setGoal_distance(int goal) {
        this.goal_distance = Integer.max(goal,now_distance) - Integer.min(goal,now_distance);
    }

    //1. 운행시작
    void Check() {
        System.out.println("기름이 "+oil+"남았습니다.");
        state = oil >= 10 ? true : false;
    }
    //2. 승객탑승
    void Ride (int goal) {
        this.goal = goal;

        if (state) {
            System.out.print("승객이 탑승했습니다. ");
            System.out.println("목적지는 : " + goal);
        }
        else {
            System.out.println("탑승 불가");
        }

    }

    //3. 속도변경
    void Speed(int input_speed) {
        if (state) {
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

    }
    //4. 거리당 요금 추가
    void Totalcost() {
        if (state) {
            if (basic_distance - goal > 0 || basic_distance - goal == 0)
                total_cost = basic_cost;
            else
                total_cost= basic_cost + (distance_cost * ((goal - basic_distance)/10));
            System.out.println("최종 요금은 "+total_cost+"입니다.");
        }
    }
    //5. 요금결제
    void Payment() {
        Totalcost();
        state = true;
        System.out.println("승객이 내려서 택시는 일반상태 입니다.");

    }


}