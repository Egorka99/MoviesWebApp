package FilmsProject.RESTservice;

import FilmsProject.Interfaces.FilmService;
import FilmsProject.Interfaces.UserService;
import FilmsProject.Model.Film;
import FilmsProject.Model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.*;
import java.util.List;

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

     @POST
     @Path("/{id}/addReview")
     public boolean addReview(@String filmIdentifier,String reviewText,double rating) {
          return userService.writeReview(null,filmIdentifier,reviewText,rating);
     }


}
