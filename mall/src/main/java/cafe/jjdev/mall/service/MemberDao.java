package cafe.jjdev.mall.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {
	// ����̺� �ε� ����޼���
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://127.0.0.1:3306/jjdev?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPassword = "java0000";
		Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		return connection;
	}
	public void insertMember(Member member) throws SQLException{
		// ���ϵ�����Ÿ�� : int
		System.out.println("insertMember�޼��� MemberDao.java");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement("INSERT INTO member(id,pw,level) VALUES(?,?,?)");
		preparedStatement.setString(1, member.getId());
		preparedStatement.setString(2, member.getPw());
		preparedStatement.setInt(3, 0);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}
	
}