import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		Random r = new Random();
		for(int i=0;i<10;i++)
		{
			//5~15
			System.out.println(r.nextInt(11)+5);
		}
	}

}
