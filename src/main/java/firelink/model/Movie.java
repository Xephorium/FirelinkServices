package firelink.model;

/*
  Movie.java                                 08.09.2016

    An object of this class represents one Movie object
  complete with all relevant metadata.

*/

import firelink.io.ExtUtils;
import java.io.File;


public class Movie {


    /*--- Class Fields ---*/

    private static final int DEFAULT_LENGTH = -1;
    private String name;
    private String extension;
    // private int    length;


    /*--- Constructors ---*/

    public Movie() {
        name      = null;
        extension = null;
        // length    = DEFAULT_LENGTH;
    }

    public Movie(String movieName) {
        name      = movieName;
        extension = null;
        // length    = DEFAULT_LENGTH;
    }

    public Movie(File movieFile) {
        name      = getNameFromFile(movieFile);
        extension = ExtUtils.getExtension(movieFile);
        // length    = getLengthFromFile(movieFile);
    }


    /*--- Utility Methods ---*/

    public static String getNameFromFile(File movieFile) {

        // Scan Backwards For '/' Denoting Name Start
        for(int x = (movieFile.toString().length() - 1); x > 0; x--) {
            if(movieFile.toString().charAt(x) == '/') {

                // Return Movie Name Without Path or Extension
                return movieFile.toString().substring(x + 1, (movieFile.toString().length() - (ExtUtils.getExtensionLength(movieFile) + 1)));
            }
        }

        return null;
    }

    private int getLengthFromFile(File movieFile) {


        return DEFAULT_LENGTH;
    }


    /*--- Setters & Getters ---*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    // public int getLength() {
    //     return length;
    // }

    // public void setLength(int length) {
    //     this.length = length;
    // }

}
