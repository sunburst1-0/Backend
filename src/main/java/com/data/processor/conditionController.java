package com.data.processor;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.rules.Condition;

@RestController
public class conditionController {
	@Autowired
	private KieSession session;

	@PostMapping("/condition")
	public Condition orderNow(@RequestBody Condition condition) {
		session.insert(condition);
		session.fireAllRules();
		return condition;
	}

}
