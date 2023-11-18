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
	//ʵ�ֶ����ݿ�userdb����ɾ�Ĳ�����ģ�����4������
		
	public boolean saveUser(Works user) throws Exception{ 
		//����������û���������ʵ�ֲ���(���ӣ�
//		DBConnection connection = new DBConnection();	//����û��ʵ�����Ķ���
//		Connection conn = connection.getConnection();	//1����ȡ�������ݿ�userdb����
		
		//ͨ�����ݿ����ӳػ�ȡ����
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		//���ô洢���̣�sp_insert_t_user---���ݿ���Ĵ洢��������
		String sp_insert_t_work="{call sp_insert_t_work(?,?,?,?)}";
		CallableStatement callableStatement=conn.prepareCall(sp_insert_t_work);
		callableStatement.setString(1, user.getwname());
		callableStatement.setString(2, user.getWcontent());
		callableStatement.setString(3, user.getP_time());
		callableStatement.setString(4, user.getF_time());
		//ͨ�����ô洢����ִ�е��ò������
		int val=callableStatement.executeUpdate();
		
		/*
		//2��Ҫ����һ�����ݣ�sql��� insert into t_users values(?,?)
		String intsert_sql ="insert into t_user values(?,?)";	//ռλ�� ͨ���������sql���(���ݿ�����))�̶�insert into
		//3��ִ���������
		//lib ���ļ�Folode(����jav��)
		PreparedStatement statement =conn.prepareStatement(intsert_sql);
		//��һ��������ֵ�趨
		statement.setString(1, user.gettid()); 	//��һ��������ʾ�ڼ��������ڶ���������ʾ���ͨ����������ֵ
		statement.setString(2, user.gettpwd());		//Ϊ�ڶ�����������ֵ
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
	
	public List<Works> queryAll() throws Exception{
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		
		//��ѯ��䣺ȫ��
		String queryAll="select * from t_works";
		PreparedStatement statement =conn.prepareStatement(queryAll);		
		//ֻ�в�ѯ���õ���executeQuery
		//��������executeUpdata
		ResultSet rSet= statement.executeQuery();
		List<Works> users=new ArrayList<Works>();  //��̬
		while(rSet.next()) { //while
			int wid = rSet.getInt(1);  //��getString()��ȡ��1���ֶε�ֵ
			String wname = rSet.getString(2);  //��getString()��ȡ��2���ֶε�ֵ
			String wcontent = rSet.getString(3);
			String p_time = rSet.getString(4);
			String f_time = rSet.getString(5);
			Works user =new Works(wid, wname, wcontent, p_time, f_time);
			users.add(user);	
		}
		return users;
	}
	
	//ģ����ѯ����ѯ��������кܶ�Ҳ����û��
	//����ֵ����ʹ�ü���������java.util.List
	
	public List<Works> queryAllByCondition(String contition) throws Exception{
		Connection conn = DBconnectionUtils.getConnectionFromPool();
		
		//��ѯ��䣺ģ��
		String queryAll_user="select * from t_works where wname like ?";
		PreparedStatement statement =conn.prepareStatement(queryAll_user);		
		statement.setString(1, contition);
		//ֻ�в�ѯ���õ���executeQuery
		//��������executeUpdata
		ResultSet rSet= statement.executeQuery();
		List<Works> users=new ArrayList<Works>();  //��̬
		while(rSet.next()) { //while
			int wid = rSet.getInt(1);  //��getString()��ȡ��1���ֶε�ֵ
			String wname = rSet.getString(2);  //��getString()��ȡ��2���ֶε�ֵ
			String wcontent = rSet.getString(3);
			String p_time = rSet.getString(4);
			String f_time = rSet.getString(5);
			Works user =new Works(wid, wname, wcontent, p_time, f_time);
			users.add(user);	
		}
		return users;
	}
	//�������ֲ�ѯ
	public Works queryUsers(String namekey) throws Exception{
			
		Connection conn = DBconnectionUtils.getConnectionFromPool();
			
		String query_user_sql ="select * from t_works where wname=?";
		PreparedStatement statement =conn.prepareStatement(query_user_sql);
			
		statement.setString(1, namekey);
			
		ResultSet rSet= statement.executeQuery();
			
		if(rSet.next()) { //while
			int wid = rSet.getInt(1);  //��getString()��ȡ��1���ֶε�ֵ
			String wname = rSet.getString(2);  //��getString()��ȡ��2���ֶε�ֵ
			String wcontent = rSet.getString(3);
			String p_time = rSet.getString(4);
			String f_time = rSet.getString(5);
			Works user =new Works(wid, wname, wcontent, p_time, f_time);
			return user;	
		}
		return null;
	};
		
	//ɾ�����ݷ���
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
		
	//�������ݷ���
	public boolean updateUsers(String namekey,String time) throws Exception{//��������������ֵ��datekey����������һ����¼��time��time�Ǹĺ����ֵ
			
		Connection conn = DBconnectionUtils.getConnectionFromPool();
			
		String update_user="update t_works set tpwd=? where tid=?";
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
	
	

	