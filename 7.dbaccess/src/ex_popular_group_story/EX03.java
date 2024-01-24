package ex_popular_group_story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

public class EX03 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgers";
        String Password = "password";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;

        try{
            con = DriverManager.getConnection(url, user, Password);
            sql = """
                    select name
                    ,barth_day
                    ,gender
                    ,coler_id
                    from members
                    """;
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String birthDay= rs.getString("barth_day");
                String gender = rs.getString("gender");
                int coler_id = rs.getInt("color_id");
                System.out.println(id+name+birthDay+gender+coler_id);
                
            }
        }catch(Exception e ){
            e.printStackTrace();
        }finally{
            try{
                if () {
                    
                }
            }
        }
    }
}
