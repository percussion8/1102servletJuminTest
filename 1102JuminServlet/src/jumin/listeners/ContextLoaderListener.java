package jumin.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import jumin.dao.JuminDao;
import jumin.util.DBConnectionPool;


@WebListener
public class ContextLoaderListener implements ServletContextListener {

	DBConnectionPool connPool;

    public void contextDestroyed(ServletContextEvent arg0)  { //실행이 종료되면 db커넥션도 모두 종료
    	connPool.closeAll();
    }

    public void contextInitialized(ServletContextEvent event)  { 
    	//db커넥션 객체 준비
        //웹 애플리케이션 시작할 때 호출됨.공용 객체를 준비해야 하면 이 메서드 사용
        try {
          ServletContext sc = event.getServletContext();
          connPool = new DBConnectionPool("com.mysql.cj.jdbc.Driver",
        		  "jdbc:mysql://localhost:3306/jumindb?serverTimezone=Asia/Seoul","root","1234" );
          System.out.println("DB 접속 성공 "+connPool);
          JuminDao juminDao = new JuminDao();
          juminDao.setConnection(connPool);
          sc.setAttribute("juminDao", juminDao);
          System.out.println("주민dao보냄" + juminDao);
       } catch (Throwable e) {
          e.printStackTrace();
       }
    }
	
}
