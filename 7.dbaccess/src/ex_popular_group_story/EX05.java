package ex_popular_group_story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EX05 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String Password = "password";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = null;

        try{
            con = DriverManager.getConnection(url, user, Password);
            sql = """
                DELETE FROM menbers WHERE id = 1 or id = 2
                    """;
            pstmt = con.prepareStatement(sql);
            int numOfUpdate = pstmt.executeUpdate();
            System.out.println(numOfUpdate);

            
            
        }catch(SQLException e ){
            System.err.println(sql);
            e.printStackTrace();
        }finally{
            try{
                if (con != null) {
                    con.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                
                }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    }

