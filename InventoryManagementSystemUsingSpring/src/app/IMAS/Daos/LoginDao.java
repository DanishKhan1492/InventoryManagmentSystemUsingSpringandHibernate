package app.IMAS.Daos;

import app.IMAS.Entities.Login;


public interface LoginDao {
    public Login getAdmin();
    public String getPassword();
    public int changePassword(String password);
}
