package com.asksunny.rpc.thrift.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import com.asksunny.rpc.thrift.JsonRpcService;

public class ThriftRpcServer {

	public static void StartsimpleServer(
			JsonRpcService.Processor<ThriftRpcServerImpl> processor) {
		try {
			TServerTransport serverTransport = new TServerSocket(9090);
			TServer server = new TSimpleServer(
					new Args(serverTransport).processor(processor));
			System.out.println("Starting the simple server...");
			server.serve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				StartsimpleServer(new JsonRpcService.Processor<ThriftRpcServerImpl>(new ThriftRpcServerImpl()));				
			}
		});
		t.start();
		t.join();
		
	}
	
	
}
