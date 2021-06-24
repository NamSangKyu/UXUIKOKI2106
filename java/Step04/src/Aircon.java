
public class Aircon {
	private boolean power;
	private int temp;
	private int windPower;
	private int mode;
	private int deg;
	private int timer;
	private final int MIN_TEMP = 18;
	private final int MAX_TEMP = 30;
	public Aircon(boolean power, int temp, int windPower, int mode, int deg, int timer) {
		super();
		this.power = power;
		this.temp = temp;
		this.windPower = windPower;
		this.mode = mode;
		this.deg = deg;
		this.timer = timer;
	}
	public Aircon() {
		power = false;
		temp = 24;
		windPower = 1;
	}
		
	//에어컨 전원 켜고 끄고 기능, true 전원 On, false 전원 Off
	public void powerOnOff() {
		power = !power;
		if(power)
			System.out.println("에어컨 전원 켜졌습니다.");
		else
			System.out.println("에어컨 전원 꺼졌습니다.");
			
	}
	//온도를 올리는 기능
	public void tempUp() {
		//전원이 켜져 있을때만 동작하게끔 설정
		if(!power) return;
		if(temp == MAX_TEMP)
			return;
		temp++;
		System.out.println("현재 온도 : "+temp );
	}
	//온도를 내리는 기능
	public void tempDown() {
		if(!power) return;
		if(temp > MIN_TEMP)
			temp--;
		System.out.println("현재 온도 : "+temp );
	}
	//타이머 : 30분 단위로 지정이 가능, 최대 4시간까지 지정이 가능
//			 누를떄마다 30분씩 증가
	void setTimer() {
		timer += 30;
		if(timer > 240) {
			timer = 0;
			System.out.println("타이머 해제");
		}else {
			System.out.println(timer + "분 뒤 종료");
		}
	}
	//바람세기 : 1, 2, 3, 자동 --> 데이터는 계속 순환
	/*
	 *  바람세기 : 1
	 *  바람세기 : 2
	 *  바람세기 : 3
	 *  바람세기 : 자동
	 *  바람세기 : 1
	 *  ...
	 */
	void setWindPower() {
		windPower++;
		if(windPower > 4)
			windPower = 1;
		switch(windPower) {
		case 1:
		case 2:
		case 3:
			System.out.println("바람세기 : " + windPower);
			break;
		default:
			System.out.println("바람세기 : 자동");
				
		}
	}
	
}







