package com.chainsys.movieapp;

import java.sql.Date;
import java.sql.SQLException;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieAppTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		MovieDOA movieDOA=new MovieDOA();
		Movie movie=new Movie();
		MovieValidation movieValidation=new MovieValidation();
		
		int reuse;
		String date;
		do{
		System.out.println("BookMyShow Presents You");
		System.out.println("\n1)Add Movie 2)FindAll 3)Delete Movie 4)update movie 5)FindById");
		int n=scanner.nextInt();
		switch(n)
		{
		case 1:
			System.out.println("Enter the Id,Name and Price");
			movie.id=scanner.nextInt();
			movie.name=scanner.next();
			movie.price=scanner.nextInt();
			date=scanner.next();
			//movie.booking_date=LocalDate.parse(date);
			movie.booking_date=Date.valueOf(date);
			try {
				movieValidation.validationAdd(movie);
				movieDOA.addMovie(movie);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case 2:
			System.out.println("All the records are Displayed");
			ArrayList<Movie> results = movieDOA.findAll();
			for(Movie res : results)
			{
				System.out.println(res.id);
				System.out.println(res.name);
				System.out.println(res.price);


				
			}
			break;
		case 3:
			System.out.println("Enter Id number to Delete");
			movie.id=scanner.nextInt();
			try {
				movieValidation.validationDelete(movie);
				movieDOA.deleteMovie(movie);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case 4:
			System.out.println("Enter Id to select field");
			movie.id=scanner.nextInt();
			System.out.println("Enter movie name to change");
			movie.name=scanner.next();
			try {
				movieValidation.validationUpdate(movie);
				movieDOA.updateMovie(movie);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case 5:
			System.out.println("Enter the id number to View specific row");
			movie.id=scanner.nextInt();
			try {
				movieValidation.validationFindId(movie);
				movieDOA.findById(movie);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		System.out.println("To continue enter 1 else any key to exist");
		reuse=scanner.nextInt();
	}while(reuse==1);
		scanner.close();
	}
}
