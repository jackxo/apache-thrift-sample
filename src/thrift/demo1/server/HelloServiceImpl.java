package thrift.demo1.server;

import org.apache.thrift.TException;

import thrift.demo1.generalcode.Hello;
import thrift.demo1.generalcode.Hello.Iface;

/**
 * 创建 HelloServiceImpl.java 文件并实现 Hello.java 文件中的 Hello.Iface 接口
 * 
 * Service implementation, please write the business logic in this class.
 * 
 * @author Jack
 *
 */
public class HelloServiceImpl implements Hello.Iface {
	
	@Override
	public boolean helloBoolean(boolean para) throws TException {
		return para;
	}

	@Override
	public int helloInt(int para) throws TException {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return para;
	}

	@Override
	public String helloNull() throws TException {
		return null;
	}

	@Override
	public String helloString(String para) throws TException {
		System.out.println("Welcome " + para + " ^-&");
		return "Welcome " + para + " ^-&";
	}

	@Override
	public void helloVoid() throws TException {
		System.out.println("Hello World");
	}
}
