package user;

public class UserExceptionTest {
	public static void test() throws UserException {
		throw new UserException("test 메서드 Exception");
	}
	public static void main(String[] args) {
		try {
			System.out.println(1);
			boolean flag = true;
			if(flag)
				throw new UserException("사용자 정의 Exception 발생");
			System.out.println(2);
		}catch (UserException e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println(3);
			
		}
		System.out.println(4);
		try {
			test();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

}








