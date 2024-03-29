package com.emmanuel.plumas.p10JavaLibrarEasyBatch;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.emmanuel.plumas.p10JavaLibrarEasyBatch.tasks.NotificationMailTask;
import com.emmanuel.plumas.p10JavaLibrarEasyBatch.tasks.RelanceMailTask;

@EnableScheduling
@SpringBootApplication
@EnableFeignClients("com.emmanuel.plumas.p10JavaLibrarEasyBatch.proxies")
public class P10JavaLibrarEasyBatchApplication {

	@Autowired
	@Qualifier("relanceMailTask")
	private RelanceMailTask relanceMailTask;
	
	@Autowired
	@Qualifier("notificationMailTask")
	private NotificationMailTask notificationMailTask;
	
	public static void main(String[] args) {
		SpringApplication.run(P10JavaLibrarEasyBatchApplication.class, args);
	}
	
	
	/*
	 * Si 24 hPP, fixexDelay = 86 400 000	
	 * Si 10 secondes pour test, fixedDelay = 10 000
	 */
	@Scheduled(fixedDelay=10000)
	public void run() throws MessagingException  {
		System.out.println("lancement du batch");
		relanceMailTask.execute();
		notificationMailTask.execute();
	}
	
	
	

}
