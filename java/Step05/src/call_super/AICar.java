package call_super;

public class AICar extends Car{
	private String driverID;
	private boolean drivingMode;
	
	public AICar(int fuel, String driverID) {
		super(fuel);
		this.driverID = driverID;
	}

	@Override
	public void run() {
		if(drivingMode)
			System.out.println("자율 주행 모드로 주행을 시작합니다.");
		else
			super.run();
	}

	public void changeMode() {
		drivingMode = !drivingMode;
		run();
	}
	
}
