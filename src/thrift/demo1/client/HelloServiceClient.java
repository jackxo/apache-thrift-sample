package thrift.demo1.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import thrift.demo1.generalcode.Hello;

/**
 * Client side implementation.
 * 
 * Steps: 
 * 1. Set socket transport host & port (TSocket...) 
 * 2. Set transport protocol
 * 3. Open service client
 * 4. Invoke service method
 * 5. Connection close
 * 
 * @author Jack
 *
 */
public class HelloServiceClient {
	
	/**
	 * Client Side Implementation (Call Hello Service)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			// Step1, set socket transport host & port (TSocket...) 
			TTransport transport = new TSocket("localhost", 7911);
			transport.open();
			
			// Step2, set transport protocol
			TProtocol protocol = new TBinaryProtocol(transport);
			
			// Step3, open service client
			Hello.Client client = new Hello.Client(protocol);
			
			// Step4, invoke service method
			client.helloVoid();
			String helloString = client.helloString("Jack");
			
			// Step5, connection close
			transport.close();
			
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
	}
}
