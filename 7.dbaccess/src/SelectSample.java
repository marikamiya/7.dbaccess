import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectSample {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;

        try{
            con = DriverManager.getConnection(url, user, "Password");
            sql = "SELECT id, name, age FROM employees order by age";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");                
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("id: " + id + ", name: " + name + ", age: " + age);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                if(con != null){
                    con.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();
                    
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

}
