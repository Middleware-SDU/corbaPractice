package cn.sdu.edu.middleware.excise2_2.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.sdu.edu.middleware.excise2_2.daos.beans.Grade;
import cn.sdu.edu.middleware.excise2_2.daos.beans.GradeServicePOA;
import cn.sdu.edu.middleware.excise2_2.utils.DB;

/**
 * 
 * @author Yonggang Yuan
 *
 */

public class GradeServiceBean extends GradeServicePOA {

    public Grade[] list() {
        return null;
    }

    public Grade[] getGrades(int examNo) {
        List<Grade> grades = new ArrayList<Grade>();
        Connection conn = DB.getConn();
        String sql = "select * from grade where examNo = " + examNo;
        Statement stmt = DB.getStatement(conn);
        ResultSet rs = DB.getResultSet(stmt, sql);
        try {
            while (rs.next()) {
                Grade u = new Grade();
                u.subjectName = rs.getString("subjectName");
                u.score = rs.getInt("score");
                grades.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(conn);
        }
        Grade[] res = new Grade[grades.size()];
        for(int i=0; i<res.length; i++) {
            res[i] = grades.get(i);
        }
        return res;
    }

    public int getGrade(int examNo, int subjectNo) {
        Connection conn = DB.getConn();
        String sub = subjectNo==1?"Math":"English";
        String sql = "select * from grade where examNo = " + examNo + " and subjectName = '" + sub + "'";
        Statement stmt = DB.getStatement(conn);
        ResultSet rs = DB.getResultSet(stmt, sql);
        try {
            while (rs.next()) {
                return rs.getInt("score");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(rs);
            DB.close(stmt);
            DB.close(conn);
        }
        return 100;
    }

    public void setGrade(int examNo, int subjectNo, int score) {
        Connection conn = DB.getConn();
        String sql = "insert into grade values (?, ?, ?)";
        PreparedStatement pstmt = DB.prepare(conn, sql);
        try {
            pstmt.setInt(1, examNo);
            pstmt.setString(2, subjectNo==1 ?"Math" : "English");
            pstmt.setInt(3, score);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(pstmt);
            DB.close(conn);
        }
    }

}
