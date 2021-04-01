package org.rygn.firstsoapws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetAllTeamRequest;
import io.spring.guides.gs_producing_web_service.GetAllTeamResponse;
import io.spring.guides.gs_producing_web_service.GetTeamRequest;
import io.spring.guides.gs_producing_web_service.GetTeamResponse;

@Endpoint
public class TeamEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private TeamRepository TeamRepository;

	@Autowired
	public TeamEndpoint(TeamRepository TeamRepository) {
		this.TeamRepository = TeamRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTeamRequest")
	@ResponsePayload
	public GetTeamResponse getTeam(@RequestPayload GetTeamRequest request) {

		GetTeamResponse response = new GetTeamResponse();

		response.setTeam(TeamRepository.findTeam(request.getName()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllTeamRequest")
	@ResponsePayload
	public GetAllTeamResponse getAllTeams(@RequestPayload GetAllTeamRequest request) {

		GetAllTeamResponse response = new GetAllTeamResponse();

//		response.getTeam().addAll(TeamRepository.findAllTeams());
		TeamRepository.findAllTeams().forEach((team) -> response.getTeam().add(team));

		return response;
	}
}
