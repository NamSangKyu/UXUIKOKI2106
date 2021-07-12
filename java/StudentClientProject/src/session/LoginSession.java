package session;

import java.util.Calendar;

public class LoginSession {
	private static LoginSession instance = new LoginSession();
	private Calendar sesstionTime;
	private boolean login;
	private String name;
	private String sno;
	
	private LoginSession() {	}

	public static LoginSession getInstance() {
		if(instance == null)
			instance = new LoginSession();
		return instance;
	}

	//로그인 처리
	public void login(String sno, String name) {
		this.sno = sno;
		this.name = name;
		sesstionTime = Calendar.getInstance();
		sesstionTime.add(Calendar.MINUTE, 10);
		this.login = true;		
	}
	//로그인 세션 유효 시간 늘림
	public boolean updateSession() {
		if(!login) return false;
		Calendar curr = Calendar.getInstance();
		if(curr.getTimeInMillis() > sesstionTime.getTimeInMillis()) {
			login = false;
			sesstionTime = null;
			return false;
		}
		curr.add(Calendar.MINUTE, 10); //현재 시간 기준으로 세션 유효시간 증가
		sesstionTime = curr;		
		return true;
	}
	
	
	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSno() {
		return sno;
	}

	public void setsno(String sno) {
		this.sno = sno;
	}
	
	
	
	
	
}
