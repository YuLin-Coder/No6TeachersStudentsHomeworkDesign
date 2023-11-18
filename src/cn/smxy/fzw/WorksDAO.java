package cn.smxy.fzw;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineListener;

public class WorksDAO {
	//实现对数据库userdb的增删改查操作的，会有4个方法
		
	public boolean saveUser(Works user) throws Exception{ 
		//根据输入的用户名和密码实现插入(增加）
//		DBConnection connection = new DBConnection();	//创建没有实例化的对象
//		Connection conn = connection.getConnection();	//1、获取到了数据库userdb连接
		
		//通过数据库连接池获取连接
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		//调用存储过程：sp_insert_t_user---数据库里的存储过程名称
		String sp_insert_t_work="{call sp_insert_t_work(?,?,?,?)}";
		CallableStatement callableStatement=conn.prepareCall(sp_insert_t_work);
		callableStatement.setString(1, user.getwname());
		callableStatement.setString(2, user.getWcontent());
		callableStatement.setString(3, user.getP_time());
		callableStatement.setString(4, user.getF_time());
		//通过调用存储过程执行调用插入操作
		int val=callableStatement.executeUpdate();
		
		/*
		//2、要插入一条数据：sql语句 insert into t_users values(?,?)
		String intsert_sql ="insert into t_user values(?,?)";	//占位符 通配符（发送sql语局(数据库语言))固定insert into
		//3、执行这条语句
		//lib 大文件Folode(复制jav包)
		PreparedStatement statement =conn.prepareStatement(intsert_sql);
		//第一个？的数值设定
		statement.setString(1, user.gettid()); 	//第一个参数表示第几个？，第二个参数表示这个通配符所代表的值
		statement.setString(2, user.gettpwd());		//为第二个？设置数值
		//实现插入数据
		int val=statement.executeUpdate();//返回值类型 表示的意思是改变了几行
		//关闭
		statement.close();
		conn.close();
		*/
		if(val>0) {
			return true;
		}else {
			return false;
		}
	};
	//查询数据方法
	//全部查询：publc List<User> querAll()
	//使用集合java.util.List
	
	public List<Works> queryAll() throws Exception{
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		
		//查询语句：全部
		String queryAll="select * from t_works";
		PreparedStatement statement =conn.prepareStatement(queryAll);		
		//只有查询调用的是executeQuery
		//其他都是executeUpdata
		ResultSet rSet= statement.executeQuery();
		List<Works> users=new ArrayList<Works>();  //多态
		while(rSet.next()) { //while
			int wid = rSet.getInt(1);  //用getString()获取第1个字段的值
			String wname = rSet.getString(2);  //用getString()获取第2个字段的值
			String wcontent = rSet.getString(3);
			String p_time = rSet.getString(4);
			String f_time = rSet.getString(5);
			Works user =new Works(wid, wname, wcontent, p_time, f_time);
			users.add(user);	
		}
		return users;
	}
	
	//模糊查询：查询结果可能有很多也可能没有
	//返回值类型使用集合来接收java.util.List
	
	public List<Works> queryAllByCondition(String contition) throws Exception{
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		
		//查询语句：模糊
		String queryAll_user="select * from t_works where wname like ?";
		PreparedStatement statement =conn.prepareStatement(queryAll_user);		
		statement.setString(1, contition);
		//只有查询调用的是executeQuery
		//其他都是executeUpdata
		ResultSet rSet= statement.executeQuery();
		List<Works> users=new ArrayList<Works>();  //多态
		while(rSet.next()) { //while
			int wid = rSet.getInt(1);  //用getString()获取第1个字段的值
			String wname = rSet.getString(2);  //用getString()获取第2个字段的值
			String wcontent = rSet.getString(3);
			String p_time = rSet.getString(4);
			String f_time = rSet.getString(5);
			Works user =new Works(wid, wname, wcontent, p_time, f_time);
			users.add(user);	
		}
		return users;
	}
	//根据名字查询
	public Works queryUsers(String namekey) throws Exception{
			
		Connection conn = DBconnectionUtils.getConnectionFromPool();
			
		String query_user_sql ="select * from t_works where wname=?";
		PreparedStatement statement =conn.prepareStatement(query_user_sql);
			
		statement.setString(1, namekey);
			
		ResultSet rSet= statement.executeQuery();
			
		if(rSet.next()) { //while
			int wid = rSet.getInt(1);  //用getString()获取第1个字段的值
			String wname = rSet.getString(2);  //用getString()获取第2个字段的值
			String wcontent = rSet.getString(3);
			String p_time = rSet.getString(4);
			String f_time = rSet.getString(5);
			Works user =new Works(wid, wname, wcontent, p_time, f_time);
			return user;	
		}
		return null;
	};
		
	//删除数据方法
	public boolean deleteUsers(String idkey) throws Exception{
			
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		
		String delete_user="delete from t_works where wid=?";
		PreparedStatement statement =conn.prepareStatement(delete_user);
			
		statement.setString(1, idkey);
		int val=statement.executeUpdate();
		statement.close();
		conn.close();
			
		if(val>0) {
			return true;
		}else {
			return false;
		}
	};
		
	//更新数据方法
	public boolean updateUsers(String namekey,String time) throws Exception{//我这里输入两个值，datekey是用来改哪一个记录的time，time是改后的数值
			
		Connection conn = DBconnectionUtils.getConnectionFromPool();
			
		String update_user="update t_works set tpwd=? where tid=?";
		PreparedStatement statement =conn.prepareStatement(update_user);
			statement.setString(1, time);//为第一个问号赋值
			statement.setString(2, namekey);//为第二个问号赋值（这个就是查看要改哪一条记录）
			int val=statement.executeUpdate();
			statement.close();
			conn.close();
		
			if(val>0) {
				return true;
			}else {
				return false;
			}
	};
}
	
	

	