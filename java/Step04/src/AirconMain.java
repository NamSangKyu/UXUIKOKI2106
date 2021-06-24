
public class AirconMain {

	public static void main(String[] args) {
		Aircon air = new Aircon();
		air.powerOnOff();
		air.powerOnOff();
		air.powerOnOff();
		
		for(int i=0;i<15;i++)
			air.tempUp();
//		air.temp = -100; private으로 설정된 변수나 메서드는 접근이 불가
		for(int i=0;i<15;i++)
			air.tempDown();
		
		for(int i=0;i<10;i++)
			air.setTimer();
		for(int i=0;i<10;i++)
			air.setWindPower();
	}

}
