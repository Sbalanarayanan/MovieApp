package com.chainsys.movieapp;

public class MovieValidation {
	public void validationAdd(Movie movie) throws Exception{
		if(movie.id<=0)
			throw new Exception("The Id should above 0");
		if(movie.price<=0)
			throw new Exception("The price should above 0");
		if(movie.name==null)
			throw new Exception("the name should not be null");
	}
	public void validationUpdate(Movie movie) throws Exception{
		if(movie.id<=0)
			throw new Exception("The Id should above 0");
		if(movie.name==null)
			throw new Exception("the name should not be null");
	}
	public void validationDelete(Movie movie) throws Exception{
		if(movie.id<=0)
			throw new Exception("The Id should above 0");
	}
	public void validationFindId(Movie movie) throws Exception{
		if(movie.id<=0)
			throw new Exception("The Id should above 0");
	}
}
