package com.vti.frontend;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {
		ManagerAccount managerAccount = new ManagerAccount();

////		Connection connection = JDCBUtil.getIntance().getConnection();
////		Statement statement = connection.createStatement();
//
//		String sqlQuery = "SELECT AccountID, Email, Username FROM Account Where AccountId = ? OR Username = ?";
//
//		PreparedStatement preparedSt = connection.prepareStatement(sqlQuery);
//
//		preparedSt.setInt(1, 0);
//		
//		System.out.println("Nhap vap US muon tim");
//		preparedSt.setString(1, ScannerUtil.scanStr());
//
//		ResultSet resultSet = JDCBUtil.getIntance().getStatement().executeQuery("SELECT * FROM Account")
////		ResultSet resultSet = preparedSt.executeQuery();
//
//		while (resultSet.next()) {
//			System.out.println(resultSet.getInt("AccountID") + ", " + resultSet.getString("Email") + ", "
//					+ resultSet.getString("Username"));
//			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//
//		}
//		connection.close();
	}
}
