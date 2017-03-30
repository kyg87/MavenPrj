package com.newlecture.web.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.entity.Member;
import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.view.NoticeView;

public class MySQLNoticeDao implements NoticeDao{

	@Override
	public List<NoticeView> getList() {
		return getList(1, "TITLE", "");
	}

	@Override
	public List<NoticeView> getList(int page) {
		return getList(page, "TITLE", "");
	}

	@Override
	public List<NoticeView> getList(int page, String field, String query) {
		
		/*SELECT * FROM NOTICE_VIEW Where TITLE like '%%' limit 0,10;*/
		String sql = "SELECT * FROM NOTICE_VIEW Where BINARY " + field + " like ? limit ?,10";
		List<NoticeView> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // ����̺� �ε�
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%"+query+"%");
			st.setInt(2, 10*(page-1));
			
			ResultSet rs = st.executeQuery();
			
			NoticeView noticeView = null;

			while (rs.next()) {
				noticeView = new NoticeView();
				noticeView.setCode(rs.getString("CODE"));
				noticeView.setTitle(rs.getString("TITLE"));
				noticeView.setWriter(rs.getString("WRITER"));
				noticeView.setContent(rs.getString("CONTENT"));
				noticeView.setRegDate(rs.getDate("REGDATE"));
				noticeView.setHit(rs.getInt("HIT"));
				
				noticeView.setWriterName(rs.getString("WRITER_NAME"));
				noticeView.setCommentCount(rs.getInt("COMMENT_COUNT"));
				
		
				list.add(noticeView);
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
	public int getSize() {

		
		return getSize("TITEL","");
	}

	@Override
	public int getSize(String field, String query) {
		// TODO Auto-generated method stub
		/*SELECT * FROM NOTICE_VIEW Where TITLE like '%%' limit 0,10;*/
		String sql = "SELECT COUNT(CODE)SIZE FROM NOTICE Where BINARY " + field + " like ?" ;
		
		int size = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // ����̺� �ε�
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%"+query+"%");
			
			
			ResultSet rs = st.executeQuery();
			if(rs.next())
			size = rs.getInt("SIZE");
			

			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return size;
	}

	@Override
	public int add(Notice notice) {
		String codeSql = "SELECT MAX(cast(CODE as unsigned))+1 CODE FROM NOTICE";
		
		String sql = "INSERT INTO NOTICE(CODE,TITLE,WRITER,CONTENT) VALUES(?,?,?,?)" ;
		
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
			st.setString(2,notice.getTitle());
			st.setString(3,notice.getWriter());
			st.setString(4,notice.getContent());
			
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

	@Override
	public int add(String title, String content, String writer) {
		// TODO Auto-generated method stub
		Notice notice = new Notice();
		
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		return add(notice);
	}

	@Override
	public NoticeView get(String code) {
		String sql = "SELECT * FROM NOTICE_VIEW Where CODE = ?";

		NoticeView noticeView = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // ����̺� �ε�
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,code);
		
			
			ResultSet rs = st.executeQuery();
			
		

			if (rs.next()) {
				
				noticeView = new NoticeView();
				noticeView.setCode(rs.getString("CODE"));
				noticeView.setTitle(rs.getString("TITLE"));
				noticeView.setWriter(rs.getString("WRITER"));
				noticeView.setContent(rs.getString("CONTENT"));
				noticeView.setRegDate(rs.getDate("REGDATE"));
				noticeView.setHit(rs.getInt("HIT"));
				
				noticeView.setWriterName(rs.getString("WRITER_NAME"));
				noticeView.setCommentCount(rs.getInt("COMMENT_COUNT"));

			}

			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noticeView;
	}

	@Override
	public int update(Notice notice) {
		
		
		String sql = "UPDATE NOTICE SET TITLE =?,CONTENT =? WHERE CODE =?";
		
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // ����̺� �ε�
			
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1,notice.getTitle());
			st.setString(2,notice.getContent());
			st.setString(3, notice.getCode());
			
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

	@Override
	public int delete(String code) {
		
		String sql = "DELETE FROM NOTICE WHERE CODE = ?";

		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // ����̺� �ε�
	
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,code);
	
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

	@Override
	public int update(String title, String content, String code) {
		
		Notice notice = new Notice();
		notice.setCode(code);
		notice.setTitle(title);
		notice.setContent(content);
		
		return update(notice);
	}

	@Override
	public NoticeView prev(String code) {
		String sql = "SELECT * FROM NOTICE_VIEW WHERE CAST(CODE AS unsigned) > CAST(? AS unsigned) ORDER BY REGDATE ASC limit 0,1";

		NoticeView noticeView = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // ����̺� �ε�
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,code);
		
			
			ResultSet rs = st.executeQuery();
			
		

			if (rs.next()) {
				
				noticeView = new NoticeView();
				noticeView.setCode(rs.getString("CODE"));
				noticeView.setTitle(rs.getString("TITLE"));
				noticeView.setWriter(rs.getString("WRITER"));
				noticeView.setContent(rs.getString("CONTENT"));
				noticeView.setRegDate(rs.getDate("REGDATE"));
				noticeView.setHit(rs.getInt("HIT"));
				
				noticeView.setWriterName(rs.getString("WRITER_NAME"));
				noticeView.setCommentCount(rs.getInt("COMMENT_COUNT"));

			}

			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noticeView;
	}

	@Override
	public NoticeView next(String code) {
		String sql = "SELECT * FROM NOTICE_VIEW WHERE CAST(CODE AS unsigned) < CAST( ? AS unsigned) ORDER BY REGDATE desc limit 0,1";

		NoticeView noticeView = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // ����̺� �ε�
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,code);
		
			
			ResultSet rs = st.executeQuery();
			
		

			if (rs.next()) {
				
				noticeView = new NoticeView();
				noticeView.setCode(rs.getString("CODE"));
				noticeView.setTitle(rs.getString("TITLE"));
				noticeView.setWriter(rs.getString("WRITER"));
				noticeView.setContent(rs.getString("CONTENT"));
				noticeView.setRegDate(rs.getDate("REGDATE"));
				noticeView.setHit(rs.getInt("HIT"));
				
				noticeView.setWriterName(rs.getString("WRITER_NAME"));
				noticeView.setCommentCount(rs.getInt("COMMENT_COUNT"));

			}

			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noticeView;
	}

	@Override
	public String lastCode() {
		
		String codeSql = "SELECT MAX(cast(CODE as unsigned)) CODE FROM NOTICE_VIEW";
		
		String lastCode = "1";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8"; // DB����
			Connection con = DriverManager.getConnection(url, "newlec", "sclass"); // 
			Statement st = con.createStatement();
			
			
			
			
			ResultSet rs = st.executeQuery(codeSql);
			if(rs.next())
				lastCode = rs.getString("CODE");
			

			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lastCode;
	}

}
