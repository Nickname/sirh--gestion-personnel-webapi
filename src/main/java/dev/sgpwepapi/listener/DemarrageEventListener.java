package dev.sgpwepapi.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.sgpwepapi.service.InitialiserDonneesService;

@Component
public class DemarrageEventListener {
	
	@Autowired InitialiserDonneesService initData;
	
    @EventListener({ContextRefreshedEvent.class})
    void initialiser() {
    	initData.init();
    }
    
}
