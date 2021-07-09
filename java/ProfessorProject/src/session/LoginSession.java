package session;

public class LoginSession {
	private static LoginSession instance = new LoginSession();
	
	private boolean login;
	private String name;
	private String pno;
	
	private LoginSession() {	}

	public static LoginSession getInstance() {
		if(instance == null)
			instance = new LoginSession();
		return instance;
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

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}
	
	
	
	
	
}
