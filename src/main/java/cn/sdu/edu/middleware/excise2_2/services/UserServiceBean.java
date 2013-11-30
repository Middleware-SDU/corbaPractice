package cn.sdu.edu.middleware.excise2_2.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.sdu.edu.middleware.excise2_2.daos.beans.User;
import cn.sdu.edu.middleware.excise2_2.daos.beans.UserServicePOA;
import cn.sdu.edu.middleware.excise2_2.utils.DB;

/**
 * 
 * @author Yonggang Yuan
 *
 */

public class UserServiceBean extends UserServicePOA {

    public void save(User user) {
        Connection conn = DB.getConn();
        String sql = "insert into user values (?, ?)";
        PreparedStatement pstmt = DB.prepare(conn, sql);
        try {
            pstmt.setInt(1, user.examNo);
            pstmt.setString(2, user.userName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(pstmt);
            DB.close(conn);
        }
    }

    public void delete(int examNo) {
        // TODO Auto-generated method stub
    }

    public void update(User user) {
        // TODO Auto-generated method stub
    }

    public User find(int examNo) {
        // TODO Auto-generated method stub
        return null;
    }

    public User[] list() {
        // TODO Auto-generated method stub
        return null;
    }

}
