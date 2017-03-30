package com.newlecture.web.data.entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.newlecture.web.dao.mysql.MySQLMemberDao;
import com.newlecture.web.data.dao.MemberDao;

public class Program {
	public static void main(String[] args) {

		// MVC
		// ================== Controller ===================================================
		String uid;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("검색할 아이디 : ");
		uid = scan.nextLine();
		
		MemberDao memberDao = new MySQLMemberDao();
		List<Member> list = memberDao.getList(uid);
		
		// ================== Model===================================================
		// 출력하기 위한 데이터 = 모델
		
		
		// ================== View ===================================================
		
		for (Member m : list) {
			System.out.println("ID는 "+m.getId()+"이고 패스워드는 "+m.getPwd()+"이다");
		}
		// if(mid.contains("a")) >> a를 가진 ID만 출력
		//System.out.printf("id는 '%s'이고 패스워드는 '%s'이다\n", mid, pwd);
		
		/*Member t = new Member();
		t.setId("테스트1");
		t.setPwd("111");
		t.setName("오마이갓");
		
		memberDao.add(t);*/
		
		/*list = memberDao.getList(uid);
		
		System.out.println("-------------------------------------------");
		// ================== View ===================================================
		for (Member m : list) {
			System.out.println("ID는 "+m.getId()+"이고 패스워드는 "+m.getPwd()+"이다");
		}*/
		
	}
	
}


