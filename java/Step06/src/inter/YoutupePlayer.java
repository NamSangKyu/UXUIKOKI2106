package inter;

public class YoutupePlayer implements Player{

	@Override
	public void play() {
		System.out.println("유튜브 동영상 재생");
	}
	@Override
	public void stop() {
		System.out.println("유튜브 동영상 정지");
	}
	@Override
	public void next() {
		System.out.println("유튜브 다음 추천 동영상 재생");
	}

	@Override
	public void pre() {
		System.out.println("유튜브 동영상 이전 목록 재생");
	}

}
