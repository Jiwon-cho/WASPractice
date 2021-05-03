package com.common.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextTestListener implements ServletContextListener
,ServletContextAttributeListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("서버 종료");
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
	System.out.println("속성에 값 추가");
	System.out.println(scae.getName());//추가된 키 
	System.out.println(scae.getValue());//추가된 값
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		System.out.println("속성에 값 삭제");
		System.out.println(scae.getName());//추가된 키 
		System.out.println(scae.getValue());//추가된 값
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	System.out.println("서버 실행");
	}

}
