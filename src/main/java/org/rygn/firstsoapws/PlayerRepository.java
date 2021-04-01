package org.rygn.firstsoapws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import io.spring.guides.gs_producing_web_service.Player;
import io.spring.guides.gs_producing_web_service.Role;

@Component
public class PlayerRepository {
	
	private static final Map<String, Player> players = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		Player mbape = new Player();
		mbape.setName("Kylian Mbappé");
		mbape.setNumber(10);
		mbape.setPosition(Role.ATTACKER);
		
		players.put(mbape.getName(), mbape);
		
		Player hamouma = new Player();
		hamouma.setName("Romain Hamouma");
		hamouma.setNumber(21);
		hamouma.setPosition(Role.ATTACKER);
		
		players.put(hamouma.getName(), hamouma);

		Player depay = new Player();
		depay.setName("Memphis Depay");
		depay.setNumber(10);
		depay.setPosition(Role.ATTACKER);
		
		players.put(depay.getName(), depay);

		
	}
	
	public Player findPlayer(String name) {
		return players.get(name);
	}

	public static List<Player> findAllPlayers() {
		ArrayList<Player> allPlayers = new ArrayList<Player>();
		players.forEach((k,v) -> allPlayers.add(v));
		return allPlayers;
	}

}
