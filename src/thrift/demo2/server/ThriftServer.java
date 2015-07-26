package thrift.demo2.server;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TCompactProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

import thrift.demo2.generalcode.ContactManager;
import thrift.demo2.generalcode.ContactManager.Iface;

public class ThriftServer {

	public static void main(String[] args) throws Exception {
		
		TServerSocket serverSocket = new TServerSocket(8111);
		ContactManager.Processor<Iface> processor = new ContactManager.Processor<Iface>(
				new ContactManagerImpl());
		Factory factory = new TCompactProtocol.Factory();
		
		Args ag = new Args(serverSocket);
		ag.outputProtocolFactory(factory);
		ag.inputProtocolFactory(factory);
		ag.processor(processor);
		
		TServer server = new TSimpleServer(ag);
		System.out.println("Start server on port 8111...");
		server.serve();
	}

}
