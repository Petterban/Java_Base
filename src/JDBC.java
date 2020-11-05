import java.sql.*;

public class JDBC {
    private static final String URL ="jdbc:mysql://localhost:3306/test_database?serverTimezone=())&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    //创建与数据库的连接
    private static Connection connect_MySQL(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载完成");

            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("成功连接数据库");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }

    public static void update(String sql){
        try (Connection connection = connect_MySQL();
             Statement stmt = connection.createStatement();
             PreparedStatement pstmt = connection.prepareStatement(sql);){
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void  main(String[] args){
        connect_MySQL();
    }
}
