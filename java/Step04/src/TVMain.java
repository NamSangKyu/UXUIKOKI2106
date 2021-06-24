
public class TVMain {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.powerOnOff();
		tv.powerOnOff();
		tv.powerOnOff();
		
		for(int i=0;i<40;i++)
			tv.chDown();
		for(int i=0;i<40;i++)
			tv.chUp();
		tv.muteOnOff();
		for(int i=0;i<40;i++)
			tv.volDown();
		tv.muteOnOff();
		for(int i=0;i<40;i++)
			tv.volUp();
		
		
	}

}
