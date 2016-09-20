package com.chungok.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chungok.vo.ArtclVO;

public class ArtclDaoImpl implements ArtclDao{

	@Override
	public List<ArtclVO> getArtcls() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ARTCL","ARTCL");
			
			String query = "SELECT ARTCL_ID, SBJ, CONT, CRT_DT FROM ARTCL";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			List<ArtclVO> artcl = new ArrayList<ArtclVO>();
			
			ArtclVO artclVo = null;
			
			while (rs.next()) {
				artclVo = new ArtclVO();
				artclVo.setArticleId(rs.getInt("ARTCL_ID"));
				artclVo.setSubject(rs.getString("SBJ"));
				artclVo.setContent(rs.getString("CONT"));
				artclVo.setCreatDate(rs.getString("CRT_DT"));
				
				artcl.add(artclVo);
			}
			return artcl;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		finally {
			if(rs !=null ){
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt !=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn !=null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
