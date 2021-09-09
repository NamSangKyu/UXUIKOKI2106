package service;

public class MemberService {
	private static MemberService instance = new MemberService();

	public MemberService() {
	}

	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberService();
		return instance;
	}
	
	
}
