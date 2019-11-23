package FilmsProject.RESTservice;

import FilmsProject.Interfaces.AdminService;
import FilmsProject.Interfaces.FilmService;
import FilmsProject.Interfaces.UserService;
import FilmsProject.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/movie")
@Consumes("application/json")
@Produces("application/json")
@Component
public class RestController {

     @Autowired
     private FilmService filmService;

     @Autowired
     private UserService userService;

     @Autowired
     private AdminService adminService;

     @Autowired
     private Admin admin;

     @GET
     @Path("/{id}")
     public Object[] getById(@PathParam("id") String id) {
        return filmService.getFilmDetails(id);
     }

     @GET
     @Path("/search")
     public List<Film> searchFilm(@QueryParam("property") SearchProperty property, @QueryParam("value") String value) {
        return filmService.searchFilmsByProperty(property,value);
     }

    @GET
    @Path("/search/range")
    public List<Film> searchFilm(@QueryParam("property") SearchInRangeProperty property, @QueryParam("from") String from, @QueryParam("to") String to) {
        return filmService.searchFilmsInRange(property,from,to);
    }

    @GET
    @Path("/genre")
    public List<Genre> getGenres() {
         return filmService.searchAllGenres();
    }

    // Test request: http://localhost:8081/webapp/movie/46483/review?authorLogin=user123&reviewText=Legend!&rating=9.1
     @POST
     @Path("/{id}/review")
     public Response addReview(@PathParam("id") String id, @QueryParam("authorLogin") String authorLogin,
                               @QueryParam("reviewText") String reviewText, @QueryParam("rating") double rating) {

          if (userService.writeReview(authorLogin,id,reviewText,rating)) {
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


     //Test request: http://localhost:8081/webapp/movie/review?filmIdentifier=326&reviewId=418&reviewText=update&rating=8.4
     @POST
     @Path("/review")
     public Response updateReview( @QueryParam("filmIdentifier") String filmIdentifier,
                                   @QueryParam("reviewId") Long currentReviewId,
                                   @QueryParam("reviewText") String reviewText,
                                   @QueryParam("rating") double rating)
     {
         if (userService.updateReview(filmIdentifier,currentReviewId,reviewText,rating)) {
             return Response
                     .status(Response.Status.OK)
                     .entity("Отзыв успешно изменен!")
                     .build();
         }

         return Response
                 .status(Response.Status.INTERNAL_SERVER_ERROR)
                 .entity("Не удалось изменить отзыв")
                 .build();

     }

    // Test request: http://localhost:8081/webapp/movie/review/450
     @DELETE
     @Path("/review/{id}")
     public Response deleteReview(@PathParam("id") Long reviewId) {
         if (adminService.deleteReview(admin,reviewId)) {
             return Response
                     .status(Response.Status.OK)
                     .entity("Отзыв успешно удален!")
                     .build();
         }

         return Response
                 .status(Response.Status.INTERNAL_SERVER_ERROR)
                 .entity("Не удалось удалить отзыв")
                 .build();
     }


}
