package thrift.demo2.server;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;

import thrift.demo2.generalcode.Contact;
import thrift.demo2.generalcode.ContactManager;

public class ContactManagerImpl implements ContactManager.Iface {

	public List<Contact> getAll() throws TException {
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact(1, "Jack", Calendar.getInstance()
				.getTimeInMillis(), "1389612222", "192.168.2.1", null));
		return contacts;
	}

	public List<Contact> query(Map<String, String> conditions)
			throws TException {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact(1, "Jack", Calendar.getInstance()
				.getTimeInMillis(), "1389612222", "192.168.2.1", null));
		return contacts;
	}

	public void remove(int id) throws TException {
		System.out.println("invoke: remove,id = " + id);
	}

	public void save(Contact contact) throws TException {
		System.out.println("invoke: save,contact = " + contact);

	}

}
