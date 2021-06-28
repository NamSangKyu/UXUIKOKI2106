package inter;

public class YoutupePlayer implements Player, Share{

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
	@Override
	public void snsShare() {
		System.out.println("인스타에 해당 유튜브 동영상 공유");
	}

}







