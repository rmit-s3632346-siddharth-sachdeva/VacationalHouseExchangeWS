package webservices;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.Constants;
import model.BookHouseModel;
import model.LoginModel;

public class BookHouseService {
	String statusCode;
	BookHouseModel bookHouseModel = new BookHouseModel();
	final static Logger logger = Logger.getLogger(BookHouseService.class);
	@POST
	public Response bookHouse(String request) {
		JSONObject responseObject = null;
		try {
			JSONObject requestObject = new JSONObject();
			JSONParser parser = new JSONParser();
			requestObject = (JSONObject) parser.parse(request);
			String ownerEmailId = requestObject.get(Constants.OWNER_EMAIL).toString();
			String requesterEmailId = requestObject.get(Constants.REQUESTER_EMAIL).toString();
			statusCode = bookHouseModel.bookHouseModel(ownerEmailId, requesterEmailId);
			responseObject = new JSONObject();
			responseObject.put(Constants.statusCode, statusCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			statusCode = "1";
		}
		return Response.ok().entity(responseObject.toJSONString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
		
	}
}
