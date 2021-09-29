package com.montran.admin.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.montran.util.SessionFactoryUtil;
import com.montran.util.PasswordEncrypt;
import com.montran.admin.model.Admin;
import com.montran.admin.model.Faculty;
import com.montran.client.model.User;


public class AdminDAO {
	private SessionFactory sf;
	private Session session;
	
	public AdminDAO(){
		sf = SessionFactoryUtil.StartSessionFactory();
	}
	
	public boolean validate(String mailid,String password) {

		Transaction transaction = null;
		Admin admin = new Admin();
		String passwordEncrypt = null;
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();
			String key = "1";
			passwordEncrypt = PasswordEncrypt.encrypt(password, key);
			
			String hql = "FROM Admin A WHERE A.mailid = :mailid and A.password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("mailid", mailid);
			query.setParameter("password", passwordEncrypt);
			List<?> results = query.getResultList();
			
			if (results != null && !results.isEmpty()) {
				admin = (Admin) results.get(0);
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
		if(admin.getMailid().equals(mailid) && admin.getPassword().equals(passwordEncrypt))
			return true;
		else return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Long> roomDisplay() {

		Transaction transaction = null;
		List<Long> results = new ArrayList<>();
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			String hql1 = "SELECt COUNT(*) FROM Room R WHERE R.available = :available";
			String hql2 = "SELECt COUNT(*) FROM Room R WHERE R.available = :available";
			Query query1 = session.createQuery(hql1);
			query1.setParameter("available", true);
			Query query2 = session.createQuery(hql2);
			query2.setParameter("available", false);
			results.addAll(query1.getResultList());
			results.addAll(query2.getResultList());
			
			// commit transaction
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
		return results;
	}
	
	public boolean removeFaculty(int id) {
		boolean status = false;
		Transaction transaction = null;
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();

			Faculty faculty = session.get(Faculty.class, id);
			System.out.println(faculty.getFname()+"  "+faculty.getLname());
			if (faculty != null) {
				session.remove(faculty);
			}

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
	
	public boolean removeUser(int id) {
		boolean status = false;
		Transaction transaction = null;
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();

			User user = session.get(User.class, id);
			System.out.println(user.getFname()+"  "+user.getLname());
			if (user != null) {
				session.remove(user);
			}

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
