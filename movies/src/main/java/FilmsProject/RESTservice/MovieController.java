package FilmsProject.RESTservice;

import FilmsProject.Interfaces.FilmService;
import FilmsProject.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/movie")
@Consumes("application/json")
@Produces("application/json")
@Component
public class MovieController {

     @Autowired
     private FilmService filmService;

     @Autowired
     private UserService userService;

     @GET
     @Path("/{id}")
     public Object[] getById(@PathParam("id") String id) {
        return filmService.getFilmDetails(id);
     }

     //Test data: http://localhost:8081/webapp/movie/addReview?filmIdentifier=326&reviewText=GoodFilm&rating=8.9
//     @PUT
//     @Path("/addReview")
//     public boolean addReview(@FormParam("filmIdentifier") String filmIdentifier,
//                              @FormParam("reviewText") String reviewText, @FormParam("rating") double rating) {
//          return userService.writeReview(null,filmIdentifier,reviewText,rating);
//     }

     @POST
     @Path("/post")
     public Response createTrackInJSON( @QueryParam("name") String name) {

          String result = "Name : " + name;
          return Response.status(201).entity(result).build();
     }


}
