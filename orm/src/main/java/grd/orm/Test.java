package grd.orm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Test {
	static Logger log=Logger.getLogger(Test.class);
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Test> getTest(){
		SqlSession session=null;
    	try {
			InputStream is=Resources.getResourceAsStream("grd/orm/conf/conf.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(is);
			session=ssf.openSession();
			List<Test> t=new ArrayList<Test>();
			t=session.selectList("selectTest");
			return t;
		} catch (IOException e) {
			log.debug(e.getMessage());
		}finally{
			session.close();	
		}
    	return null;
	}
	
}
