package com.montran.client.dao;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import java.util.List;

import com.montran.util.SessionFactoryUtil;
import com.montran.util.PasswordEncrypt;
import com.montran.admin.model.Faculty;
import com.montran.client.model.Appointment;
import com.montran.client.model.Room;
import com.montran.client.model.User;

public class UserDAO {
	private SessionFactory sf;
	private Session session;
	
	public UserDAO(){
		sf = SessionFactoryUtil.StartSessionFactory();
	}
	
	public boolean validateUser(String mailid,String password) {

		Transaction transaction = null;
		User user = new User();
		String passwordEncrypt = null;
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();
			String key = "1";
			passwordEncrypt = PasswordEncrypt.encrypt(password, key);
			
			String hql = "FROM User U WHERE U.mailid = :mailid and U.password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("mailid", mailid);
			query.setParameter("password", passwordEncrypt);
			List<?> results = query.getResultList();
			
			if (results != null && !results.isEmpty()) {
				user = (User) results.get(0);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		if(user.getMailid().equals(mailid) && user.getPassword().equals(passwordEncrypt))
			return true;
		else return false;
	}
	
	public User searchUser(String mailid,String password) {
		Transaction transaction = null;
		User user = new User();
		String passwordEncrypt = null;
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();
			String key = "1";
			passwordEncrypt = PasswordEncrypt.encrypt(password, key);
			
			String hql = "FROM User U WHERE U.mailid = :mailid and U.password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("mailid", mailid);
			query.setParameter("password", passwordEncrypt);
			List<?> results = query.getResultList();
			
			if (results != null && !results.isEmpty()) {
				user = (User) results.get(0);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return user;
	}
	
	public boolean addUser(User user) {
		boolean status = false;
		Transaction transaction = null;
		
		try {
		session = sf.openSession();	
		transaction = session.beginTransaction();
		session.save(user);
		
		transaction.commit();
		status = (session.getTransaction().getStatus() == TransactionStatus.COMMITTED);
		}
		catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return status;
	}
	
	public Faculty getDoctor(String firstName,String lastName) {
		System.out.println("firstName : "+firstName+"\nlastName : "+lastName);
		Transaction transaction = null;
		Faculty faculty = new Faculty();
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			
			String hql = "FROM Faculty F WHERE F.fname = :fname and F.lname = :lname";
			Query query = session.createQuery(hql);
			query.setParameter("fname", firstName);
			query.setParameter("lname", lastName);
			List<?> results = query.getResultList();
			
			if (results != null && !results.isEmpty()) {
				faculty = (Faculty) results.get(0);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return faculty;
	}
	
	public User getUserById(int uid) {

		Transaction transaction = null;
		User user = new User();
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			
			String hql = "FROM User U WHERE U.uid = :uid";
			Query query = session.createQuery(hql);
			query.setParameter("uid", uid);
			List<?> results = query.getResultList();
			
			if (results != null && !results.isEmpty()) {
				user = (User) results.get(0);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return user;
	}
	
	public boolean addAppointment(Appointment appointment) {
		boolean status = false;
		Transaction transaction = null;
		
		try {
		session = sf.openSession();	
		transaction = session.beginTransaction();
		session.save(appointment);
		
		transaction.commit();
		status = (session.getTransaction().getStatus() == TransactionStatus.COMMITTED);
		}
		catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return status;
	}
	
	public boolean roomStatus(int rno) {

		Transaction transaction = null;
		Room room = new Room();
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			String hql = "FROM Room R WHERE R.rno = :rno";
			Query query = session.createQuery(hql);
			query.setParameter("rno", rno);
			List<?> results = query.getResultList();
			
			if (results != null && !results.isEmpty()) {
				room = (Room) results.get(0);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return room.isAvailable();
	}
	
	
	public boolean roomBooking(int rno,int uid) {
		boolean status = false;
		Transaction transaction = null;
		try {
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			Room room = session.get(Room.class, rno);
			User user = session.get(User.class, uid);
			user.setRoom(room);
			room.setAvailable(false);
			// commit transaction
			transaction.commit();
			status = (session.getTransaction().getStatus() == TransactionStatus.COMMITTED);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return status;
	}
}
