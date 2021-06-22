
public class BreakQuest {
	/*
	 * 		xy
	 * 	+	yx
	 * 	----------
	 * 		99
	 */
	public static void main(String[] args) {
		for(int x=0;x<10;x++) {
			for(int y=0;y<10;y++) {
				if(x+ y == 9) {
					System.out.println("x : "+x+" , "+"y : "+y);
					break;
				}
			}
		}
	}

}
