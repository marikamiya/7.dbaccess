import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSample {
    
    public static void main(String[] args) {
        String url= "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "Password";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = null;

        try{
            con = DriverManager.getConnection(url, user, password);
            sql = "Insert into employees (name, age) values ('テスト太郎', 19), ('テスト花子', 20)";
            pstmt = con.prepareStatement(sql);
            int numofUpdated = pstmt.executeUpdate();
            System.out.println(numofUpdated + "件のレコードを追加しました。");
        }catch(SQLException ex){
            ex.printStackTrace();
    }finally{
        try{
            if(con != null){
                con.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
}
