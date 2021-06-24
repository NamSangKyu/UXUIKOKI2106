
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
	
	
	
}
