package fiinal_class;

import java.util.Random;

public class Employee {
	public final int getSalary() {
		Random r = new Random();
		return r.nextInt(5000)+300;
	}
}
