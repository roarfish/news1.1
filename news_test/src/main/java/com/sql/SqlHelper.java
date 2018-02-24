package com.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.db.DB;
import com.entity.Article;
import com.entity.ArticlePojo;
import com.entity.Manager;
import com.entity.Nav;
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
	/**
	 * 插入到manager表
	 * @param manager
	 * @return
	 */
	public boolean insertManager(Manager manager){
		String sql="insert into manager (manager_id,manager_name,manager_pwd) values(?,?,?)";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, manager.getManager_id());
			ps.setString(2, manager.getManager_name());
			ps.setString(3, manager.getManager_pwd());
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 插入新闻类别信息
	 * @param nav
	 * @return
	 */
	public boolean insertNav(Nav nav){
		String sql="insert into nav (nav_id,nav_name,nav_feight) values(?,?,?)";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, nav.getNav_id());
			ps.setString(2, nav.getNav_name());
			ps.setInt(3, nav.getNav_feight());
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 删除一条Nav数据
	 */
	public boolean deleteNav(String id){
		String sql="delete from nav where nav_id=?";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 删除一条Manager数据
	 */
	public boolean deleteManager(String id){
		String sql="delete from manager where manager_id=?";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 更新Manager数据
	 */
	public boolean updateManger(Manager manager){
		String sql="update manager set manager_name=? where manager_id=?";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, manager.getManager_name());
			ps.setString(2, manager.getManager_id());
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 更新Nav数据
	 */
	public boolean updateNav(Nav nav){
		String sql="update nav set nav_name=?,nav_feight=? where nav_id=?";
		boolean b=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, nav.getNav_name());
			ps.setInt(2, nav.getNav_feight());
			ps.setString(3, nav.getNav_id());
			ps.executeUpdate();
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	/**
	 * 根据ID查找Manager
	 * @param manager_id
	 * @return
	 */
	public Manager queryManagerById(String manager_id){
		String sql="select * from manager where manager_id=?";
		Manager manager=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, manager_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				manager=new Manager();
				manager.setManager_id(rs.getString("manager_id"));
				manager.setManager_name(rs.getString("manager_name"));
				manager.setManager_pwd(rs.getString("manager_pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manager;
	}
	/**
	 * 根据ID查找Nav
	 * @param manager_id
	 * @return
	 */
	public Nav queryNavById(String nav_id){
		String sql="select * from nav where nav_id=?";
		Nav nav=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, nav_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				nav=new Nav();
				nav.setNav_id(rs.getString("nav_id"));
				nav.setNav_name(rs.getString("nav_name"));
				nav.setNav_feight(rs.getInt("nav_feight"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nav;
	}
	/**
	 * 根据Id与密码查询用户
	 * @param m
	 * @return
	 */
	public Manager queryManagerByIdAndPwd(Manager m){
		String sql="select * from manager where manager_id=? and manager_pwd=?";
		Manager manager=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, m.getManager_id());
			ps.setString(2, m.getManager_pwd());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				manager=new Manager();
				manager.setManager_id(rs.getString("manager_id"));
				manager.setManager_name(rs.getString("manager_name"));
				manager.setManager_pwd(rs.getString("manager_pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return manager;
	}
	/**
	 * 查询全部管理员信息
	 * @return
	 */
	public  List<Manager> queryManagerAll(){
		List<Manager> managerList=new ArrayList<Manager>();
		String sql="select manager_id,manager_name from manager";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Manager manager=new Manager();
				manager.setManager_id(rs.getString("manager_id"));
				manager.setManager_name(rs.getString("manager_name"));
				managerList.add(manager);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return managerList;
	}
	/**
	 * 查询全部新闻类别信息
	 * @return
	 */
	public  List<Nav> queryNavAll(){
		List<Nav> navList=new ArrayList<Nav>();
		String sql="select nav_id,nav_name,nav_feight from nav";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Nav nav=new Nav();
				nav.setNav_id(rs.getString("nav_id"));
				nav.setNav_name(rs.getString("nav_name"));
				nav.setNav_feight(rs.getInt("nav_feight"));
				navList.add(nav);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return navList;
	}
	public List<Article> queryArticleByNav_id(String nav_id) {
		String sql="select * from article where nav_id=? order by article_date desc limit 0,4";
		List<Article> article=new ArrayList<Article>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, nav_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Article a=new Article();
				a.setArticle_id(rs.getString("article_id"));
				a.setArticle_title(rs.getString("article_title"));
				a.setArticle_date(rs.getString("article_date"));
				a.setArticle_content(rs.getString("article_content"));
				a.setNav_id(nav_id);
				article.add(a);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return article;
	}
	public boolean insertArticel(Article article) {
		String sql="insert into article values(?,?,?,?,?)";
		boolean b = false;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, article.getArticle_id());
			ps.setString(2, article.getArticle_title());
			ps.setString(3, article.getArticle_date());
			ps.setString(4, article.getArticle_content());
			ps.setString(5, article.getNav_id());
			ps.executeUpdate();
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public List<ArticlePojo> queryArticleAll() {
		String sql="select article_id,article_title,article_date,a.nav_id,nav_name,nav_feight from article a,nav n "
				+ "where a.nav_id=n.nav_id order by a.article_date desc";
		List<ArticlePojo> list=new ArrayList<ArticlePojo>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ArticlePojo art = new ArticlePojo();
				art.setArticle_date(rs.getString("article_date"));
				art.setArticle_title(rs.getString("article_title"));
				art.setArticle_id(rs.getString("article_id"));
				art.setNav_name(rs.getString("nav_name"));
				list.add(art);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private int perPage = 4;
	public List<Map> queryArticleMapByPage(int p) {
		int start = p*perPage;
		String sql = "select article_id,article_title,article_date,nav_name "
				+ "from article,nav "
				+ "where article.nav_id=nav.nav_id "
				+ "order by article_date desc "
				+ "limit "+start+","+perPage;
		
		List <Map>list = new ArrayList();
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Map map = new HashMap();
				map.put("article_date", 	rs.getString("article_date")	);
				map.put("article_title",	rs.getString("article_title")	);
				map.put("article_id", 		rs.getString("article_id")		);
				map.put("nav_name", 		rs.getString("nav_name")		);
				list.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Map> queryArticleMapByPage(int p,String nav_id,String article_title) {
			int start = p*perPage;
			int ii = start+1;
			String sql = "select article_id,article_title,article_date,nav_name "
					+ "from article a,nav n "
					+ "where a.nav_id=n.nav_id";
			if(nav_id !=null && !"".equals(nav_id)){
				sql += " and n.nav_id=? ";
			}
			if(article_title !=null && !"".equals(article_title)){
				sql += " and article_title like ? ";
			}
			sql	+= " order by article_date desc "
					+ "limit "+start+","+perPage;
			List <Map>list = new ArrayList();
			try{
				PreparedStatement ps = conn.prepareStatement(sql);
				int pos = 1;
				if(nav_id !=null && !"".equals(nav_id)){
					ps.setString(1, nav_id);
					pos = 2;
				}
				if(article_title !=null && !"".equals(article_title)){
					ps.setString(pos, "%"+article_title+"%");
				}
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Map map = new HashMap();
					map.put("order_no", 		ii++							);
					map.put("article_date", 	rs.getString("article_date")	);
					map.put("article_title",	rs.getString("article_title")	);
					map.put("article_id", 		rs.getString("article_id")		);
					map.put("nav_name", 		rs.getString("nav_name")		);
					list.add(map);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return list;
		}
	
	public int queryArticleCount(String nav_id,String article_title){
		String sql = "select count(*) from article";
		int pos = 0;
		boolean f1 = nav_id !=null && !"".equals(nav_id);
		if(f1){
			sql="select count(*) from article,nav "
					+ "where article.nav_id=nav.nav_id and nav.nav_id=? ";
			pos = 1;
		}
		boolean f2 = article_title !=null && !"".equals(article_title);
		if(f2){
			sql += (pos>0?" and ":" where ") +"  article_title like ? ";
			pos+=1;
		}
		try{
			PreparedStatement  ps = conn.prepareStatement(sql);
			
			if(f1){
				ps.setString(1, nav_id);
			}
			if(f2){
				ps.setString(pos, "%"+article_title+"%");
			}
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int queryArticleCount(){
		String sql = "select count(*) from article";
		try{
			PreparedStatement  ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public Article queryArticleById(String article_id) {
		String sql = "select article_id,article_title,article_date,article_content,nav_id "
				+ "from article "
				+ "where article_id=? "
				+ "order by article_date desc";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, article_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Article a = new Article();
				a.setArticle_content(rs.getString("article_content"));
				a.setArticle_date(rs.getString("article_date"));
				a.setArticle_id(article_id);
				a.setArticle_title(rs.getString("article_title"));
				a.setNav_id(rs.getString("nav_id"));
				return a;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean editArticle(Article article) {
		String sql = "update article "
					+ "set article_title=?,article_date=?,article_content=?,nav_id=? "
					+ "where article_id=?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, article.getArticle_title()	);
			ps.setString(2, article.getArticle_date()	);
			ps.setString(3, article.getArticle_content());
			ps.setString(4, article.getNav_id()			);
			ps.setString(5, article.getArticle_id()		);
			ps.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteNewsById(String article_id) {
		String sql = "delete from article where article_id=?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, article_id);
			ps.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public List<Article> queryLastArticles() {
		String sql = "select article_id,article_title from article order by article_date desc limit 0,10";
		List list = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Article a = new Article();
				a.setArticle_id(rs.getString("article_id"));
				a.setArticle_title(rs.getString("article_title"));
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
