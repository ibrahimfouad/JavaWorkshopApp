package org.ibrahimprojects.Test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ibrahimprojects.hibernate.Adress;
import org.ibrahimprojects.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails User =new UserDetails ();
		
		User.setUserName("ibrahim");
        UserDetails User2 =new UserDetails ();
		
		User2.setUserName("ahmed");
		
		Adress ad = new Adress();
		Adress ad2 = new Adress();
		ad.setStreet("street");
		ad.setCity("city");
		ad.setState("state");
		ad.setPincode("pincode");
		ad2.setStreet("street");
		ad2.setCity("city");
		ad2.setState("state");
		ad2.setPincode("pincode");
		
		User.setHomeAddrees(ad2);
//		User.setJoinDate(new Date());
//		User.setDescription("null");
		User2.setOfficeAddress(ad2);
//		User2.setJoinDate(new Date());
//		User2.setDescription("null");
		User.getListofaddreess().add(ad);
		User.getListofaddreess().add(ad2);
		SessionFactory sessionFactory =	new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(User);
	session.save(User2);
	session.getTransaction().commit();
	session.close();
	User=null;
	//fetch user again
    session = sessionFactory.openSession();
	session.beginTransaction();
   User =(UserDetails) session.get(UserDetails.class,1);
   System.out.print("Username retrieved is " + User.getHomeAddrees());
	
	
	
	
	
		
		

	}

}
 