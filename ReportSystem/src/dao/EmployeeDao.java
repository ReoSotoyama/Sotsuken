package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import bean.EmployeeBean;
import util.DbManager;
public class EmployeeDao {
  // finallyでcloseするためメンバ変数化
  PreparedStatement ps;


  public List<EmployeeBean> findAll() {
    // 部署テーブルの内容を取得
    List<EmployeeBean> empList = new ArrayList<EmployeeBean>();
    // DBコネクション取得
    // try(){}でcloseが必要なものを自動的にclose
    try (Connection conn = DbManager.getConnection()) {
      // closeされていないConnectionでprepareStatement実行
    	System.out.println("通ってる");
      ps = conn.prepareStatement("SELECT * FROM user");
      // SQL実行
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        EmployeeBean bean = new EmployeeBean();
        empList.add(bean);
      }
    } catch (SQLException e) {
      System.out.println("エラー内容、または以下の点を確認してください。\n" +
          "SQLの構文が間違ってないか\n" +
          "prepareStatementがResultSetを返却しているか");
      e.printStackTrace();
    } finally {
      psAndConnectionClose();
    }
    return empList;
  }

  /**
   * 引数で取得したデータをDBにinsert（追加）する.
   * @param bean
   */

  public void insert( EmployeeBean bean ) {
    // DBコネクション取得
    try (Connection conn = DbManager.getConnection()) {
      ps = conn.prepareStatement("INSERT INTO user (学籍番号, ユーザー名, 学科, コース, 学年, パスワード, メールアドレス) values(?, ?, ?, ?, ?, ?, ?)");
      ps.setInt(1, bean.getId());
      ps.setString(2, bean.getName());
      ps.setString(3, bean.getDepartment());
      ps.setString(4, bean.getCourse());
      ps.setString(5, bean.getX());
      ps.setString(6, bean.getPass());
      ps.setString(7, bean.getAddress());
      // SQL実行（INSERT,UPDATE,DELETEはexecuteUpdate）
      if ( ps.executeUpdate() == 0) {
        System.out.println("データ追加に失敗しました。");
        return;
      }
      System.out.println("ID番号 [ " + bean.getId() + " ] の追加処理を実行します。");
    } catch (MySQLIntegrityConstraintViolationException e) {
      System.out.println("整合性制約に違反してます。");
    } catch (SQLException e) {
      executeUpdateErrorMessage();
      e.printStackTrace();
    } finally {
      psAndConnectionClose();
    }
  }

  /**
   * 引数で取得したデータでupdate（更新）する.
   * DBに登録されていない場合は、エラーメッセージ「対象データが登録されていません。」を出力する。
   *
   * @param bean
   */

  public void update( EmployeeBean bean ) {
    // DBコネクション取得
    try (Connection conn = DbManager.getConnection()) {
      ps = conn.prepareStatement("UPDATE employee SET name = ?,section_id = ?,"
          + "birthdate = ?,address = ?, remark = ? WHERE id= ?");
      ps.setString(1, bean.getName());
      ps.setString(2, bean.getDepartment());
      ps.setString(3, bean.getCourse());
      ps.setString(4, bean.getX());
      ps.setString(5, bean.getPass());
      ps.setString(6, bean.getAddress());
      ps.setInt(7, bean.getId());
      // SQL実行（INSERT,UPDATE,DELETEはexecuteUpdate）
      if ( ps.executeUpdate() == 0) {
        System.out.println("対象データが登録されていません。");
        return;
      }
      System.out.println("対象データが見つかりました。\n" + "ID番号 [ " + bean.getId() + " ] の更新処理を実行します。");
    } catch (MySQLIntegrityConstraintViolationException e) {
      System.out.println("整合性制約に違反してます。");
    } catch (SQLException e) {
      executeUpdateErrorMessage();
      e.printStackTrace();
    } finally {
      psAndConnectionClose();
    }
  }

  /**
   * 引数で取得したidでdelete（削除）する.
   * DBに登録されていないIDの場合は、エラーメッセージ「対象データが登録されていません。」を出力する。
   *
   * @param id
   */
  public void delete( int id ) {
    // DBコネクション取得
    try (Connection conn = DbManager.getConnection()) {
      ps = conn.prepareStatement("DELETE FROM user WHERE id= ?");
      ps.setInt( 1, id );
      // SQL実行（INSERT,UPDATE,DELETEはexecuteUpdate）
      if ( ps.executeUpdate() == 0) {
        System.out.println("対象データが登録されていません。");
        return;
      }
      System.out.println("対象データが見つかりました。\n" + "ID番号 [ " + id + " ] の削除処理を実行します。");
    } catch (SQLException e) {
      executeUpdateErrorMessage();
      e.printStackTrace();
    } finally {
      psAndConnectionClose();
    }
  }

  /**
   * executeUpdateでエラーが発生したときに対処方法のメッセージを表示する.
   */
  public void executeUpdateErrorMessage() {
    System.out.println("【エラー発生】\n" + "printStackTreceの内容、または以下の点を確認してください。\n" +
        "PreparedStatementオブジェクトがクローズされていないか\n" +
        "PreparadStatementオブジェクトを生成したConnectionオブジェクトがクローズされていないか\n" +
        "検索系SQL（SELECTなど）を使用していないか\n" +
        "接続先テーブルで定義した整合性制約に違反していないか" +
        "SQL文の中に値を設定していない？パラメタが無いか\n" +
        "データベースのアクセスエラーが発生していないか");
  }

  /**
   * PreparedStatementオブジェクトをcloseする.
   */
  public void psAndConnectionClose() {
    try {
      ps.close();
    } catch (SQLException e) {
      System.out.println("PreparedStatementオブジェクトcloseに失敗。");
      e.printStackTrace();
    }
  }



  /**
   * 特定のIDを見つけて、EmployeeBeanを返す.
   *
   * @return 引数idに対応したEmployeeBean
   */
  public EmployeeBean find(int id) {
    EmployeeBean employeeBean = null;
    try (Connection conn = DbManager.getConnection()) {
      PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE 学籍番号 = ?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        employeeBean = new EmployeeBean(rs.getInt("学籍番号"), rs.getString("ユーザー名"),
            rs.getString("学科"),rs.getString("コース"),
            rs.getString("学年"),rs.getString("パスワード"),rs.getString("メールアドレス"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return employeeBean;
  }
}