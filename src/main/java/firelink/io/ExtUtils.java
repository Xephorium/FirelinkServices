package firelink.io;

/*
  ExtUtils.java                                            08.07.2016

    Contains recognized file types for hosted media and corresponding
  extension retrieval/evaluation logic.

*/

import java.io.File;
import java.util.Arrays;


public class ExtUtils {


    /*--- Class Fields ---*/

    private final static String[] knownVideoExtensions = {"mkv", "mp4", "avi", "mov"};
    private final static String[] knownAudioExtensions = {"mp3"};


    /*--- Utility Methods ---*/

    public static boolean hasExtension(String fileName) {

        // Scan Backwards For '.' Denoting Extension Start
        int maxExtensionLength = 5;
        for(int x = (fileName.length() - 1); x > (fileName.length() - maxExtensionLength); x--) {
            if(fileName.charAt(x) == '.') {
                return true;
            }
        }

        // No Extension Available
        return false;
    }

    public static boolean hasExtension(File file) {

        // Scan Backwards For '.' Denoting Extension Start
        int maxExtensionLength = 5;
        for(int x = (file.toString().length() - 1); x > (file.toString().length() - maxExtensionLength); x--) {
            if(file.toString().charAt(x) == '.') {
                return true;
            }
        }

        // No Extension Available
        return false;
    }

    public static int getExtensionLength(String fileName) {

        // Scan Backwards For '.' Denoting Extension Start
        int maxExtensionLength = 5;
        for(int x = (fileName.length() - 1); x > (fileName.length() - maxExtensionLength); x--) {
            if(fileName.charAt(x) == '.') {
                return fileName.length() - (x + 1);
            }
        }

        // No Extension Available
        return 0;
    }

    public static int getExtensionLength(File file) {

        // Scan Backwards For '.' Denoting Extension Start
        int maxExtensionLength = 5;
        for(int x = (file.toString().length() - 1); x > (file.toString().length() - maxExtensionLength); x--) {
            if(file.toString().charAt(x) == '.') {
                return file.toString().length() - (x + 1);
            }
        }

        // No Extension Available
        return 0;
    }

    public static String getExtension(String fileName) {

        // Scan Backwards For '.' Denoting Extension Start
        int maxExtensionLength = 5;
        for(int x = (fileName.length() - 1); x > (fileName.length() - maxExtensionLength); x--) {
            if(fileName.charAt(x) == '.') {
                return fileName.substring(x + 1, fileName.length());
            }
        }

        // No Extension Available
        return "";
    }

    public static String getExtension(File file) {

        // Scan Backwards For '.' Denoting Extension Start
        int maxExtensionLength = 5;
        for(int x = (file.toString().length() - 1); x > (file.toString().length() - maxExtensionLength); x--) {
            if(file.toString().charAt(x) == '.') {
                return file.toString().substring(x + 1, file.toString().length());
            }
        }

        // No Extension Available
        return "";
    }

    public static boolean isVideoFile(String fileName) {

        // Determine If Extension A Known Video Extension
        if((Arrays.asList(getKnownVideoExtensions())).contains(getExtension(fileName)))
            return true;
        else
            return false;

    }

    public static boolean isVideoFile(File file) {

        // Determine If Extension A Known Video Extension
        if((Arrays.asList(getKnownVideoExtensions())).contains(getExtension(file.toString())))
            return true;
        else
            return false;

    }

    public static boolean isAudioFile(String fileName) {

        // Determine If Extension A Known Video Extension
        if((Arrays.asList(getKnownAudioExtensions())).contains(getExtension(fileName)))
            return true;
        else
            return false;
    }

    public static boolean isAudioFile(File file) {

        // Determine If Extension A Known Video Extension
        if((Arrays.asList(getKnownAudioExtensions())).contains(getExtension(file.toString())))
            return true;
        else
            return false;
    }

    public static String removeExtension(String fileName) {
        return fileName.substring(0, fileName.length() - (getExtensionLength(fileName) + 1));
    }

    public static String removeExtension(File file) {
        return file.getName().substring(0, file.getName().length() - (getExtensionLength(file.getName()) + 1));
    }


    /*--- Getters & Setters ---*/

    public static String[] getKnownVideoExtensions() {
        return knownVideoExtensions;
    }

    public static String[] getKnownAudioExtensions() {
        return knownAudioExtensions;
    }

}
