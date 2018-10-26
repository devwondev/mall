package cafe.jjdev.mall.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cafe.jjdev.mall.service.Member;
public class MemberDao {
	// 드라이버 로딩 공통 메서드화
	public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/mall?useUnicode=true&characterEncoding=utf-8";
        String dbUser = "root";
        String dbPassword = "java0000";
        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        System.out.println(connection+"<--connection");
        return connection;
    }
	// 회원가입처리 메서드
	public void insertMember(Member member) throws Exception{
		System.out.println("insertMember MemberDao.java");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = getConnection();
		preparedStatement = connection.prepareStatement("INSERT INTO member(id,pw) VALUES(?,?)");
		System.out.println(preparedStatement+"<--preparedStatement");
		preparedStatement.setString(1, member.getId());
		preparedStatement.setString(2, member.getPw());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}
	// 로그인처리 메서드
	public Member loginMember(Member member) throws Exception {
		System.out.println("loginMember MemberDao.java");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getConnection();
		preparedStatement = connection.prepareStatement("SELECT id,pw,level FROM member WHERE id=? AND pw=?");
		preparedStatement.setString(1, member.getId());
		preparedStatement.setString(2, member.getPw());
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			member.setLogin(true);
		}else {
			member.setLogin(false);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return member;
	}
	// 내 정보 보기
	public Member selectMember(String id) throws Exception {
		System.out.println("selectMember MemberDao.java");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = getConnection();
		preparedStatement = connection.prepareStatement("SELECT id,pw,level FROM member WHERE id=?");
		preparedStatement.setString(1, id);
		resultSet = preparedStatement.executeQuery();
		Member member = new Member();
		if(resultSet.next()) {
			member.setId(resultSet.getString("id"));
			member.setPw(resultSet.getString("pw"));
			member.setLevel(resultSet.getInt("level"));
		}
		resultSet.close();  
		preparedStatement.close();
		connection.close();
		return member;
	}
}