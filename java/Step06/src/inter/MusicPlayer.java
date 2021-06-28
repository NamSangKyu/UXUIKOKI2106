package inter;

public class MusicPlayer implements Player{
	private int status;

	@Override
	public void play() {
		System.out.println("음악 재생");
		status = STATUS_PLAY;
	}
	@Override
	public void stop() {
		System.out.println("음악 재생 정지");
		status = Player.STATUS_STOP;
	}
	@Override
	public void next() {
		System.out.println("다음곡 재생");
	}
	@Override
	public void pre() {
		System.out.println("이전곡 재생");
	}
	
}
