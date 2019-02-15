package com.chainsys.movieapp;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDOA {
	
	public void addMovie(Movie movie) throws SQLException
	{
		Connection connection=ConnectionMovie.ConnectionTo();
		String sql="INSERT INTO MOVIE(movie_id,movie_name,movie_price,bookingdate) VALUES(?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, movie.id);
		preparedStatement.setString(2, movie.name);
		preparedStatement.setInt(3, movie.price);
		preparedStatement.setDate(4, movie.booking_date);
		preparedStatement.executeUpdate();
		
	}
	public void findById(Movie movie) throws SQLException{
		//boolean isFound=false;
		Connection connection=ConnectionMovie.ConnectionTo();
		String sql="SELECT movie_name FROM MOVIE where movie_id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, movie.id);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()){
//			isFound=true;
			System.out.println("The Movie Name \n"+resultSet.getString("movie_name"));
		}
//		else{
//			isFound=false;
//			System.out.println("Not found");}
//	return isFound;

}
	public void updateMovie(Movie movie) throws SQLException{
		Connection connection=ConnectionMovie.ConnectionTo();
		String sql = "update movie set movie_name=? where movie_id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, movie.name);
		preparedStatement.setInt(2, movie.id);
		preparedStatement.executeUpdate();
	}
	public void deleteMovie(Movie movie) throws SQLException{
		Connection connection=ConnectionMovie.ConnectionTo();
		String sql = "DELETE from movie where movie_id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, movie.id);
		preparedStatement.executeUpdate();
	}
	public ArrayList<Movie> findAll() throws SQLException{
		Connection connection=ConnectionMovie.ConnectionTo();
		String sql = "select movie_id,movie_name,movie_price from movie ORDER BY movie_name desc";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		ArrayList<Movie> result = new ArrayList<>();
		while(resultSet.next()){
			Movie movie = new Movie();
			movie.id = resultSet.getInt("movie_id");
			movie.name = resultSet.getString("movie_name");
			movie.price = resultSet.getInt("movie_price");
			result.add(movie);
			}
		return result;
	}
}

