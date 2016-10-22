package firelink.request;

/*
  MovieInfoRequest.java                         10.22.2016

    An object of this class represents one JSON movie info
  request with appropriately mapped fields.

*/

public class MovieInfoRequest {


    /*--- Class Fields ---*/

    private String movieName;


    /*--- Constructors ---*/

    public MovieInfoRequest() {
        movieName = null;
    }

    public MovieInfoRequest(String movieName) {
        this.movieName = movieName;
    }


    /*--- Setters & Getters ---*/

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

}
