package _protected;

public class MixDog extends Dog {

	public MixDog(int age) {
		super(age);
	}
	
	public void setAge() {
		age /= 2;
	}
}
