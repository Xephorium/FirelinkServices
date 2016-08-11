![alt text][logo]FirelinkServices
===
A simple suite of spring boot services.

[logo]: https://github.com/Xephorium/FirelinkServices/blob/master/img/icon_transparent_small.png "Logo"

#### Local Setup
  1. Install Maven \(Link [here](https://maven.apache.org/download.cgi)\)
  2. Clone me!
  3. Open project in your favorite IDE \(IntelliJ 4ever :heart:\)
  4. Run `mvn dependency:resolve` in project directory
  5. Start service locally with `mvn spring-boot:run` ...Or!
  6. Compile .jar with `mvn clean package` and run on target machine with `java -jar compiled_file.jar`

#### Active Links
```
// Note: Server directories are currently hardcoded. Services won't
// return valid json unless given a valid path containing files.
         
localhost:8080/home?name=YourNameHere
localhost:8080/movies
localhost:8080/shows
```

#### To Do
- [X] Get Project Running
- [X] Build Out Movie Model & IO Classes
- [ ] Implement User Authentication
- [ ] Read Video File Metadata
- [ ] Accept Incoming Requests (Change & Move Files)
