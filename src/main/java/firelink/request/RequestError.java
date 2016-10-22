package firelink.request;

/*
  RequestError.java                            10.22.2016

    An object of this class represents one error specific
  to the request provided.

*/


public class RequestError {


    /*--- Class Fields ---*/

    public enum ErrorType {
        MOVIE_NOT_FOUND
    }

    private ErrorType errorType;
    private String errorMessage;


    /*--- Constructors ---*/

    public RequestError(ErrorType error) {
        errorType = error;
        errorMessage = setErrorMessage(error);
    }


    /*--- Utility Methods ---*/

    public static String setErrorMessage(ErrorType error) {

        switch (error) {
            case MOVIE_NOT_FOUND:
                return "The movie you searched was not found.";
            default:
                return "Your request format contains an error.";
        }
    }


    /*--- Getters ---*/

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
