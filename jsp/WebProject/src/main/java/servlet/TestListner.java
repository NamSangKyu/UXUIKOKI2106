package servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TestListner
 *
 */
@WebListener
public class TestListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("종료");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // 웹어플리케이션이 실행 됐을때
//    	System.out.println("실행");
//    	TestCronTrigger trigger = new TestCronTrigger("0 0/1 * * 1/1 ? *", AutoDatePrintJob.class);
//		trigger.triggerJob();
    }
	/*
	 * Listener는 웹어플리케이션 이벤트 및 환경에 따라 실행하는 인터페이스
	 * 	ServletContext --> 웹 어플리케이션 관련 이벤트
	 *  HttpSession --> 세션 관련 이벤트
	 *  SevletRequest --> 사용자 요청 관련 이벤트
	 *  	
	 *  	lifecycle이 생명주기에 대한 이벤트 처리 
	 * 
	 */
}






