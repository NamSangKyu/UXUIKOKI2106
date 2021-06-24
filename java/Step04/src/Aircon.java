
public class Aircon {
	boolean power;
	int temp;
	int windPower;
	int mode;
	int deg;
	int timer;
	final int MIN_TEMP = 18;
	final int MAX_TEMP = 30;
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
	void powerOnOff() {
		power = !power;
		if(power)
			System.out.println("에어컨 전원 켜졌습니다.");
		else
			System.out.println("에어컨 전원 꺼졌습니다.");
			
	}
	//온도를 올리는 기능
	
	//온도를 내리는 기능
	
	
	
}







