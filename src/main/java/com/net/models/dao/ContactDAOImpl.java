package com.net.models.dao;

import java.util.List;

import com.net.models.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;


@Repository
public class ContactDAOImpl implements ContactDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addContact(Contact contact){
		sessionFactory.getCurrentSession().save(contact);
	}
	
	public List<Contact> listContact(){
		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}
	
	public void removeContact(Integer id){
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
		
		if(null != contact ){
			sessionFactory.getCurrentSession().delete(contact);
		}
	}

}
