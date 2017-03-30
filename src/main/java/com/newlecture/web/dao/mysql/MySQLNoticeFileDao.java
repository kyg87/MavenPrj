package com.newlecture.web.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.dao.NoticeFileDao;
import com.newlecture.web.data.entity.NoticeFile;
import com.newlecture.web.data.view.NoticeView;

public class MySQLNoticeFileDao implements NoticeFileDao{

	@Override
	public List<NoticeFile> getList(String noticeCode) {
		String sql = "SELECT * FROM NOTICE_FILE Where NOTICE_CODE = ?";
		List<NoticeFile> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // ����̺� �ε�
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, noticeCode);
			
			ResultSet rs = st.executeQuery();
			
			NoticeFile noticeFile = null;

			while (rs.next()) {
				noticeFile = new NoticeFile();
				
				noticeFile.setCode(rs.getString("CODE"));
				noticeFile.setNoticeCode(rs.getString("NOTICE_CODE"));
				noticeFile.setSrc(rs.getString("SRC"));
	
				
		
				list.add(noticeFile);
			}

			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int add(NoticeFile file) {
		add(file.getSrc(),file.getNoticeCode());
		return 0;
	}

	@Override
	public int add(String src, String noticeCode) {
		String codeSql = "SELECT MAX(cast(CODE as unsigned))+1 CODE FROM NOTICE_FILE";
		
		String sql = "INSERT INTO NOTICE_FILE(CODE,SRC,NOTICE_CODE) VALUES(?,?,?)" ;
		
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // ����̺� �ε�
			
			Statement codeSt = con.createStatement();
			ResultSet rs = codeSt.executeQuery(codeSql);
			
			rs.next();
			
			String code = rs.getString("CODE");
			rs.close();
			codeSt.close();
			
		
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,code);
			st.setString(2,src);
			st.setString(3,noticeCode);
	
			
			result = st.executeUpdate();

			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
