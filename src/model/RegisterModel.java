package model;

import database.DBOperations;

public class RegisterModel {
	String statusCode = "1";
	DBOperations dbOperations = new DBOperations();
	String response = null, sqlQuery = "";

	public String register(String username, String password, String emailId, String phoneNo) {

		sqlQuery = "insert into User (username, password, emailId, phoneNo) values ('" + username + "','" + password
				+ "','" + emailId + "'," + phoneNo + ")";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}

	public String registerHouseDetails(String emailId, String address, String city, String suburb, String distance,
			String publicTransport, String noOfRooms, String airConditioning, String swimmingPool, String points,
			String discounts) {

		sqlQuery = "Insert into House_Details (email_id, address, city, suburb, distance_from_city, public_transport, "
				+ "no_of_rooms, airconditioning, swiming_pool, points_required, discounts) values ('" + emailId + "','"
				+ address + "','" + city + "','" + suburb + "','" + distance + "','" + publicTransport + "','"
				+ noOfRooms + "','" + airConditioning + "','" + swimmingPool + "','" + points + "','" + discounts
				+ "')";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}

	public String paymentDetails(String emailId, String cardNo, String amount) {
		sqlQuery = "Insert into Payment_Details (emailId, cardNo, amount) values ('" + emailId + "','" + cardNo + "','"
				+ amount + "')";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}

	public String settingAvailability(String emailId) {
		sqlQuery = "Insert into Letting_User_House (emailId, availableFrom, availableTo, minOccupierRating) values ('"
				+ emailId + "','','','')";
		int resultSet = dbOperations.updateData(sqlQuery);

		if (resultSet == 0)
			statusCode = "1";
		else
			statusCode = "0";

		return statusCode;
	}

}
