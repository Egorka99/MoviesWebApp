package FilmsProject.RESTservice;

import FilmsProject.DataLayer.jpa.FilmAccessJPA;
import FilmsProject.DataLayer.jpa.TestAccessJPA;
import FilmsProject.Interfaces.AdminService;
import FilmsProject.Interfaces.FilmService;
import FilmsProject.Interfaces.UserAccessService;
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
//TODO Ну тут переименовать надо и вообще подумать над разделением
public class MovieController {

     @Autowired
     private FilmService filmService;

     @Autowired
     private UserService userService;

     @Autowired
     private UserAccessService userAccessService;

     @Autowired
     private AdminService adminService;

     @Autowired
     private Admin admin;

     @Autowired
     private FilmAccessJPA filmAccessJPA;

     @GET
     @Path("/{id}")
     public Object[] getById(@PathParam("id") String id) {
        return filmService.getFilmDetails(id);
     }

     @GET
     @Path("/view")
     public List<Film> searchFilm(@QueryParam("property") String property, @QueryParam("value") String value) {

        return filmService.searchFilmsByProperty(property,value);
     }

     //Test data: http://localhost:8081/webapp/movie/346/review?authorLogin=user123&reviewText=ss&rating=6.7
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

     @POST
     @Path("/review")
     public Response updateReview(@QueryParam("authorLogin") String authorLogin,
                                  @QueryParam("filmIdentifier") String filmIdentifier,
                                  @QueryParam("reviewId") Long currentReviewId,
                                  @QueryParam("reviewText") String reviewText,
                                  @QueryParam("rating") double rating)
     {
         if (userService.updateReview(authorLogin,filmIdentifier,currentReviewId,reviewText,rating)) {
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

//    @Autowired
//    private TestAccessJPA testAccessJPA;
//
//    @GET
//    @Path("/getUsers")
//    public List<User> getUsers() {
//         return testAccessJPA.getAll();
//    }
//
//    @GET
//    @Path("/getFilms")
//    public List<Film> getFilms() {
//        return testAccessJPA.getAllFilms();
//    }
//
//    @GET
//    @Path("/getReviews")
//    public List<Review> getReviews() {
//        return testAccessJPA.getAllReviews();
//    }
//
//    @GET
//    @Path("/getGenres")
//    public List<Genre> getGenres() {
//        return testAccessJPA.getAllGenres();
//    }

}
