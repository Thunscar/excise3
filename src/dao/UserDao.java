package dao;

import tools.JdbcUtil;
import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {


    public User getUserByUserName(String userName){
        User user = null;

        Connection con = JdbcUtil.getConnection();
        String sql = "select * from t_user";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("userName");
                if(name.equals(userName)){
                    user = new User(
                            rs.getString("userName"),
                            rs.getString("password"),
                            rs.getString("chrName"),
                            rs.getString("email"),
                            rs.getString("area"),
                            rs.getString("city")
                    );
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JdbcUtil.closeAll(rs,ps,con);

        return user;
    }


    public boolean insertUser(User user){
        boolean isInsert = false;

        Connection con = JdbcUtil.getConnection();
        String sql = "INSERT into t_user (userName,password,chrName,email,area,city) values(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getChrName());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getArea());
            ps.setString(6,user.getCity());

            int count = 0;
            count = ps.executeUpdate();
            System.out.println("数据更新条数：" + count);

            if(count != 0){
                isInsert = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JdbcUtil.closeAll(ps,con);

        return isInsert;
    }


}
