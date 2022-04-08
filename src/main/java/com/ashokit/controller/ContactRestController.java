package com.ashokit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.constant.AppConstant;
import com.ashokit.entity.Contact;
import com.ashokit.properties.AppProperties;
import com.ashokit.service.IContactService;

@RestController
public class ContactRestController {

	@Autowired
	private IContactService service;

	@Autowired
	private AppProperties properties;

	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact) {
		boolean status = service.saveContact(contact);
		Map<String, String> message = properties.getMessage();

		if (status) {
			return message.get(AppConstant.CONTACT_SAVE_SUCC);
		} else {
			return message.get(AppConstant.CONTACT_SAVE_FAIL);
		}
	}

	@GetMapping("/get")
	public List<Contact> fetchAllContacts() {
		return service.getAllContacts();
	}

	@GetMapping("/contact/{cid}")
	public Contact fetchContactById(@PathVariable("cid") Integer contactId) {
		Contact id = service.getContactById(contactId);
		return id;
	}

	@DeleteMapping("/delete/{cid}")
	public String deleteByContactId(@PathVariable("cid") Integer contactId) {
		boolean status = service.deleteContactById(contactId);
		Map<String, String> message = properties.getMessage();
		if (status) {
			return message.get(AppConstant.CONTACT_DELETE_SUCC);
		} else {
			return message.get(AppConstant.CONTACT_DELETE_FAIL);
		}
	}
}
