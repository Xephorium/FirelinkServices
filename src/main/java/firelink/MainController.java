package firelink;

import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;

import firelink.io.*;
import firelink.model.*;
import firelink.request.*;


@RestController
public class MainController {

    /*--- Class Fields ---*/

    private static final String DEFAULT_WELCOME = "Welcome to Firelink!";
    private final AtomicLong counter = new AtomicLong();


    /*--- Mapped GET Methods ---*/

    @RequestMapping(value="/firelink", method = RequestMethod.GET)
    public String getWelcomeMessage(@RequestParam(value="name", defaultValue="") String name) {

        String welcomeString;

        if (name.equals(""))
            welcomeString = DEFAULT_WELCOME;
        else
            welcomeString = "Welcome to Firelink, " + name + "!";

        return welcomeString;
    }

    @RequestMapping(value="/firelink/movies", method = RequestMethod.GET)
    public ArrayList<Movie> getMovieList() {
        return MediaReader.getMovieList();
    }

    @RequestMapping(value="/firelink/shows", method = RequestMethod.GET)
    public ArrayList<String> getShowList() {
        return MediaReader.getShowNames();
    }


    /*--- Mapped POST Methods ---*/

    @RequestMapping(value="/firelink/movieinfo", method = RequestMethod.POST)
    public Object getMovie(@RequestBody MovieInfoRequest request) {
        Movie movie = MediaReader.getMovieDetails(request.getMovieName());
        if (movie == null)
            return new RequestError(RequestError.ErrorType.MOVIE_NOT_FOUND);
        else
            return movie;
    }

    @RequestMapping(value="/firelink/test", method = RequestMethod.GET)
    public Object getTestResults() {
        return MediaReader.getMovieSubtitleNames();
    }
}