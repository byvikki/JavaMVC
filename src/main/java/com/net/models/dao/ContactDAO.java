package com.net.models.dao;

import com.net.models.Contact;
import java.util.List;

public interface ContactDAO {

	
	public void addContact(Contact contact);
	
	public List<Contact> listContact();
	
	public void removeContact(Integer id);
}
