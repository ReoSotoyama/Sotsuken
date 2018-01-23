package Servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL1 {
	public static void main(String[] args) {
		// 変数の初期化
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.jdbc.Driver");
			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sample2?useSSL=false",		//ポート番号3306かも
					"root",
					"hirobihiro5");
			// ④SQL文を作成する
			String sql = "SELECT 学籍番号, ユーザー名 FROM user;";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();

			System.out.println("学籍番号\t ユーザー名\t\t\t");

			// ⑦実行結果を含んだインスタンスからデータを取り出す
			while (rs.next() == true) {
				String name = rs.getString("ユーザー名");
				int id = rs.getInt("学籍番号");
				System.out.println(id + "\t\t" + name);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}

}