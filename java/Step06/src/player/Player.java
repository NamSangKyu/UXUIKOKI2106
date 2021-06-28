package player;

public class Player {
	private int hp;
	private Skill skill;
	
	public Player(Skill skill) {
		super();
		this.skill = skill;
		hp = 100;
	}
	
	public void skillExcute(Player player) {
		skill.excute(player);
	}
	
	public void death() {
		System.out.println("Player가 사망하였습니다.");
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
		System.out.println("현재 hp : "+hp);
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	
	
}






