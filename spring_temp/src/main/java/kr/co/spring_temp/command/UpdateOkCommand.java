package kr.co.spring_temp.command;

import kr.co.spring_temp.dao.Dao;
import kr.co.spring_temp.dto.Dto;

public class UpdateOkCommand {
	
	public void execute(Dto dto) {
		Dao dao = new Dao();
		dao.update_ok(dto);
		
	}
}
            