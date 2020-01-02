package kr.co.spring_temp.command;

import kr.co.spring_temp.dao.Dao;

public class DeleteCommand {
	
	public void execute(String id) {
		
		Dao dao = new Dao();
		dao.delete(id);
		
	}

}
