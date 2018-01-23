package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * データベースへのコネクションを取得し、返却する.
 *
 *
 */
public class DbManager {
  static Connection conn;

  // autoReconnect(MySQLコネクションが無い場合、自動接続)使用、SSLを未使用で特定データベースに接続する
  private static ResourceBundle bundle = ResourceBundle.getBundle("db");
  private static String url = bundle.getString("db.url");
  private static String user = bundle.getString("db.user");
  private static String password = bundle.getString("db.password");


  /**
   * データベースへのコネクションの取得を行い.
   * 接続が成功した場合には、接続に必要な商法を返却する。
   *
   * @return conn コネクションの内容
   * @throws SQLException JDBCを使用した上でSQLを使用した際の例外発生時
   */

  public static Connection getConnection() {
    conn = null;

    try {
      Class.forName("com.mysql.jdbc.Driver");
      // コネクション確立を行う時に使う情報の格納
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/report?useSSL=false",
				"root",
				"root");
      System.out.println("接続成功");
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("データベースにアクセスできませんでした。\n" +
          "接続先URL、ユーザ名、パスワードが正しいか確認してください。");
      e.printStackTrace();
    }
    return conn;
  }

  /**
   * コネクションを切断する.
   */
  public static void connectionClose() {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        System.out.println("コネクション切断に失敗しました。");
        e.printStackTrace();
      }
    }
  }
}
