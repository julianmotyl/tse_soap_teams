package org.rygn.firstsoapws;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import io.spring.guides.gs_producing_web_service.Team;
import io.spring.guides.gs_producing_web_service.Currency;

@Component
public class TeamRepository {

	private static final Map<String, Team> teams = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		Team spain = new Team();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setPopulation(46704314);

		teams.put(spain.getName(), spain);

		Team poland = new Team();
		poland.setName("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);

		teams.put(poland.getName(), poland);

		Team uk = new Team();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);

		teams.put(uk.getName(), uk);
	}

	public Team findTeam(String name) {

		return teams.get(name);
	}
}
