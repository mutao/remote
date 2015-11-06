package grd.components;

import org.apache.tapestry5.annotations.Parameter;

public class Tem {
	@Parameter(defaultPrefix="literal",required=true)
	private String tem;
	public String getTem(){
		return tem;
	}
}
