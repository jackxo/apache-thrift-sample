package thrift.demo1.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import thrift.demo1.generalcode.Hello;

/**
 * Server side implementation.
 * 
 * Steps: 
 * 1. Set server transport port (TServerSocket or TNonblockingServerSocket) 
 * 2. Set protocol factory (TBinaryProtocol, TCompactProtocol, TJSONProtocol or TSimpleJSONProtocol)
 * 3. Link processor to service implementation
 * 4. Combine above parameters to server arguments
 * 5. Start server (TThreadPoolServer, TThreadedSelectorServer or TSimpleServer)
 * 
 * @author Jack
 *
 */
public class HelloServiceServer {

	/**
	 * Start Thrift Server
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// Step1, Set server transport port (TServerSocket or
			// TNonblockingServerSocket)
			TServerSocket serverTransport = new TServerSocket(7911);

			// Step2, Set protocol factory (TBinaryProtocol, TCompactProtocol,
			// TJSONProtocol or TSimpleJSONProtocol)
			Factory proFactory = new TBinaryProtocol.Factory();

			// Step3, Link processor to service implementation
			TProcessor processor = new Hello.Processor(new HelloServiceImpl());

			// Step4, Combine above parameters to server arguments
			Args ag = new Args(serverTransport);
			ag.outputProtocolFactory(proFactory);
			ag.inputProtocolFactory(proFactory);
			ag.processor(processor);

			// Step5, Start server (TThreadPoolServer, TThreadedSelectorServer or TSimpleServer)
			TServer server = new TThreadPoolServer(ag);
			System.out.println("Start server on port 7911...");
			server.serve();

		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}
