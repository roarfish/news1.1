package com.zhou.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * sql编写
 * @author zhoup
 *
 */
public class SqlHelper {
	private Connection conn=null;
	/**
	 * 建立连接
	 */
	public SqlHelper(){
		conn=DB.getConnection();
	}
	/**
	 * 销毁连接
	 */
	public void destroy(){
		if(conn==null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String queryArticleById(String article_id) {
		String sql = "select article_content "
				+ "from article "
				+ "where article_id=? ";
		String	content = null;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, article_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			content =  rs.getString("article_content");
		}catch(Exception e){
			e.printStackTrace();
		}
		return content;
	}
	
}
