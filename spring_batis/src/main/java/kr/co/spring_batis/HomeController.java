package kr.co.spring_batis;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.spring_batis.dao.Dao;
import kr.co.spring_batis.dto.Dto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/write")
	public String write() {
		return "/write";
	}
	
	@RequestMapping("/write_ok") /* param 이용하는 방식 */
	public String write_ok(HttpServletRequest request) {
		
		Dao dao = sqlSession.getMapper(Dao.class);
		dao.write(request.getParameter("name"), request.getParameter("age"), request.getParameter("phone"));
		return "redirect:/list";
		
	}
	
	@RequestMapping("/write_ok2") /* dto 이용하는 방식 */
	public String write_ok2(Dto dto) {
		
		Dao dao = sqlSession.getMapper(Dao.class);
		dao.write2(dto);
		return "redirect:/list";
		
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		Dao dao = sqlSession.getMapper(Dao.class);
		ArrayList<Dto> list = dao.list();
		model.addAttribute("list", list);
		dao.list();
		
		return "/list";
	}
	
	@RequestMapping("/content")
	public String content(Model model, HttpServletRequest request)	{
		Dao dao = sqlSession.getMapper(Dao.class);
		Dto dto = dao.content(request.getParameter("id"));
		int cnt = dao.list_cnt(); /* cnt = 리스트의 총 갯수 */
		model.addAttribute("dto", dto);
		model.addAttribute("cnt", cnt);
		
		
		return "/content";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Dao dao = sqlSession.getMapper(Dao.class);
		dao.delete(request.getParameter("id"));
		return "redirect:/list";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		Dao dao = sqlSession.getMapper(Dao.class);
		Dto dto = dao.update(request.getParameter("id"));
		model.addAttribute("dto", dto);
		return "/update";
	}
	
	@RequestMapping("/update_ok")
	public String update_ok(HttpServletRequest request, Model model, Dto dto) {
		Dao dao = sqlSession.getMapper(Dao.class);
		dao.update_ok(dto);
		model.addAttribute("dto", dto);
		
		return "redirect:/content?id="+dto.getId();
	}
	
	
	
	
}
