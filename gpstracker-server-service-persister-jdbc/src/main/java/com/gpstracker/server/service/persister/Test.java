package com.gpstracker.server.service.persister;

import org.joda.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gpstracker.server.model.internal.user.User;
import com.gpstracker.server.service.persister.dao.UserJDBCDAO;
import com.gpstracker.server.service.persister.dao.api.UserDAO;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/PersisterContext.xml");

//		JDBCPersistentService persistService = (JDBCPersistentService) context.getBean("persistService");
//		
//		GPSCoordinates gpsCoordinates = new GPSCoordinates();
//		gpsCoordinates.setLatitude(123.434);
//		gpsCoordinates.setLongitude(56546.778);
//		persistService.store(gpsCoordinates);
		
		UserDAO userDAO = (UserJDBCDAO) context.getBean("userDAO");
		User user = new User();
		user.setUserEmailAddress("kower007@hotmail.com");
		user.setUserName("Kenneth Johnston");
		user.setUserPhoneNumber("085 5555555");
		user.setUserRegistrationDate(LocalDate.now());
		user.setUserId(1);
		userDAO.store(user);
		
		User userIn = userDAO.load(0); 

		System.out.println("Breakpoint");
	}

}
