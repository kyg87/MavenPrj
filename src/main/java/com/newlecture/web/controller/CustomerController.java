package com.newlecture.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.dao.mysql.MySQLNoticeDao;
import com.newlecture.web.dao.mysql.MySQLNoticeFileDao;
import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.dao.NoticeFileDao;
import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.entity.NoticeFile;
import com.newlecture.web.data.view.NoticeView;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {

	@Autowired
	private NoticeDao noticeDao;

	@RequestMapping("notice")
	/*@ResponseBody*/
	public String notice(
			@RequestParam(value ="p",defaultValue ="1")String page,
			@RequestParam(value ="f",defaultValue ="TITLE")String field,
			@RequestParam(value ="q",defaultValue ="")String query, Model model){
		
		//return String.format("p:%s , f: %s,q : %s", page,field,query);
		List<NoticeView> list = noticeDao.getList();
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/customer/notice.jsp";
	}
	
	@Autowired
	private NoticeFileDao noticeFileDao;
	@RequestMapping("notice-detail")
	public String noticeDetail(
			@RequestParam(value = "c",defaultValue = "1" )String code,Model model){
		
		
/*		NoticeDao noticeDao = new MySQLNoticeDao();*/
		
		NoticeView n = noticeDao.get(code);
		
		NoticeView prev = noticeDao.prev(code);
		NoticeView next = noticeDao.next(code);
		
		//NoticeFileDao noticeFileDao = new MySQLNoticeFileDao();
		
		List<NoticeFile> list = noticeFileDao.getList(n.getCode());
		
		model.addAttribute("n", n);
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/customer/notice-detail.jsp";
	}
	@RequestMapping(value= "notice-reg",method = RequestMethod.GET)
	public String noticeReg()
	{
		return "/WEB-INF/views/customer/notice-reg.jsp";
	}
	
	@RequestMapping(value= "notice-reg",method = RequestMethod.POST,produces ="text/txt;charset=UTF-8")
	@ResponseBody
	public String noticeReg(Notice notice,@RequestParam(value = "file") MultipartFile file)
	{
		
		return file.getOriginalFilename(); 
		/*notice.setWriter("KKKKK");
		noticeDao.add(notice);
		
		return notice.getTitle();
		return "redirect:notice";*/
	}
}
