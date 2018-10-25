package cafe.jjdev.mall.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
	// ����̹� �ε� ���� �޼���ȭ
	public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/jjdev?useUnicode=true&characterEncoding=euckr";
        String dbUser = "root";
        String dbPassword = "java0000";
        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        System.out.println(connection+"<--connection");
        return connection;
    }
	// ȸ������ó��
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
		return member;
	}
}