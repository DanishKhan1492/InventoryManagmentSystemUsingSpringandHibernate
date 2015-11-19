package app.IMAS.DaosImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.IMAS.Daos.LoginDao;
import app.IMAS.Entities.Login;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public Login getAdmin() {
		return (Login) session.getCurrentSession().createQuery("from Login").uniqueResult();
	}

	@Override
	public String getPassword() {
		Login login=new Login();
		login=(Login)session.getCurrentSession().createQuery("from Login").uniqueResult();
		String password=login.getPassword();
		return password;
	}

	@Override
	public int changePassword(String password) {
		int status=session.getCurrentSession().createQuery("update Login Set AdminPassword=:pass Where AdminName='admin'").setString("pass", password).executeUpdate();
		return status;
	}

}
