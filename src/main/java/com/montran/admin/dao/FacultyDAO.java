package com.montran.admin.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.montran.admin.model.Faculty;
import com.montran.util.PasswordEncrypt;
import com.montran.util.SessionFactoryUtil;

public class FacultyDAO {
	private SessionFactory sf;
	private Session session;
	
	public FacultyDAO(){
		sf = SessionFactoryUtil.StartSessionFactory();
	}
	
	public boolean validateFaculty(String mailid,String password) {

		Transaction transaction = null;
		Faculty faculty = new Faculty();
		String passwordEncrypt = null;
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();
			String key = "1";
			passwordEncrypt = PasswordEncrypt.encrypt(password, key);
			
			String hql = "FROM Faculty F WHERE F.mailid = :mailid and F.password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("mailid", mailid);
			query.setParameter("password", passwordEncrypt);
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
		if(faculty.getMailid().equals(mailid) && faculty.getPassword().equals(passwordEncrypt))
			return true;
		else return false;
	}
	
	public Faculty searchFaculty(String mailid,String password) {

		Transaction transaction = null;
		Faculty faculty = new Faculty();
		String passwordEncrypt = null;
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();
			String key = "1";
			passwordEncrypt = PasswordEncrypt.encrypt(password, key);
			
			String hql = "FROM Faculty F WHERE F.mailid = :mailid and F.password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("mailid", mailid);
			query.setParameter("password", passwordEncrypt);
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
	
	public Faculty searchFacultyByPass(String password) {

		Transaction transaction = null;
		Faculty faculty = new Faculty();
		String passwordEncrypt = null;
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();
			String key = "1";
			passwordEncrypt = PasswordEncrypt.encrypt(password, key);
			
			String hql = "FROM Faculty F WHERE F.password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("password", passwordEncrypt);
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
	
	public boolean addFaculty(Faculty faculty) {
		boolean status = false;
		Transaction transaction = null;
		
		try {
		session = sf.openSession();	
		transaction = session.beginTransaction();
		session.save(faculty);
		
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
	
	public boolean docAvail(boolean value,Faculty faculty) {
		boolean status = false;
		Transaction transaction = null;
		try {
			session = sf.openSession();
			transaction = session.beginTransaction();

			faculty.setAvailable(value);
			session.saveOrUpdate(faculty);

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
	
	public boolean docSession(String value,Faculty faculty) {
		boolean status = false;
		Transaction transaction = null;
		try {
			session = sf.openSession();
			transaction = session.beginTransaction();

			faculty.setSessions(value);
			session.saveOrUpdate(faculty);

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
	
	public boolean docFees(Float amount,Faculty faculty) {
		boolean status = false;
		Transaction transaction = null;
		try {
			session = sf.openSession();
			transaction = session.beginTransaction();

			faculty.setFees(amount);
			session.saveOrUpdate(faculty);

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
	
	
	@SuppressWarnings("unchecked")
	public List<Long> totalFaculty() {

		Transaction transaction = null;
		List<Long> results = new ArrayList<>();
		try  {
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			String hql1 = "SELECt COUNT(*) FROM Faculty F WHERE F.available = :available";
			String hql2 = "SELECt COUNT(*) FROM Faculty F WHERE F.available = :available";
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
}
