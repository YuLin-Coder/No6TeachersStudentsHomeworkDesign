package cn.smxy.fzw;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineListener;

public class StudentDAO {
	//实现对数据库userdb的增删改查操作的，会有4个方法
		
	public boolean saveUser(Student user) throws Exception{ 
		//根据输入的用户名和密码实现插入(增加）
//		DBConnection connection = new DBConnection();	//创建没有实例化的对象
//		Connection conn = connection.getConnection();	//1、获取到了数据库userdb连接
		
		//通过数据库连接池获取连接
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		//调用存储过程：sp_insert_t_user---数据库里的存储过程名称
		String sp_insert_t_Student="{call sp_insert_t_Student(?,?,?)}";
		CallableStatement callableStatement=conn.prepareCall(sp_insert_t_Student);
		callableStatement.setString(1, user.getsid());
		callableStatement.setString(2, user.getsname());		
		callableStatement.setString(3, user.getspwd());	
		//通过调用存储过程执行调用插入操作
		int val=callableStatement.executeUpdate();
		
		/*
		//2、要插入一条数据：sql语句 insert into t_users values(?,?)
		String intsert_sql ="insert into t_user values(?,?)";	//占位符 通配符（发送sql语局(数据库语言))固定insert into
		//3、执行这条语句
		//lib 大文件Folode(复制jav包)
		PreparedStatement statement =conn.prepareStatement(intsert_sql);
		//第一个？的数值设定
		statement.setString(1, user.getsid()); 	//第一个参数表示第几个？，第二个参数表示这个通配符所代表的值
		statement.setString(2, user.getspwd());		//为第二个？设置数值
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
	
	public List<Student> queryAll() throws Exception{
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		
		//查询语句：全部
		String queryAll="select * from t_Students";
		PreparedStatement statement =conn.prepareStatement(queryAll);		
		//只有查询调用的是executeQuery
		//其他都是executeUpdata
		ResultSet rSet= statement.executeQuery();
		List<Student> users=new ArrayList<Student>();  //多态
		while(rSet.next()) { //while
			String sid = rSet.getString(1);  //用getString()获取第1个字段的值
			String sname = rSet.getString(2);  //用getString()获取第2个字段的值
			String spwd = rSet.getString(3);
			Student user =new Student(sid, sname, spwd);
			users.add(user);	
		}
		return users;
	}
	
	//模糊查询：查询结果可能有很多也可能没有
	//返回值类型使用集合来接收java.util.List
	
	public List<Student> queryAllByCondition(String contition) throws Exception{
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		
		//查询语句：模糊
		String queryAll_user="select * from t_Students where sname like ?";
		PreparedStatement statement =conn.prepareStatement(queryAll_user);		
		statement.setString(1, contition);
		//只有查询调用的是executeQuery
		//其他都是executeUpdata
		ResultSet rSet= statement.executeQuery();
		List<Student> users=new ArrayList<Student>();  //多态
		while(rSet.next()) { //while
			String sid = rSet.getString(1);  //用getString()获取第1个字段的值
			String sname = rSet.getString(2);
			String spwd = rSet.getString(3);  //用getString()获取第3个字段的值
			Student user =new Student(sid, sname, spwd);
			users.add(user);	
		}
		return users;
	}
	//根据名字查询
	public Student queryUsers(String namekey) throws Exception{
			
		Connection conn = DBconnectionUtils.getConnectionFromPool();
			
		String query_user_sql ="select * from t_Students where sname=?";
		PreparedStatement statement =conn.prepareStatement(query_user_sql);
			
		statement.setString(1, namekey);
			
		ResultSet rSet= statement.executeQuery();
			
		if(rSet.next()) { //while
			String sid = rSet.getString(1);  //用getString()获取第1个字段的值
			String sname = rSet.getString(2);
			String spwd = rSet.getString(3);  //用getString()获取第3个字段的值
			Student user =new Student(sid, sname, spwd);
			return user;
				
		}
		return null;
	};
		
	//删除数据方法
	public boolean deleteUsers(String namekey) throws Exception{
			
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		
		String delete_user="delete from t_Students where sid=?";
		PreparedStatement statement =conn.prepareStatement(delete_user);
			
		statement.setString(1, namekey);
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
			
		String update_user="update t_Students set spwd=? where sid=?";
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
	
	

	