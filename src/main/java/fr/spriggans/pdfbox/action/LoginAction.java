package fr.spriggans.pdfbox.action;

public class LoginAction {

	private String username;

	private String password;
	
	// all struts logic here
	public String execute() {

		// TODO : login
		System.out.println(username);
		System.out.println(password);
		
		return "SUCCESS";
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}