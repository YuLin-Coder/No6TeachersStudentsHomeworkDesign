package cn.smxy.fzw;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

//单元测试类：类名固定JUnitTest
//特点：没有main（）
//类里面的内容就是你对哪些方法来测试，直接写测试的代码
/*测试方法
 * @Test：导包junit.jar
 * 运行：右击测试方法名称---run as---Junit Test
 *     右击类的名称---run as---Junit Test
 * 	   
 * */
public class JUnitTest {
	
//	@Test
//	public void test () {
//		Connection conn = DBconnectionUtils.getConnectionFromPool();
//		System.out.println(conn);
//	}
	
	//测试的是UserDAO中的方法，增删改查
	//写法：首先方法要添加一个注解 @Test
	/*@Test
	public void testSaveUser() throws Exception{
		UserDAO userDAO=new UserDAO();
		userDAO.saveUser(new User("方", "123"));
	}*/
	/*//全部查询
	@Test
	public void testqueryAll() throws Exception {
		TeacherDAO userDAO=new TeacherDAO();
		List<Teacher> users=userDAO.queryAll();
		System.out.println(users);
	}*/
	//模糊查询
	/*@Test
	public void testqueryAllByCondition() throws Exception {
		Scanner cin=new Scanner(System.in);
		String str=cin.next(); //输入的字符串
		UserDAO userDAO=new UserDAO();
		List<User> users=userDAO.queryAllByCondition("%"+str+"%");
		System.out.println(users);
	}*/
	//具体查询
	@Test
	public void testqueryUser() throws Exception {
		TeacherDAO userDAO=new TeacherDAO();
		System.out.println(userDAO.queryUsers("孙丽丽").getTpwd());
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
