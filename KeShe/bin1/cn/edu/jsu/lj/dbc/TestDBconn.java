package cn.edu.jsu.lj.dbc;

public class TestDBconn {//数据库连接测试
  public static void main(String[] args) {
    DatabaseConnection dbconn=new DatabaseConnection();
      if(dbconn.getConnection()!=null) {
        System.out.println("数据库连接成功");
        dbconn.close();
    }
  }
}
