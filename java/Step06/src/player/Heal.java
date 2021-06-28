package player;

public class Heal extends Skill{
	@Override
	public void excute(Player player) {
		//플레이어 hp를 20 추가
		player.setHp(20);
	}
}
