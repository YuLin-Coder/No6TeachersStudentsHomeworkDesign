package cn.smxy.fzw;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

//��Ԫ�����ࣺ�����̶�JUnitTest
//�ص㣺û��main����
//����������ݾ��������Щ���������ԣ�ֱ��д���ԵĴ���
/*���Է���
 * @Test������junit.jar
 * ���У��һ����Է�������---run as---Junit Test
 *     �һ��������---run as---Junit Test
 * 	   
 * */
public class JUnitTest {
	
//	@Test
//	public void test () {
//		Connection conn = DBconnectionUtils.getConnectionFromPool();
//		System.out.println(conn);
//	}
	
	//���Ե���UserDAO�еķ�������ɾ�Ĳ�
	//д�������ȷ���Ҫ���һ��ע�� @Test
	/*@Test
	public void testSaveUser() throws Exception{
		UserDAO userDAO=new UserDAO();
		userDAO.saveUser(new User("��", "123"));
	}*/
	/*//ȫ����ѯ
	@Test
	public void testqueryAll() throws Exception {
		TeacherDAO userDAO=new TeacherDAO();
		List<Teacher> users=userDAO.queryAll();
		System.out.println(users);
	}*/
	//ģ����ѯ
	/*@Test
	public void testqueryAllByCondition() throws Exception {
		Scanner cin=new Scanner(System.in);
		String str=cin.next(); //������ַ���
		UserDAO userDAO=new UserDAO();
		List<User> users=userDAO.queryAllByCondition("%"+str+"%");
		System.out.println(users);
	}*/
	//�����ѯ
	@Test
	public void testqueryUser() throws Exception {
		TeacherDAO userDAO=new TeacherDAO();
		System.out.println(userDAO.queryUsers("������").getTpwd());
	}
	/*@Test
	public void testdeleteUsers() throws Exception {
		UserDAO userDAO=new UserDAO();
		System.out.println(userDAO.deleteUsers("FANG12345"));
	}
	@Test
	public void testupdateUsers() throws Exception {
		UserDAO userDAO=new UserDAO();
		System.out.println(userDAO.updateUsers("FANG1234", "123"));
	}*/
}
