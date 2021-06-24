
public class TV {
	private boolean power;
	private int ch;
	private int vol;
	private boolean mute;
	private final int MAX_CH = 789;
	private final int MIN_CH = 1;
	private final int MAX_VOL = 30;
	private final int MIN_VOL = 0;
	
	public TV() {
		ch = 24;
		vol = 14;
	}
	
	public void powerOnOff() {
		power = !power;
		if(power) 
			System.out.println("TV 전원 On");
		else
			System.out.println("TV 전원 Off");
	}
	
	public void muteOnOff() {
		mute = !mute;
		if(mute) 
			System.out.println("음소거 활성화");
		else
			System.out.println("움소거 비활성화");
	}
	
	public void chUp() {
		if(!power) return;
		ch++;
		if(ch > MAX_CH) 
			ch = MIN_CH;
		System.out.println("현재 채널 : "+ch);
	}
	public void chDown() {
		if(!power) return;
		ch--;
		if(ch < MIN_CH) 
			ch = MAX_CH;
		System.out.println("현재 채널 : "+ch);
	}
	
	public void volUp() {
		if(!power) return;
		if(mute) {
			muteOnOff();
			System.out.println("현재 음량 : "+vol);
			return;
		}
		if(vol < MAX_VOL)
			vol++;
		System.out.println("현재 음량 : "+vol);
	}
	
	public void volDown() {
		if(!power) return;
		if(mute) {
			muteOnOff();
			System.out.println("현재 음량 : "+vol);
			return;		
		}
		if(vol > MIN_VOL)
			vol--;
		System.out.println("현재 음량 : "+vol);
	}
}








