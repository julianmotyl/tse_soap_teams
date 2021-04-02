package org.rygn.firstsoapws;

import static org.springframework.ws.test.server.RequestCreators.*;
import static org.springframework.ws.test.server.ResponseMatchers.*;

import javax.xml.transform.Source;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

@SpringBootTest
public class TeamEndpointTest {

	@Autowired
	private ApplicationContext applicationContext;

	private MockWebServiceClient mockWebServiceClient;

	@BeforeEach
	public void createClient() throws Exception {
		mockWebServiceClient = MockWebServiceClient.createClient(applicationContext);
	}

	@Test
	public void teamUniqEndpoint() throws Exception {
		
		Source requestPayload = new StringSource("<getTeamRequest xmlns='http://spring.io/guides/gs-producing-web-service'>"
				+ "<name>PSG</name>" + "</getTeamRequest>");
		
		Source expectedResponsePayload = new StringSource(
				"<getTeamResponse xmlns='http://spring.io/guides/gs-producing-web-service'>"
						+ "  <Team>"
						+ "    <name>PSG</name>"
						+ "    <ranking>1</ranking>"
						+ "    <league>Ligue 1</league>"
						+ "  </Team>" 
						+ "</getTeamResponse>");

		mockWebServiceClient
			.sendRequest(withPayload(requestPayload))
			.andExpect(payload(expectedResponsePayload));
	}
	
	@Test
	public void allTeamEndpoint() throws Exception {
		Source requestPayload = new StringSource("<getAllTeamRequest xmlns='http://spring.io/guides/gs-producing-web-service'></getAllTeamRequest>");
		
		Source expectedResponsePayload = new StringSource(
				"<getAllTeamResponse xmlns='http://spring.io/guides/gs-producing-web-service'>"
						+ "  <Team>"
						+ "    <name>PSG</name>"
						+ "    <ranking>1</ranking>"
						+ "    <league>Ligue 1</league>"
						+ "  </Team>" 
						+ "  <Team>"
						+ "    <name>ASSE</name>"
						+ "    <ranking>2</ranking>"
						+ "    <league>Ligue 1</league>"
						+ "  </Team>" 
						+ "  <Team>"
						+ "    <name>OL</name>"
						+ "    <ranking>3</ranking>"
						+ "    <league>Ligue 1</league>"
						+ "  </Team>" 
						+ "</getAllTeamResponse>");

		mockWebServiceClient
			.sendRequest(withPayload(requestPayload))
			.andExpect(payload(expectedResponsePayload));
	}
}
