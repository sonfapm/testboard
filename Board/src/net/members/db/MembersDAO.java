package net.members.db;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sun.org.apache.regexp.internal.RE;

public class MembersDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public MembersDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}

	public boolean isMembers(String USERID,String PA) {
		List list = new ArrayList();
		try {
			
			PreparedStatement pstmt = con.prepareStatement("select * from MEMBERS");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equals(USERID) && rs.getString(2).equals(PA)) {
					System.out.println("아이디 비밀번호 확인, DAO 빠져나감");

					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("로그인 에러 : " + e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}

		
	public boolean joinmember(MembersBean membersdata) {
		MembersBean aa = new MembersBean();
		aa = membersdata;
		System.out.println(membersdata.getUSERID());
		String joinsql = "INSERT INTO MEMBERS VALUES(?,?,?,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(joinsql);
			pstmt.setString(1, aa.getUSERID());
			pstmt.setString(2, aa.getPA());
			pstmt.setString(3, aa.getUSERNAME());
			pstmt.setString(4, aa.getMAIL());
			pstmt.setString(5, aa.getIDENT());
			pstmt.setString(6, aa.getINTRODUCEMYSELF());
			result = pstmt.executeUpdate();

			if (result != 0) {
				return true;
			}

		} catch (Exception ex) {
			System.out.println("joinmember 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}

	public List getMembersList() {
		String sql = "SELECT * FROM MEMBERS";
		List memberslist = new ArrayList();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MembersBean mb = new MembersBean();
				mb.setUSERID(rs.getString("USERID"));
				mb.setPA(rs.getString("PA"));
				mb.setUSERNAME(rs.getString("USERNAME"));
				mb.setMAIL(rs.getString("MAIL"));
				mb.setIDENT(rs.getString("IDENT"));
				mb.setINTRODUCEMYSELF(rs.getString("INTRODUCEMYSELF"));

				memberslist.add(mb);
			}
			return memberslist;
		} catch (Exception ex) {
			System.out.println("memberslist 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return null;
	}

	public MembersBean getMembersInto(String USERID) {
		String sql = "SELECT * FROM MEMBERS WHERE USERID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, USERID);
			rs = pstmt.executeQuery();
			rs.next();

			MembersBean mb = new MembersBean();
			mb.setUSERID(rs.getString("USERID"));
			mb.setPA(rs.getString("PA"));
			mb.setUSERNAME(rs.getString("USERNAME"));
			mb.setMAIL(rs.getString("MAIL"));
			mb.setIDENT(rs.getString("IDENT"));
			mb.setINTRODUCEMYSELF(rs.getString("INTRODUCEMYSELF"));

			return mb;
		} catch (Exception ex) {
			System.out.println("getMembersInto 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return null;
	}

	public boolean deleteMembers(String USERID) {
		String sql = "DELETE FROM MEMBERS WHERE USERID=?";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, USERID);

			result = pstmt.executeUpdate();

			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("deleteMembers 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}
}
