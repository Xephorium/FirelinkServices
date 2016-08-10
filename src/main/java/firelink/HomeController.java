package firelink;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import firelink.io.MediaReader;
import firelink.model.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {


    /*--- Class Fields ---*/

    private static final String DEFAULT_WELCOME = "Welcome to Firelink!";
    private final AtomicLong counter = new AtomicLong();


    /*--- Mapping Methods ---*/

    @RequestMapping("/home")
    public String getWelcomeMessage(@RequestParam(value="name", defaultValue="") String name) {

        String welcomeString;

        if (name.equals(""))
            welcomeString = DEFAULT_WELCOME;
        else
            welcomeString = "Welcome to Firelink, " + name + "!";

        return welcomeString;
    }

    @RequestMapping("/movies")
    public ArrayList<Movie> getMovieList() {
        return MediaReader.getMovieData();
    }

    @RequestMapping("/shows")
    public ArrayList<String> getShowList() {
        return MediaReader.getShowNames();
    }

}