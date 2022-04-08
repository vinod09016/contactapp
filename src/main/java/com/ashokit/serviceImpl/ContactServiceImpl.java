package com.ashokit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Contact;
import com.ashokit.repository.ContactRepository;
import com.ashokit.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService {

	@Autowired
	ContactRepository repository;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSw("Y");
		Contact save = repository.save(contact);
		if (save.getContactId() != null) {
			return true;
		}
		return false;

	}

	@Override
	public List<Contact> getAllContacts() {

		Contact contact = new Contact();
		contact.setActiveSw("Y");
		return repository.findAll(Example.of(contact));
	}

	@Override
	public Contact getContactById(Integer ContactId) {

		Optional<Contact> findById = repository.findById(ContactId);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteContactById(Integer ContactId) {
		Optional<Contact> findById = repository.findById(ContactId);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSw("N");
			repository.save(contact);
			return true;
		} else {
			return false;
		}

	}

}
