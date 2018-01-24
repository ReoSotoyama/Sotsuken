package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import bean.SectionBean;
import util.DbManager;

/**
 * 部署テーブルへ操作を行うためのクラス.
 * 取得できなかった場合、空のListを返却する。（Exceptionをthrowしない）
 *
 * @author Yoshiki Nakamura
 */

public class SectionDao {
  // finallyでcloseするためメンバ変数化
  PreparedStatement ps;


  /**
   * 部署テーブルの内容をすべて取得し、Listに詰めて返却する.
   *
   * @return
   */
  public List<SectionBean> findAll() {
    // 部署テーブルの内容を取得
    List<SectionBean> secList = new ArrayList<SectionBean>();
    // DBコネクション取得
    try (Connection conn = DbManager.getConnection()) {
      // closeされていないConnectionでprepareStatement実行
      ps = conn.prepareStatement("SELECT * FROM section");
      // SQL実行
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        SectionBean bean = new SectionBean(rs.getInt("header"),rs.getInt("id"),
        rs.getString("name"),rs.getString("department"), rs.getString("course"), rs.getString("company"),
        rs.getInt("phone"),rs.getString("location"),rs.getString("area"), rs.getString("industry"),rs.getString("occupations"),
        rs.getInt("year"),rs.getInt("time"),rs.getString("sof"),rs.getString("comment1"),rs.getString("comment2"),rs.getString("comment3"));
        secList.add(bean);
      }
    } catch (SQLException e) {
      System.out.println("エラー内容、または以下の点を確認してください。\n" +
          "SQLの構文が間違ってないか\n" +
          "prepareStatementがResultSetを返却しているか");
      e.printStackTrace();
    } finally {
      psAndConnectionClose();
    }
    return secList;
  }

  /**
   * 引数で取得したデータをDBにinsert（追加）する.
   * @param bean
   */

  public void insert( SectionBean bean ) {
    // DBコネクション取得
    try (Connection conn = DbManager.getConnection()) {
      ps = conn.prepareStatement("insert into report(学籍番号,氏名,学科,コース,会社名,電話番号,所在地,エリア,業種,職種,提出年,提出月日,合否,コメント1,コメント2,コメント3) values(? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? , ?)");
      ps.setInt(1, bean.getId());
      ps.setString(2, bean.getName());
      ps.setString(3, bean.getDepartment());
      ps.setString(4, bean.getCourse());
      ps.setString(5, bean.getCompany());
      ps.setInt(6, bean.getPhone());
      ps.setString(7, bean.getLocation());

      ps.setString(8, bean.getArea());

      ps.setString(9, bean.getIndustry());
      ps.setString(10, bean.getOccupations());
      ps.setInt(11, bean.getYear());
      ps.setInt(12, bean.getTime());
      ps.setString(13, bean.getSof());
      ps.setString(14, bean.getComment1());
      ps.setString(15, bean.getComment2());
      ps.setString(16, bean.getComment3());

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

  public void update( SectionBean bean ) {
    // DBコネクション取得
    try (Connection conn = DbManager.getConnection()) {
      ps = conn.prepareStatement("UPDATE section SET  = ? WHERE id= ?");
      ps.setInt(1, bean.getHeader());
      ps.setInt(2, bean.getId());
      ps.setString(3, bean.getName());
      ps.setString(4, bean.getDepartment());
      ps.setString(5, bean.getCourse());
      ps.setString(6, bean.getCompany());
      ps.setInt(7, bean.getPhone());
      ps.setString(8, bean.getLocation());
      ps.setString(9, bean.getArea());
      ps.setString(10, bean.getIndustry());
      ps.setString(11, bean.getOccupations());
      ps.setInt(12, bean.getYear());
      ps.setInt(13, bean.getTime());
      ps.setString(14, bean.getSof());
      ps.setString(15, bean.getComment1());
      ps.setString(16, bean.getComment2());
      ps.setString(17, bean.getComment3());
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
  public void delete( int header ) {
    // DBコネクション取得
    try (Connection conn = DbManager.getConnection()) {
      ps = conn.prepareStatement("DELETE FROM section WHERE haeder= ?");
      ps.setInt( 1, header );
      // SQL実行（INSERT,UPDATE,DELETEはexecuteUpdate）
      if ( ps.executeUpdate() == 0) {
        System.out.println("対象データが登録されていません。");
        return;
      }
      ps.close();
      System.out.println("対象データが見つかりました。\n" + "ID番号 [ " + header + " ] の削除処理を実行します。");
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
    DbManager.connectionClose();
    try {
      ps.close();
    } catch (SQLException e) {
      System.out.println("PreparedStatementオブジェクトcloseに失敗。");
      e.printStackTrace();
    }
  }



  public List<SectionBean> find(SectionBean bean) {
    SectionBean sectionBean = null;
    List<SectionBean> secList = new ArrayList<SectionBean>();
    try (Connection conn = DbManager.getConnection()) {
    	String sql = "SELECT * FROM report WHERE ";
    	String str = "指定なし";

    	if(!str.equals(bean.getCompany())){
    		sql = sql.concat("会社名 LIKE ?,");

    	}
    	if(!str.equals(bean.getDepartment())){
    		sql = sql.concat("学科 = ?,");
    	}
    	if(!str.equals(bean.getCourse())){
    		sql = sql.concat("コース = ?,");
    	}
    	if(!str.equals(bean.getIndustry())){
    		sql = sql.concat("業種 = ?,");
    	}
    	if(!str.equals(bean.getOccupations())){
    		sql = sql.concat("職種 = ?,");
    	}
    	if(!str.equals(bean.getArea())){
    		sql = sql.concat("エリア = ?,");
    	}
    	if(bean.getYear() != 0){
    		sql = sql.concat("提出年 = ?,");
    	}
    	if(!str.equals(bean.getSof())){
    		sql = sql.concat("合否 = ?");
    	}

    	char c = sql.charAt(sql.length()-1);

    	if(c == ','){
    		sql = sql.substring(0,sql.length()-1);
    	}


    sql = sql.concat(";");
    System.out.println(sql);
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, "%" + bean.getCompany() + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  System.out.println(rs.getInt("ヘッダー番号"));
        sectionBean = new SectionBean(rs.getInt("ヘッダー番号"),rs.getInt("学籍番号"),
                rs.getString("氏名"),rs.getString("学科"), rs.getString("コース"), rs.getString("会社名"),
                rs.getInt("電話番号"),rs.getString("所在地"),rs.getString("エリア"),rs.getString("業種"),rs.getString("職種"),
                rs.getInt("提出年"),rs.getInt("提出月日"),rs.getString("合否"),rs.getString("コメント1"),rs.getString("コメント2"),rs.getString("コメント3"));
        secList.add(sectionBean);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return secList;
  }



  public SectionBean findHeader(int header){
	  SectionBean sectionBean = null;

	  try (Connection conn = DbManager.getConnection()) {
	      String sql = "SELECT * FROM report WHERE ヘッダー番号 = ?;";

	      PreparedStatement ps = conn.prepareStatement(sql);
	      ps.setInt(1, header);

	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	    	  System.out.println(rs.getInt("ヘッダー番号"));
	        sectionBean = new SectionBean(rs.getInt("ヘッダー番号"),rs.getInt("学籍番号"),
	                rs.getString("氏名"),rs.getString("学科"), rs.getString("コース"), rs.getString("会社名"),
	                rs.getInt("電話番号"),rs.getString("所在地"),rs.getString("エリア"),rs.getString("業種"),rs.getString("職種"),
	                rs.getInt("提出年"),rs.getInt("提出月日"),rs.getString("合否"),rs.getString("コメント1"),rs.getString("コメント2"),rs.getString("コメント3"));
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }

	return sectionBean;
  }
}