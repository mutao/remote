package grd.pages;

import java.util.List;

import grd.orm.Test;

public class Login {

	public List<Test> getTests(){
		return new Test().getTest();
	}
	
}
