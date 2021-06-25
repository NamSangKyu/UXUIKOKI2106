public class Car {
	//field
	int speed;
	int gear;
	boolean power;
	boolean wiper;
	boolean light;
	double fuel;
	final int MAX_SPEED = 300;
	
	public Car(int speed, int gear, boolean power, boolean wiper, boolean light, double fuel) {
		super();
		this.speed = speed;
		this.gear = gear;
		this.power = power;
		this.wiper = wiper;
		this.light = light;
		this.fuel = fuel;
	}
	
	public void powerOnOff() {
		power = !power;
		System.out.println(power ? "시동을 걸었습니다." : "시동을 껐습니다.");
	}
	
	public void gearUp() {
		if(gear < 6)
			gear++;
		switch(gear) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			System.out.println(gear + "단으로 변경");
			break;
		case 0:
			System.out.println("중립기어로 변경");
			break;
		case -1:
			System.out.println("R단으로 변경");
			break;
		case -2:
			System.out.println("P으로 변경");
			break;
		}
	}
	
	public void accelator() {
		if(gear == 0 && gear == -2)
			return;
		int val = gear == -1 ? -gear : gear;
		if(speed < MAX_SPEED * ((double)val/6))
			speed += 10;
		System.out.println("현재 속도 : "+speed);
	}
	public void breakPush() {
		speed -= 5;
		if(speed < 0)
			speed = 0;
		System.out.println("현재 속도 : "+speed);
	}
	
}





