package inner;

public class InnerClass {
	
	private int inNum;
	private static double pi = 3.1415;
	public InnerClass() {
		inNum = 10;
	}
	
	//InnerClass가 생성이 되야 InClass 코드가 생성
	public class InClass{
		public void printInNum(){
			System.out.println(inNum);
		}
	}
	public static class InStaticClass{
		public void printInNum() {
			//None Static 필드 접근 불가
			//System.out.println(inNum);
			//static은 접근 가능
			System.out.println(pi);
		}
	}
	public int getInNum() {
		return inNum;
	}

	public void setInNum(int inNum) {
		this.inNum = inNum;
	}
	
	
}
