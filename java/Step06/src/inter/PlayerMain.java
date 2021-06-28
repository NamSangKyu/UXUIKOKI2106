package inter;

public class PlayerMain {
	
	public static void player(Player p) {
		//인터페이스로 형변환 후 실행이 가능한 것은
		//선언해 놓은 추상메서드를 이용하여 해당객체를 제어를 할수있다.
		p.play();
		p.next();
		p.pre();
		p.stop();
	}
	
	public static void main(String[] args) {
		MusicPlayer musicPlayer = new MusicPlayer();
		YoutupePlayer youtupePlayer = new YoutupePlayer();
		
		player(youtupePlayer);
		player(musicPlayer);
	}

}
