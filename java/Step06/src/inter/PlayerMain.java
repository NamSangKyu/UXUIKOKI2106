package inter;

public class PlayerMain {

	public static void main(String[] args) {
		MusicPlayer musicPlayer = new MusicPlayer();
		musicPlayer.play();
		musicPlayer.stop();
		musicPlayer.next();
		musicPlayer.pre();
	}

}
