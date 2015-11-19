package app.IMAS.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.IMAS.Daos.LoginDao;
import app.IMAS.Entities.Login;
import app.IMAS.Services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Transactional
	public Login getAdmin() {
		return loginDao.getAdmin();
	}

	@Transactional
	public String getPassword() {
		return loginDao.getPassword();
	}

	@Transactional
	public int changePassword(String password) {
		return loginDao.changePassword(password);
	}

}
