package com.wellsfargo.fsd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfargo.fsd.lms.dao.LMSUserRepo;
import com.wellsfargo.fsd.lms.enitity.LMSUser;

@Component
public class AppStartUpEventHandler {

	@Autowired
	private LMSUserRepo repositorty;
	
	@Autowired
	private PasswordEncoder penc;
	
	@EventListener
	public void onStartUp(ApplicationReadyEvent event) {

		if(!repositorty.existsByUserName("admin")){
			repositorty.save(new LMSUser("admin","adminA",penc.encode("admin"),"ADMIN"));
		}
	}
}
