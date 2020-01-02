package kr.co.spring_temp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.ui.Model;

import kr.co.spring_temp.dto.Dto;
import kr.co.spring_temp.util.Util;

public class Dao {
	
	JdbcTemplate template;
	
	public Dao() {
		this.template = Util.template;
	}
	
	public void write(final String name, final String age, final String phone) {
		String sql = "insert into member(name,age,phone,writeday) values('"+name+"','"+age+"','"+phone+"',now())";
		this.template.update(sql);
		/*
		 * this.template.update(new PreparedStatementCreator() {
		 * 
		 * @Override public PreparedStatement createPreparedStatement(Connection conn)
		 * throws SQLException { String sql =
		 * "insert into member(name,age,phone,writeday) values(?,?,?,,now())";
		 * PreparedStatement pstmt=conn.prepareStatement(sql); pstmt.setString(1, name);
		 * pstmt.setString(2, age); pstmt.setString(3, phone);
		 * 
		 * return pstmt; } });
		 */
	}
	
	public void list(Model model) {
		
		String sql = "select * from member order by id desc";
		ArrayList<Dto> list = (ArrayList<Dto>) template.query(sql, new BeanPropertyRowMapper<Dto>(Dto.class));
		// 여러개의 쿼리를 가져올 때 => BeanPropertyRowMapper로 쿼리 가져와서 리스트에 저장
		model.addAttribute("list", list);
	}
	
	public void content(Model model, String id) {
		String sql = "select * from member where id="+id;
		Dto dto = template.queryForObject(sql, new BeanPropertyRowMapper<Dto>(Dto.class));
		// 1개의 쿼리를 가져올 때 =>BeanPropertyRowMapper로 쿼리 가져와서 Dto에 저장
		model.addAttribute("dto", dto);
	}
	
	public void delete(String id) {
		
		String sql = "delete from member where id="+id;
		template.update(sql);
		
	}
	
	public void update(Model model,String id)  {
		String sql = "select * from member order by id desc";
		Dto dto = template.queryForObject(sql, new BeanPropertyRowMapper<Dto>(Dto.class));
		model.addAttribute("dto", dto);
	}
	
	public void update_ok(final Dto dto) {
		
		this.template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "update member set name=?, age=?, phone=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getAge());
				pstmt.setString(3, dto.getPhone());
				pstmt.setString(4, dto.getId());
				return pstmt;
			}
			
			
		});
	}

}
