/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.IMAS.ExtraClasses;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class ResetingAutoIncrement {

	@Autowired
	private static SessionFactory sessionFactory;

	public static void resetAutoIncrement(String tableName, String Id) {

		String first = "SET @num := 0;";
		String second = "UPDATE " + tableName + " SET " + Id+ "= @num := (@num+1);";
		String third = "ALTER TABLE " + tableName + " auto_increment = 1";

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(first);
		session.save(second);
		session.save(third);
		
		tx.commit();
		session.flush();
		session.clear();
		session.close();
	}
}
