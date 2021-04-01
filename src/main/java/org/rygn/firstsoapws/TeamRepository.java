package org.rygn.firstsoapws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import io.spring.guides.gs_producing_web_service.Team;

@Component
public class TeamRepository {

	private static final Map<String, Team> teams = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		Team psg = new Team();
		psg.setName("PSG");
		psg.setRanking(1);
		psg.setLeague("Ligue 1");
		
		teams.put(psg.getName(), psg);

		Team asse = new Team();
		asse.setName("ASSE");
		asse.setRanking(2);
		asse.setLeague("Ligue 1");


		teams.put(asse.getName(), asse);

		Team ol = new Team();
		ol.setName("OL");
		ol.setRanking(3);
		ol.setLeague("Ligue 1");

		teams.put(ol.getName(), ol);
	}

	public Team findTeam(String name) {

		return teams.get(name);
	}
	
	public List<Team> findAllTeams(){
		
		ArrayList<Team> allTeams = new ArrayList<Team>();
		TeamRepository.teams.forEach((k,v) -> allTeams.add(v));
		
		return allTeams;
	}
}
