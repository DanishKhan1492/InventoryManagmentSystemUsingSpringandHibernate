package app.IMAS.Services;

import app.IMAS.Entities.Login;

public interface LoginService {
	public Login getAdmin();
    public String getPassword();
    public int changePassword(String password);
}
