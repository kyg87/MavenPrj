package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.NoticeFile;

public interface NoticeFileDao {
	List<NoticeFile> getList(String noticeCode);
	int add(NoticeFile file);
	int add(String src, String noticeCode);
}
