package inter;
/*
 * interface : 클래스 대용품
 * 		인터페이스를 이용해서 다중 상속효과를 줌
 * 		단 추상메서드와 전역상수로 주로 구성
 */
public interface Player {
	public static final int STATUS_PLAY = 1;
	public static final int STATUS_STOP= 0;
	
	//아래 4개 method는 전부 추상 메서드 입니다.
	public abstract void play();
	void stop();//public abstract를 안써도 자동을 적용
	public void next();	
	public abstract void pre();
}
