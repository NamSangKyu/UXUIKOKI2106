
public class AirconMain {

	public static void main(String[] args) {
		Aircon air = new Aircon();
		air.powerOnOff();
		air.powerOnOff();
		air.powerOnOff();
		air.powerOnOff();
		
		for(int i=0;i<15;i++)
			air.tempUp();
		
		for(int i=0;i<15;i++)
			air.tempDown();
	}

}
