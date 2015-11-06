package grd.pages;

import grd.orm.Test;

import org.apache.log4j.PropertyConfigurator;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;

public class Start {
	static{PropertyConfigurator.configure("log4j.porperties");}
	private String name="default";
	public String getName(){
		return name;
	}
	
	@InjectPage 
	private Start start;
	public Start(){
	}
	
	void onActivate(String n){
		this.name=n;
	}
	String onPassivate(){
		return name;
	}
	public void setName(String nn){  
		this.name=nn;
	}
	@OnEvent(value="action",component="find")
	Object findTest(int i){
		Test test=new Test().getTest().get(--i);
		name=(test.getId()+" is "+test.getName());
		start.setName(name);
		return start;
	}
}
