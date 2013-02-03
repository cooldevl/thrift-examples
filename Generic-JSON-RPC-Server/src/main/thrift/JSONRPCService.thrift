namespace java com.asksunny.rpc.thrift
namespace cpp com.asksunny.rpc.thrift
namespace csharp Com.Asksunny.Rpc.Thrift
namespace py JsonRPC
namespace php JsonRPC
namespace perl JsonRPC
namespace rb JsonRPC

const string VERSION = "1.0.0"


exception RPCException
{
	1: required i32 errorCode;
	2: required string stackTrace;
	3: required string jsonCommand;
}

typedef list<string> RAWData

enum RpcType {
  SYNC = 1;
  ASYNC_POLL = 2;
  ASYNC_DELAY = 3;
  ASYNC_CALLBACK = 4
}

struct RpcCommand {
   1: required string jsonCommand;
   2: required RpcType rpcType;
   3: required i64 timestamp;
   4: optional string credential;
   5: optional string clientId;
   6: optional string clientAddress;
}

service JsonRpcService{
	string invoke(1: RpcCommand rpcCommand) throws (1: RPCException rex);
	string invokeWithArgs(1: RpcCommand rpcCommand, 2: RAWData rawArgs) throws (1: RPCException rex);

}
