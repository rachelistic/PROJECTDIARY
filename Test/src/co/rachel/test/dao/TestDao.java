package co.rachel.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.rachel.test.vo.TestVo;

public class TestDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "rach";
	String password = "1234";

	private Connection conn;

	private PreparedStatement psmt;
	private ResultSet rs;

	// 시퀼 만들어줌.

	public TestDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			System.out.println("DB연결 실패");
		}

	}

	// 시퀼 입력
	private final String INSERT = "INSERT INTO Encryption(id,password,encryptionpassword)" + "VALUES(?,?,?)";

	private void Close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insert(TestVo vo) {
		int n = 0;
		
		try {
			
			psmt = conn.prepareStatement(INSERT);
			psmt.setInt(1, (int) vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getEncryptionpassword());
			n = psmt.executeUpdate();
			System.out.println("DAO통해 등록완료 되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DAO통해 등록 실패");
		} finally {
			Close();
		}

		return n;
	}
}