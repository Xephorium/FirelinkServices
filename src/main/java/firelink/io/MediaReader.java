package firelink.io;

/*
  MediaReader.java                                   08.07.2016

    Manages reading of media & document files for returned json.
  Writing will be managed by another class.

*/

import firelink.model.Movie;
import java.io.File;
import java.util.ArrayList;


public class MediaReader {


    /*--- Class Fields ---*/

    private static final String BONFIRE_DIRECTORY = "/home/solaire/Documents/Bonfire";
    private static final String DOCUMENTS_DIRECTORY = BONFIRE_DIRECTORY + "/Documents";
    private static final String GAMES_DIRECTORY = BONFIRE_DIRECTORY + "/Games";
    private static final String MOVIES_DIRECTORY = BONFIRE_DIRECTORY + "/Movies";
    private static final String SHOWS_DIRECTORY = BONFIRE_DIRECTORY + "/Shows";


    /*--- Movie Methods ---*/

    // Returns Unsorted List of Movie Names
    public static ArrayList<String> getMovieNames() {

        File[] videoFiles = getVideoFiles(getDirectoryContents(MOVIES_DIRECTORY));
        ArrayList<String> movieNames = new ArrayList<String>();

        for(int x = 0; x < videoFiles.length; x++) {
            movieNames.add(Movie.getNameFromFile(videoFiles[x]));
        }
        return movieNames;
    }

    // Returns Unsorted List of Movie Objects
    public static ArrayList<Movie> getMovieData() {

        File[] videoFiles = getVideoFiles(getDirectoryContents(MOVIES_DIRECTORY));
        ArrayList<Movie> movieData = new ArrayList<Movie>();

        for(int x = 0; x < videoFiles.length; x++) {
            movieData.add(new Movie(videoFiles[x]));
        }
        return movieData;
    }


    /*--- Show Methods ---*/

    public static ArrayList<String> getShowNames() {

        // Get Files in Directory
        File[] showList = getDirectoryContents(SHOWS_DIRECTORY);

        // Convert To ArrayList of Strings without Path
        ArrayList<String> shows = new ArrayList<String>();
        for(int x = 0; x < showList.length; x++) {

                // Return Show Name Without Path
                shows.add(showList[x].toString().substring(
                        MOVIES_DIRECTORY.length(),
                        showList[x].toString().length()));
        }

        // Return Movie Names
        return shows;
    }



    /*--- Utility Methods ---*/

    // Returns Contents of Specified Directory
    public static File[] getDirectoryContents(String directory) {
        return new File(directory).listFiles();
    }

    // Returns Only Files With Extensions (Removes Directories)
    public static File[] getValidFiles(File[] dirContents) {

        ArrayList<File> files = new ArrayList<File>();
        for(int x = 0; x < dirContents.length; x++) {
            if(ExtUtils.hasExtension(dirContents[x])) {
                files.add(dirContents[x]);
            }
        }

        return files.toArray(new File[files.size()]);
    }

    // Returns Only Recognized Video Files
    public static File[] getVideoFiles(File[] files) {

        ArrayList<File> videos = new ArrayList<File>();
        for(int x = 0; x < files.length; x++) {
            if(ExtUtils.isVideoFile(files[x])) {
                videos.add(files[x]);
            }
        }

        return videos.toArray(new File[videos.size()]);
    }


    /*--- Setters & Getters ---*/

    public static String getBonfireDirectory() {
        return BONFIRE_DIRECTORY;
    }

    public static String getDocumentsDirectory() {
        return DOCUMENTS_DIRECTORY;
    }

    public static String getGamesDirectory() {
        return GAMES_DIRECTORY;
    }

    public static String getMoviesDirectory() {
        return MOVIES_DIRECTORY;
    }

    public static String getShowsDirectory() {
        return SHOWS_DIRECTORY;
    }
}
