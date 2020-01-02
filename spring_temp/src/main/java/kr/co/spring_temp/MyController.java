package kr.co.spring_temp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.spring_temp.command.ContentCommand;
import kr.co.spring_temp.command.DeleteCommand;
import kr.co.spring_temp.command.ListCommand;
import kr.co.spring_temp.command.UpdateCommand;
import kr.co.spring_temp.command.UpdateOkCommand;
import kr.co.spring_temp.command.WriteCommand;
import kr.co.spring_temp.dto.Dto;
import kr.co.spring_temp.util.Util;

@Controller
public class MyController {
	
	private JdbcTemplate template;
	
	@Autowired
	public void setTemp(JdbcTemplate template) {
		this.template = template;
		// this.template = 멤버번수, JdbcTemplate template = 실제 값을 가지고 있는 변수
		Util.template = template;
	}
	
	@RequestMapping("/write")
	public String write() {
		return "/write";
	}
	
	@RequestMapping("/write_ok")
	public String write_ok(Dto dto) {
		WriteCommand wc = new WriteCommand();
		wc.execute(dto);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		ListCommand lc = new ListCommand();
		lc.execute(model);
		
		return "/list";
	}
	
	@RequestMapping("/content")
	public String content(Model model, HttpServletRequest request) {
		
		ContentCommand cc = new ContentCommand();
		
		cc.execute(model, request.getParameter("id"));
		
		return "/content";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		
		DeleteCommand dc = new DeleteCommand();
		dc.execute(request.getParameter("id"));
		
		return "redirect:/list";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		UpdateCommand uc = new UpdateCommand();
		uc.execute(model, request.getParameter("id"));
		return "/update";
		
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(Dto dto) {
		
		UpdateOkCommand uoc = new UpdateOkCommand();
		uoc.execute(dto);
		
		return "redirect:/content?id="+dto.getId();
	}
}
