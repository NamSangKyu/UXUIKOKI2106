package player;

public class FireBall extends Skill{
	@Override
	public void excute(Player player) {
		//플레이어 hp 포인트 감소
		System.out.println("FireBall ~~!");
		player.setHp(player.getHp()-30);
		//hp 0이하면 해당플레이어 사망처리
		if(player.getHp() <= 0)
			player.death();
	}
}
