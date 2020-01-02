package kr.co.spring_batis.dao;

import java.util.ArrayList;

import kr.co.spring_batis.dto.Dto;

public interface Dao {
	
	public void write(String name, String age, String phone);
	public void write2(Dto dto);
	public ArrayList<Dto> list();
	public Dto content(String id);
	public int list_cnt();
	public void delete(String id);
	public Dto update(String id);
	public void update_ok(Dto dto);

}
