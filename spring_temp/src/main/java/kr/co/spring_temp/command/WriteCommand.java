package kr.co.spring_temp.command;

import kr.co.spring_temp.dao.Dao;
import kr.co.spring_temp.dto.Dto;

public class WriteCommand {
	
	public void execute(Dto dto) {
		Dao dao = new Dao();
		dao.write(dto.getName(),dto.getAge(),dto.getPhone());
	}

}

