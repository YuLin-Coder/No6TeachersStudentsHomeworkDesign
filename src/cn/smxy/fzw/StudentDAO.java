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
	//ʵ�ֶ����ݿ�userdb����ɾ�Ĳ�����ģ�����4������
		
	public boolean saveUser(Student user) throws Exception{ 
		//����������û���������ʵ�ֲ���(���ӣ�
//		DBConnection connection = new DBConnection();	//����û��ʵ�����Ķ���
//		Connection conn = connection.getConnection();	//1����ȡ�������ݿ�userdb����
		
		//ͨ�����ݿ����ӳػ�ȡ����
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		//���ô洢���̣�sp_insert_t_user---���ݿ���Ĵ洢��������
		String sp_insert_t_Student="{call sp_insert_t_Student(?,?,?)}";
		CallableStatement callableStatement=conn.prepareCall(sp_insert_t_Student);
		callableStatement.setString(1, user.getsid());
		callableStatement.setString(2, user.getsname());		
		callableStatement.setString(3, user.getspwd());	
		//ͨ�����ô洢����ִ�е��ò������
		int val=callableStatement.executeUpdate();
		
		/*
		//2��Ҫ����һ�����ݣ�sql��� insert into t_users values(?,?)
		String intsert_sql ="insert into t_user values(?,?)";	//ռλ�� ͨ���������sql���(���ݿ�����))�̶�insert into
		//3��ִ���������
		//lib ���ļ�Folode(����jav��)
		PreparedStatement statement =conn.prepareStatement(intsert_sql);
		//��һ��������ֵ�趨
		statement.setString(1, user.getsid()); 	//��һ��������ʾ�ڼ��������ڶ���������ʾ���ͨ����������ֵ
		statement.setString(2, user.getspwd());		//Ϊ�ڶ�����������ֵ
		//ʵ�ֲ�������
		int val=statement.executeUpdate();//����ֵ���� ��ʾ����˼�Ǹı��˼���
		//�ر�
		statement.close();
		conn.close();
		*/
		if(val>0) {
			return true;
		}else {
			return false;
		}
	};
	//��ѯ���ݷ���
	//ȫ����ѯ��publc List<User> querAll()
	//ʹ�ü���java.util.List
	
	public List<Student> queryAll() throws Exception{
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		
		//��ѯ��䣺ȫ��
		String queryAll="select * from t_Students";
		PreparedStatement statement =conn.prepareStatement(queryAll);		
		//ֻ�в�ѯ���õ���executeQuery
		//��������executeUpdata
		ResultSet rSet= statement.executeQuery();
		List<Student> users=new ArrayList<Student>();  //��̬
		while(rSet.next()) { //while
			String sid = rSet.getString(1);  //��getString()��ȡ��1���ֶε�ֵ
			String sname = rSet.getString(2);  //��getString()��ȡ��2���ֶε�ֵ
			String spwd = rSet.getString(3);
			Student user =new Student(sid, sname, spwd);
			users.add(user);	
		}
		return users;
	}
	
	//ģ����ѯ����ѯ��������кܶ�Ҳ����û��
	//����ֵ����ʹ�ü���������java.util.List
	
	public List<Student> queryAllByCondition(String contition) throws Exception{
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		
		//��ѯ��䣺ģ��
		String queryAll_user="select * from t_Students where sname like ?";
		PreparedStatement statement =conn.prepareStatement(queryAll_user);		
		statement.setString(1, contition);
		//ֻ�в�ѯ���õ���executeQuery
		//��������executeUpdata
		ResultSet rSet= statement.executeQuery();
		List<Student> users=new ArrayList<Student>();  //��̬
		while(rSet.next()) { //while
			String sid = rSet.getString(1);  //��getString()��ȡ��1���ֶε�ֵ
			String sname = rSet.getString(2);
			String spwd = rSet.getString(3);  //��getString()��ȡ��3���ֶε�ֵ
			Student user =new Student(sid, sname, spwd);
			users.add(user);	
		}
		return users;
	}
	//�������ֲ�ѯ
	public Student queryUsers(String namekey) throws Exception{
			
		Connection conn = DBconnectionUtils.getConnectionFromPool();
			
		String query_user_sql ="select * from t_Students where sname=?";
		PreparedStatement statement =conn.prepareStatement(query_user_sql);
			
		statement.setString(1, namekey);
			
		ResultSet rSet= statement.executeQuery();
			
		if(rSet.next()) { //while
			String sid = rSet.getString(1);  //��getString()��ȡ��1���ֶε�ֵ
			String sname = rSet.getString(2);
			String spwd = rSet.getString(3);  //��getString()��ȡ��3���ֶε�ֵ
			Student user =new Student(sid, sname, spwd);
			return user;
				
		}
		return null;
	};
		
	//ɾ�����ݷ���
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
		
	//�������ݷ���
	public boolean updateUsers(String namekey,String time) throws Exception{//��������������ֵ��datekey����������һ����¼��time��time�Ǹĺ����ֵ
			
		Connection conn = DBconnectionUtils.getConnectionFromPool();
			
		String update_user="update t_Students set spwd=? where sid=?";
		PreparedStatement statement =conn.prepareStatement(update_user);
			statement.setString(1, time);//Ϊ��һ���ʺŸ�ֵ
			statement.setString(2, namekey);//Ϊ�ڶ����ʺŸ�ֵ��������ǲ鿴Ҫ����һ����¼��
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
	
	

	