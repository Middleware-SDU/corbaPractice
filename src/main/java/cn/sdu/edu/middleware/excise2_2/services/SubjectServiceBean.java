package cn.sdu.edu.middleware.excise2_2.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.sdu.edu.middleware.excise2_2.daos.beans.Subject;
import cn.sdu.edu.middleware.excise2_2.daos.beans.SubjectServicePOA;
import cn.sdu.edu.middleware.excise2_2.daos.beans.User;
import cn.sdu.edu.middleware.excise2_2.utils.DB;

/**
 * 
 * @author Yonggang Yuan
 *
 */

public class SubjectServiceBean extends SubjectServicePOA {

    public void save(Subject subject) {
        Connection conn = DB.getConn();
        String sql = "insert into subject values (?, ?)";
        PreparedStatement pstmt = DB.prepare(conn, sql);
        try {
            pstmt.setInt(1, subject.subjectNo);
            pstmt.setString(2, subject.subjectName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(pstmt);
            DB.close(conn);
        }
    }

    public void delete(int subjectNo) {
        // TODO Auto-generated method stub
    }

    public void update(Subject subject) {
        // TODO Auto-generated method stub
    }

    public User find(int subjectNo) {
        // TODO Auto-generated method stub
        return null;
    }

    public Subject[] list() {
        // TODO Auto-generated method stub
        return null;
    }

}
