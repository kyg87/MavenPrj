package com.newlecture.web.dao.mysql;

import java.util.List;

import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.view.NoticeView;

public class TestProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoticeDao dao = new MySQLNoticeDao();
		
		List<NoticeView> list = dao.getList();
		
		for (NoticeView noticeView : list) {
			System.out.println(noticeView.getTitle());
		}

	}

}
