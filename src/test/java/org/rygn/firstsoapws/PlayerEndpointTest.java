package org.rygn.firstsoapws;

import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;

import javax.xml.transform.Source;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

@SpringBootTest
public class PlayerEndpointTest {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	private MockWebServiceClient client;
	
	@BeforeEach
	public void createClient() throws Exception {
		client = MockWebServiceClient.createClient(applicationContext);
	}
	
	@Test
	public void playerUniqEndpoint() {
		Source requestPayload = new StringSource("<getPlayerRequest xmlns='http://spring.io/guides/gs-producing-web-service'>"
				+ "<name>Romain Hamouma</name>" + "</getPlayerRequest>");
		
		Source expectedResponsePayload = new StringSource(
				"<getPlayerResponse xmlns='http://spring.io/guides/gs-producing-web-service'>"
						+ "  <Player>"
						+ "    <name>Romain Hamouma</name>"
						+ "    <number>21</number>"
						+ "    <position>attacker</position>"
						+ "  </Player>" 
						+ "</getPlayerResponse>");

		client
			.sendRequest(withPayload(requestPayload))
			.andExpect(payload(expectedResponsePayload));
	}
	
	@Test
	public void allPlayerEndpoint() throws Exception {
		Source requestPayload = new StringSource("<getAllPlayerRequest xmlns='http://spring.io/guides/gs-producing-web-service'></getAllPlayerRequest>");
		
		Source expectedResponsePayload = new StringSource(
				"<getAllPlayerResponse xmlns='http://spring.io/guides/gs-producing-web-service'>"
						+ "  <Player>"
						+ "    <name>Memphis Depay</name>"
						+ "    <number>10</number>"
						+ "    <position>attacker</position>"
						+ "  </Player>" 
						+ "  <Player>"
						+ "    <name>Kylian Mbappé</name>"
						+ "    <number>10</number>"
						+ "    <position>attacker</position>"
						+ "  </Player>" 
						+ "  <Player>"
						+ "    <name>Romain Hamouma</name>"
						+ "    <number>21</number>"
						+ "    <position>attacker</position>"
						+ "  </Player>" 
						+ "</getAllPlayerResponse>");

		client
			.sendRequest(withPayload(requestPayload))
			.andExpect(payload(expectedResponsePayload));
	}
}