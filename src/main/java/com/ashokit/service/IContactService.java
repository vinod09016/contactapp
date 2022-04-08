package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.Contact;

public interface IContactService {

	public boolean saveContact(Contact contact);

	public List<Contact> getAllContacts();

	public Contact getContactById(Integer ContactId);

	public boolean deleteContactById(Integer contactId);
}
