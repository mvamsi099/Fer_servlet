package com.rs.fer.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FerService {

	@Override
	public boolean registration(User user) {
		boolean isRegister = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		// create register the class driver
		try {
			connection = DBUtil.getconnection();

			// create the statement object
			String query = "INSERT INTO USER(Firstname,Middlename,Lastname,Email,Username,Password,Mobile) VALUES (?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);

			// setting the values into the question mark
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getMiddleName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getMobile());

			// execute the statement
			int nameRecAffected = preparedStatement.executeUpdate();

			if (nameRecAffected > 0) {

				isRegister = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DBUtil.closeconnection(connection);
		}

		return isRegister;
	}

	@Override
	public boolean addExpense(Expense expense) {

		boolean isAddExpense = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// create register the class driver
		try {

			connection = DBUtil.getconnection();

			// create the statement object
			String query = "INSERT INTO expense (Type,Date,price,Numberofitems,Total,Bywhom,userid) VALUES (?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);

			// setting the values into the question mark
			preparedStatement.setString(1, expense.getType());
			preparedStatement.setString(2, expense.getDate());
			preparedStatement.setFloat(3, expense.getNumberofitems());
			preparedStatement.setInt(4, expense.getNumberofitems());
			preparedStatement.setFloat(5, expense.getTotal());
			preparedStatement.setString(6, expense.getBywhom());
			preparedStatement.setInt(7, expense.getUserid());

			// execute the statement
			int nameRecAffected = preparedStatement.executeUpdate();

			if (nameRecAffected > 0) {
				isAddExpense = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DBUtil.closeconnection(connection);

		}

		return isAddExpense;
	}

	@Override
	public boolean editExpense(Expense expense) {

		boolean isEditExpense = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// create register the class driver
		try {

			connection = DBUtil.getconnection();

			// create the statement object
			String query = "UPDATE expense SET Type=?,Date=?,price=?,Numberofitems=?,Total=?,Bywhom=? WHERE id=?";
			preparedStatement = connection.prepareStatement(query);

			// setting the values into the question mark
			preparedStatement.setString(1, expense.getType());
			preparedStatement.setString(2, expense.getDate());
			preparedStatement.setFloat(3, expense.getNumberofitems());
			preparedStatement.setInt(4, expense.getNumberofitems());
			preparedStatement.setFloat(5, expense.getTotal());
			preparedStatement.setString(6, expense.getBywhom());
			preparedStatement.setInt(7, expense.getId());

			// execute the statement
			int nameRecAffected = preparedStatement.executeUpdate();

			if (nameRecAffected > 0) {

				isEditExpense = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DBUtil.closeconnection(connection);

		}

		return isEditExpense;
	}

	@Override
	public boolean deleteExpense(int expenseId) {
		boolean isDeleteExpense = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// create register the class driver
		try {

			connection = DBUtil.getconnection();

			// create the statement object
			String query = "DELETE FROM expense WHERE id=?";
			preparedStatement = connection.prepareStatement(query);

			// setting the values into the question mark
			preparedStatement.setInt(1, expenseId);

			// execute the statement
			int nameRecAffected = preparedStatement.executeUpdate();

			if (nameRecAffected > 0) {

				isDeleteExpense = true;

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DBUtil.closeconnection(connection);

		}

		return isDeleteExpense;
	}

	@Override
	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
		boolean isResetPassword = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// create register the class driver
		try {

			connection = DBUtil.getconnection();

			// create the statement object
			String query = "UPDATE USER SET password=? WHERE id=? and password=?";
			preparedStatement = connection.prepareStatement(query);

			// setting the values into the question mark
			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, userId);
			preparedStatement.setString(3, currentPassword);

			// execute the statement
			int nameRecAffected = preparedStatement.executeUpdate();

			if (nameRecAffected > 0) {

				isResetPassword = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DBUtil.closeconnection(connection);

		}

		return isResetPassword;
	}

	@Override
	public int login(String username, String Password) {
		int userId =0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// create register the class driver
		try {

			connection = DBUtil.getconnection();

			// create the statement object
			String query = "SELECT * FROM USER WHERE username=? and password=?";
			preparedStatement = connection.prepareStatement(query);

			// setting the values
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, Password);
			// execute the statement
			ResultSet resultSet = preparedStatement.executeQuery();
			// Processing the statement

			System.out.println(resultSet);

			while (resultSet.next()) {

				userId = resultSet.getInt(1);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBUtil.closeconnection(connection);
		}

		return userId;
	}

	@Override
	public List<Expense> getExpenseOptions(int userId) {

		List<Expense> expenseOptions = new ArrayList<>();
		Expense expense = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// create register the class driver
		try {

			connection = DBUtil.getconnection();

			// create the statement object
			String query = "SELECT * FROM expense WHERE userid=?";
			preparedStatement = connection.prepareStatement(query);

			// setting the values
			preparedStatement.setInt(1, userId);
			// execute the statement
			ResultSet resultSet = preparedStatement.executeQuery();
			// Processing the statement

			System.out.println(resultSet);

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String Type = resultSet.getString(2);
				String Date = resultSet.getString(3);
				Float Price = resultSet.getFloat(4);
				int Numberofitems = resultSet.getInt(5);
				Float Total = resultSet.getFloat(6);
				String Bywhom = resultSet.getString(7);
				int Userid = resultSet.getInt(8);

				// loading the column data into the object
				expense = new Expense();

				expense.setId(id);
				expense.setType(Type);
				expense.setDate(Date);
				expense.setPrice(Price);
				expense.setNumberofitems(Numberofitems);
				expense.setTotal(Total);
				expense.setBywhom(Bywhom);
				expense.setUserid(Userid);

				// add the expense object to the expense option(collection) object
				expenseOptions.add(expense);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DBUtil.closeconnection(connection);
		}

		return expenseOptions;
	}

	@Override
	public List<Expense> getExpenseReport(int userid, String expensetype, String fromDate, String toDate) {

		List<Expense> expenses = new ArrayList<>();
		Expense expense = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// create register the class driver
		try {

			connection = DBUtil.getconnection();

			// create the statement object
			String query = "SELECT * FROM expense WHERE userid=? and Type=? and Date BETWEEN ? and ?";
			preparedStatement = connection.prepareStatement(query);

			// setting the values
			preparedStatement.setInt(1, userid);
			preparedStatement.setString(2, expensetype);
			preparedStatement.setString(3, fromDate);
			preparedStatement.setString(4, toDate);

			// execute the statement
			ResultSet resultSet = preparedStatement.executeQuery();
			// Processing the statement

			System.out.println(resultSet);

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String Type = resultSet.getString(2);
				String Date = resultSet.getString(3);
				Float Price = resultSet.getFloat(4);
				int Numberofitems = resultSet.getInt(5);
				Float Total = resultSet.getFloat(6);
				String Bywhom = resultSet.getString(7);
				int Userid = resultSet.getInt(8);

				// loading the column data into the object
				expense = new Expense();

				expense.setId(id);
				expense.setType(Type);
				expense.setDate(Date);
				expense.setPrice(Price);
				expense.setNumberofitems(Numberofitems);
				expense.setTotal(Total);
				expense.setBywhom(Bywhom);
				expense.setUserid(Userid);

				// add the expense object to the expense option(collection) object
				expenses.add(expense);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DBUtil.closeconnection(connection);
		}

		return expenses;

	}

	@Override
	public Expense getExpense(int expenseId) {
		Expense expense = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// create register the class driver
		try {

			connection = DBUtil.getconnection();

			// create the statement object
			String query = "SELECT * FROM expense WHERE Id=?";
			preparedStatement = connection.prepareStatement(query);

			// setting the values
			preparedStatement.setInt(1, expenseId);

			// execute the statement
			ResultSet resultSet = preparedStatement.executeQuery();
			// Processing the statement

			System.out.println(resultSet);

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String Type = resultSet.getString(2);
				String Date = resultSet.getString(3);
				Float Price = resultSet.getFloat(4);
				int Numberofitems = resultSet.getInt(5);
				Float Total = resultSet.getFloat(6);
				String Bywhom = resultSet.getString(7);
				int Userid = resultSet.getInt(8);

				// loading the column data into the object
				expense = new Expense();

				expense.setId(id);
				expense.setType(Type);
				expense.setDate(Date);
				expense.setPrice(Price);
				expense.setNumberofitems(Numberofitems);
				expense.setTotal(Total);
				expense.setBywhom(Bywhom);
				expense.setUserid(Userid);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DBUtil.closeconnection(connection);
		}

		return expense;

	}

	@Override
	public User getUser(int userid) {
		User user = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// create register the class driver
		try {

			connection = DBUtil.getconnection();

			// create the statement object
			String query = "SELECT U.*,A.* FROM USER U LEFT JOIN address A on U.id = A.userid WHERE U.id=?";
			preparedStatement = connection.prepareStatement(query);

			// setting the values
			preparedStatement.setInt(1, userid);
			// execute the statement
			ResultSet resultSet = preparedStatement.executeQuery();
			// Processing the statement

			System.out.println(resultSet);

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String FirstName = resultSet.getString(2);
				String MiddleName = resultSet.getString(3);
				String LastName = resultSet.getString(4);
				String Email = resultSet.getString(5);
				String Username = resultSet.getString(6);
				String Password = resultSet.getString(7);
				String Mobile = resultSet.getString(8);

				// Load the user column dat into user object
				user = new User();
				user.setId(id);
				user.setFirstName(FirstName);
				user.setMiddleName(MiddleName);
				user.setLastName(LastName);
				user.setEmail(Email);
				user.setUsername(Username);
				user.setPassword(Password);
				user.setMobile(Mobile);

				int addrid = resultSet.getInt(9);
				String Line1 = resultSet.getString(10);
				String Line2 = resultSet.getString(11);
				String City = resultSet.getString(12);
				String State = resultSet.getString(13);
				String Pincode = resultSet.getString(14);
				String Country = resultSet.getString(15);
				int userId = resultSet.getInt(16);

				// load the address column data into address object
				Address address = new Address();
				address.setId(addrid);
				address.setLine1(Line1);
				address.setLine2(Line2);
				address.setCity(City);
				address.setState(State);
				address.setPincode(Pincode);
				address.setCountry(Country);
				address.setUserid(userid);

				// set address object into the userId
				user.setaddress(address);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DBUtil.closeconnection(connection);
		}

		return user;
	}

	@Override
	public boolean updateUser(User user) {

		boolean isUserUpdate = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// create register the class driver
		try {

			connection = DBUtil.getconnection();

			// create the statement object
			String query = "UPDATE USER SET Firstname=?,Middlename=?,Lastname=?,Email=?,Mobile=? WHERE ID=?";
			preparedStatement = connection.prepareStatement(query);

			// setting the values into the question mark
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getMiddleName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getMobile());
			preparedStatement.setInt(6, user.getId());

			// execute the statement
			int nameRecAffected = preparedStatement.executeUpdate();

			if (nameRecAffected < 0) {

				System.out.println("User profile Update is failed");

			} else {

				Address address = user.getAddress();
				int addressid = address.getId();

				if (addressid == 0) {

					// insert into the address
					query = "INSERT INTO address (Line1,Line2,City,State,Pincode,Country,userid) VALUES (?,?,?,?,?,?,?)";
					preparedStatement = connection.prepareStatement(query);

					preparedStatement.setString(1, address.getLine1());
					preparedStatement.setString(2, address.getLine2());
					preparedStatement.setString(3, address.getCity());
					preparedStatement.setString(4, address.getState());
					preparedStatement.setString(5, address.getPincode());
					preparedStatement.setString(6, address.getCountry());
					preparedStatement.setInt(7, address.getUserid());

					nameRecAffected = preparedStatement.executeUpdate();

					if (nameRecAffected > 0) {

						isUserUpdate = true;
						System.out.println("Address saved successfully....!");

					}
				} else {

					// create the statement object
					query = "UPDATE address SET Line1=?, Line2=?, City=?, State=?, Pincode=?, Country=? WHERE ID=?";
					preparedStatement = connection.prepareStatement(query);

					// setting the values into the question mark
					preparedStatement.setString(1, address.getLine1());
					preparedStatement.setString(2, address.getLine2());
					preparedStatement.setString(3, address.getCity());
					preparedStatement.setString(4, address.getState());
					preparedStatement.setString(5, address.getPincode());
					preparedStatement.setString(6, address.getCountry());
					preparedStatement.setInt(7, addressid);

					nameRecAffected = preparedStatement.executeUpdate();

					if (nameRecAffected > 0) {

						isUserUpdate = true;

						System.out.println("Address update sccessfully......!");

					}

				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			DBUtil.closeconnection(connection);
		}

		return isUserUpdate;
	}

}
