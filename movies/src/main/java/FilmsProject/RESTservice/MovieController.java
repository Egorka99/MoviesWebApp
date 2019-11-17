package FilmsProject.RESTservice;

import FilmsProject.DataLayer.jpa.UserAccessJPA;
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

//     @Autowired
//     private FilmService filmService;
//
//     @Autowired
//     private UserService userService;
//
//     @Autowired
//     private UserAccessService userAccessService;
//
//     @Autowired
//     private AdminService adminService;
//
//     @Autowired
//     private Admin admin;

     @Autowired
     UserAccessJPA userAccessJPA;

//     @GET
//     @Path("/{id}")
//     public Object[] getById(@PathParam("id") String id) {
//        return filmService.getFilmDetails(id);
//     }
//
//     @GET
//     @Path("/view")
//     public List<Film> searchFilm(@QueryParam("property") String property, @QueryParam("value") String value) {
//
//        return filmService.searchFilmsByProperty(property,value);
//     }
//
//     //Test data: http://localhost:8081/webapp/movie/addReview?filmIdentifier=326&reviewText=GoodFilm&rating=8.6
//     @POST
//     @Path("/{id}/review")
//     public Response addReview(@PathParam("id") String id, @QueryParam("authorLogin") String authorLogin,
//                               @QueryParam("reviewText") String reviewText, @QueryParam("rating") double rating) {
//
//         User user = userAccessService.getUserByLogin(authorLogin);
//
//          if (userService.writeReview(user,id,reviewText,rating)) {
//               return Response
//                       .status(Response.Status.OK)
//                       .entity("Отзыв успешно добавлен!")
//                       .build();
//          }
//
//          return Response
//                  .status(Response.Status.INTERNAL_SERVER_ERROR)
//                  .entity("Не удалось добавить отзыв")
//                  .build();
//     }
//
//     @POST
//     @Path("/review")
//     public Response updateReview(@QueryParam("authorLogin") String authorLogin,
//                                  @QueryParam("filmIdentifier") String filmIdentifier,
//                                  @QueryParam("reviewId") Long currentReviewId,
//                                  @QueryParam("reviewText") String reviewText,
//                                  @QueryParam("rating") double rating)
//     {
//
//         User user = userAccessService.getUserByLogin(authorLogin);
//
//
//         if (userService.updateReview(user,filmIdentifier,currentReviewId,reviewText,rating)) {
//             return Response
//                     .status(Response.Status.OK)
//                     .entity("Отзыв успешно изменен!")
//                     .build();
//         }
//
//         return Response
//                 .status(Response.Status.INTERNAL_SERVER_ERROR)
//                 .entity("Не удалось изменить отзыв")
//                 .build();
//
//     }
//
//     @DELETE
//     @Path("/review/{id}")
//     public Response deleteReview(@PathParam("id") Long reviewId) {
//         if (adminService.deleteReview(admin,reviewId)) {
//             return Response
//                     .status(Response.Status.OK)
//                     .entity("Отзыв успешно удален!")
//                     .build();
//         }
//
//         return Response
//                 .status(Response.Status.INTERNAL_SERVER_ERROR)
//                 .entity("Не удалось удалить отзыв")
//                 .build();
//     }

    @GET
    @Path("/getUsers")
    public List<User> getUsers() {
         return userAccessJPA.getAll();
    }

    @GET
    @Path("/getFilms")
    public List<Film> getFilms() {
        return userAccessJPA.getAllFilms();
    }

    @GET
    @Path("/getReviews")
    public List<Review> getReviews() {
        return userAccessJPA.getAllReviews();
    }

    @GET
    @Path("/getGenres")
    public List<Genre> getGenres() {
        return userAccessJPA.getAllGenres();
    }

}
