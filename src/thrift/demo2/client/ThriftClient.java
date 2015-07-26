package thrift.demo2.client;

import java.util.Calendar;
import java.util.List;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import thrift.demo2.generalcode.Contact;
import thrift.demo2.generalcode.ContactManager;

public class ThriftClient {

	public static void main(String[] args) throws Exception {

		TTransport transport = new TSocket("localhost", 8111);
		TProtocol protocol = new TCompactProtocol(transport);
		
		ContactManager.Client client = new ContactManager.Client(protocol);
		transport.open();

		List<Contact> list = client.getAll();
		System.out.println(list);

		client.save(new Contact(1, "Jack", Calendar.getInstance()
				.getTimeInMillis(), "1389612222", "192.168.2.1", null));

		client.remove(1);
		transport.close();
	}
}
