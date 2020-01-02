package kr.co.spring_temp.command;

import org.springframework.ui.Model;

import kr.co.spring_temp.dao.Dao;

public class ListCommand {
	
	public void execute(Model model) {
		Dao dao = new Dao();
		dao.list(model);
	}

}
