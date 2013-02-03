package com.asksunny.rpc.thrift.server;

import java.util.List;

import org.apache.thrift.TException;

import com.asksunny.rpc.thrift.JsonRpcService;
import com.asksunny.rpc.thrift.RPCException;
import com.asksunny.rpc.thrift.RpcCommand;

public class ThriftRpcServerImpl implements JsonRpcService.Iface {

	public String invoke(RpcCommand rpcCommand) throws RPCException, TException 
	{
		
		return "It is supposed to be Json string";
	}

	public String invokeWithArgs(RpcCommand rpcCommand, List<String> rawArgs)
			throws RPCException, TException
	{
		
		return "It is supposed to be Json string";
	}

}
