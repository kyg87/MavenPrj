package com.newlecture.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
	private ServletContext context;
	
	@Autowired
	private NoticeDao noticeDao;
	
	
	@Autowired
	private NoticeFileDao noticeFileDao;
	
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
	public String noticeReg(Notice notice,@RequestParam(value = "files") List<MultipartFile> files) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		
		
		String path = context.getRealPath("/resources/upload");
		
		System.out.println("path: " + path);
		
		File d = new File(path);
		//파일 업로드할 경로가 만들어지지 않는다면 만들어야함
		if(!d.exists())//경로가 존재하지 않는다면
			d.mkdir();
		
		byte[] buf = new byte[1024];
		
		for(MultipartFile file : files){
			if(!file.isEmpty()){
			String fileName = file.getOriginalFilename();
			InputStream fis = file.getInputStream();
			OutputStream fos = new FileOutputStream(path + File.separator + fileName);
			//sb.append(file.getOriginalFilename());
			
			int len = 0;
			
			while((len = fis.read(buf)) > 0){
				fos.write(buf, 0, len);
			}
			
				fis.close();
				fos.close();
			}
		}
		
		/*return path;
		
		return sb.toString();*/ 
	
		notice.setWriter("KKKKK");
		noticeDao.add(notice);
		
		for(MultipartFile file : files){
			if(!file.isEmpty()){
			String fileName = file.getOriginalFilename();
			
			NoticeFile f = new NoticeFile();
			
			f.setNoticeCode(noticeDao.lastCode());
			f.setSrc(fileName);
			
			noticeFileDao.add(f);
			}
		}
		
		return "redirect:notice";
		
	}
	@RequestMapping(value= "notice-del",method = RequestMethod.GET)
	public String noticeDel(
			@RequestParam(value = "c" )String code)
	{
		
		//NoticeDao noticeDao = new MySQLNoticeDao();
		int result = noticeDao.delete(code);
		
		System.out.println(result);
		
		return "redirect:notice";
	}
}
