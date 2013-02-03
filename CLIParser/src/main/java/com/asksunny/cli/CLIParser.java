package com.asksunny.cli;

public class CLIParser {

	private CLIParser(){		
	}
	
	public static CLIParameters parse(String[] cliArguments)
	{
		int index = 0;
		
		CLIParameters params = new CLIParameters();
		
		for (int i = 0; i < cliArguments.length; i++) {
			String param = cliArguments[i];
			String paramName = null;
			String paramVal = null;
			if(param.startsWith(CLIParameters.CLI_ARG_NAME_PREFIX_DOUBLE)){
				paramName = param.substring(2);
				if(i< (cliArguments.length-1) && !cliArguments[i+1].startsWith(CLIParameters.CLI_ARG_NAME_PREFIX_SINGLE)){
					paramVal = cliArguments[i+1];
					if(paramVal.startsWith("\\-")){
						paramVal = paramVal.substring(1);
					}
					i++;
				}else{
					paramVal = null;
				}
			}else if(param.startsWith(CLIParameters.CLI_ARG_NAME_PREFIX_SINGLE)){
				paramName = param.substring(1);
				if(i< (cliArguments.length-1) && !cliArguments[i+1].startsWith(CLIParameters.CLI_ARG_NAME_PREFIX_SINGLE)){
					paramVal = cliArguments[i+1];
					if(paramVal.startsWith("\\-")){
						paramVal = paramVal.substring(1);
					}
					i++;
				}else{
					paramVal = null;
				}
			}else{
				paramName = String.valueOf(index++);
				paramVal = param;				
			}
			params.addParameter(paramName, paramVal);
			
		}
		
		return params;
	}
	
	
}
