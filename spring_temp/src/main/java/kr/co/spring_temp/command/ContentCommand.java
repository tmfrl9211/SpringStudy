package kr.co.spring_temp.command;

import org.springframework.ui.Model;

import kr.co.spring_temp.dao.Dao;

public class ContentCommand {
	
	public void execute(Model model, String id) {
		Dao dao = new Dao();
		dao.content(model, id);
	}

}
