package inheritance;

public class AnimalMain {
	
	public static void eat(Animal animal) {
		animal.eat();
	}
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		System.out.println("-------------");
		Dog dog = new Dog();
		System.out.println("-------------");
		Person person = new Person();
		System.out.println("-------------");

		//		animal.eat();
//		dog.eat();
//		person.eat();
		
		eat(animal);
		eat(dog);
		eat(person);
	}

}





