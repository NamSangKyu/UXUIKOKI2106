package player;

public class GameMain {

	public static void main(String[] args) {
		Player p1 = new Player(new Heal());
		Player p2 = new Player(new FireBall());
		
		
		p2.skillExcute(p1);
		p2.skillExcute(p1);
		p2.skillExcute(p1);
		p1.skillExcute(p1);
		p1.skillExcute(p1);
		p2.skillExcute(p1);
		p1.setSkill(new FireBall());
		p1.skillExcute(p2);
		p1.skillExcute(p2);
		p1.skillExcute(p2);
		p1.skillExcute(p2);
		
	}

}



