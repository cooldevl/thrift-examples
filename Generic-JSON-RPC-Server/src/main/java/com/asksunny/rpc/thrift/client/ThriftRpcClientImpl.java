package com.asksunny.rpc.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import com.asksunny.rpc.thrift.JsonRpcService;
import com.asksunny.rpc.thrift.RPCException;
import com.asksunny.rpc.thrift.RpcCommand;
import com.asksunny.rpc.thrift.RpcType;


public class ThriftRpcClientImpl {

	public static void main(String[] args) {

		try {
			TTransport transport;

			transport = new TSocket("localhost", 9090);
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			JsonRpcService.Client client = new JsonRpcService.Client(protocol);
			RpcCommand command = new RpcCommand();
			command.setJsonCommand("test").setRpcType(RpcType.SYNC).setTimestamp(System.currentTimeMillis());
			
			System.out.println(client.invoke(command));

			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException x) {
			x.printStackTrace();
		}

	}

}
