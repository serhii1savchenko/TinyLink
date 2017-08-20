package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Link;

public class LinkDAO {

	private static final String getByOriginalLink 		= "SELECT * FROM links WHERE original = ?";
	private static final String getByShortLink 			= "SELECT * FROM links WHERE short = ?";
	private static final String addLink 				= "INSERT INTO links (original, short) VALUES (?, ?)";

	public static boolean isOriginalLinkInDB (String original){

		Connection con = utils.DBConnection.getConnection();
		PreparedStatement prepared_stmt;

		ResultSet res = null;

		try {
			prepared_stmt = con.prepareStatement(getByOriginalLink);
			prepared_stmt.setString(1, original);
			res = prepared_stmt.executeQuery();	 
			if(res.next()){
				con.close();
				return true;
			}
			else {
				con.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public static boolean isShortLinkInDB(String shortLink){

		Connection con = utils.DBConnection.getConnection();
		PreparedStatement prepared_stmt;

		ResultSet res = null;

		try {
			prepared_stmt = con.prepareStatement(getByShortLink);
			prepared_stmt.setString(1, shortLink);
			res = prepared_stmt.executeQuery();	 
			if(res.next()){
				con.close();
				return true;
			}
			else {
				con.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static Link getByOriginal(String originalLink){

		Link result = new Link();

		Connection con = utils.DBConnection.getConnection();
		PreparedStatement prepared_stmt;

		ResultSet res = null;

		try {
			prepared_stmt = con.prepareStatement(getByOriginalLink);
			prepared_stmt.setString(1, originalLink);
			res = prepared_stmt.executeQuery();	 
			if (res.next()) {
				result.setId(res.getInt("id"));
				result.setOriginalLink(res.getString("original"));
				result.setShortLink(res.getString("short"));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static Link getByShort(String shortLink){

		Link result = new Link();

		Connection con = utils.DBConnection.getConnection();
		PreparedStatement prepared_stmt;

		ResultSet res = null;

		try {
			prepared_stmt = con.prepareStatement(getByShortLink);
			prepared_stmt.setString(1, shortLink);
			res = prepared_stmt.executeQuery();	 
			if (res.next()) {
				result.setId(res.getInt("id"));
				result.setOriginalLink(res.getString("original"));
				result.setShortLink(res.getString("short"));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void add(Link link){

		Connection con = utils.DBConnection.getConnection();
		PreparedStatement prepared_stmt;

		try {
			prepared_stmt = con.prepareStatement(addLink);
			prepared_stmt.setString(1, link.getOriginalLink());
			prepared_stmt.setString(2, link.getShortLink());

			prepared_stmt.executeUpdate();	

			prepared_stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}