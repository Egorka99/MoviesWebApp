package FilmsProject.RESTservice;

import FilmsProject.Interfaces.FilmService;
import FilmsProject.Interfaces.UserService;
import FilmsProject.Model.User;
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

     //Test data: http://localhost:8081/webapp/movie/addReview?filmIdentifier=326&reviewText=GoodFilm&rating=8.6
     @POST
     @Path("/addReview")
     public Response addReview(@QueryParam("filmIdentifier") String filmIdentifier,
                               @QueryParam("reviewText") String reviewText, @QueryParam("rating") double rating) {
          User user = new User();

          if (userService.writeReview(user,filmIdentifier,reviewText,rating)) {
               return Response
                       .status(Response.Status.OK)
                       .entity("Отзыв успешно добавлен!")
                       .build();
          }

          return Response
                  .status(Response.Status.INTERNAL_SERVER_ERROR)
                  .entity("Не удалось добавить отзыв")
                  .build();
     }



}
