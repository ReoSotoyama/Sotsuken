import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * 
 *
 *
 */

public class DatabaseConnection {

  /**
   * 実行メインクラス.
   * @param args
   */
  public static void main(String[] args) {
    Connection conn = null;

    // 引数と同名のファイルをクラスパス上より探索してロードす
    ResourceBundle bundle = ResourceBundle.getBundle("hs2018system");

    // ロードしたファイルの中より「db.url」から始まる一行を抜き出して代入
    String url = bundle.getString("db.url");
    String user = bundle.getString("db.user");
    String password = bundle.getString("db.password");

    try {
      // 引数をもとにコネクションの確立を試行
      conn = DriverManager.getConnection(url, user, password);

      // PreparedStatementを使用してSQLを実行する
      // prepareStatementは、引数をコンパイル（処理）する
      PreparedStatement statement = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID = ?");

      // setInt(num1..)は、PreparedStatement変数のパラメータを引数で設定
      // prepareStatement()の？をset***()で変更
      // この場合は「ID = ?」を「ID = 1001」に変更
      statement.setInt(1, 1001);

      // 事前に処理済みの検索SQLを実行し、結果をResultSetクラスで返却
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        String name = rs.getString("NAME");
        System.out.println("名前：" + name);
      }
    } catch (MySQLIntegrityConstraintViolationException e) {
      System.out.println("データベースおよびテーブルで定めた整合性制約違反。");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("JDBC使用における、SQL処理で例外が発生。");
      e.printStackTrace();
    } finally {
      try {
        if (conn != null) {
          // 切断
          conn.close();
        }
      } catch (SQLException e) {
        System.out.println("JDBC使用における、コネクション切断で例外が発生。");
        e.printStackTrace();
      }
    }
  }
}