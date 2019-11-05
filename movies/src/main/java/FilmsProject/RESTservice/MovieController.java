package FilmsProject.RESTservice;

import FilmsProject.Interfaces.FilmService;
import FilmsProject.Model.Film;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.List;

@Path("/movie")
@Consumes("application/json")
@Produces("application/json")
public class MovieController {

    @Autowired
    private FilmService filmService;

    @GET 
    @Path("/{id}")
    public Film getById(@PathParam("id") String id) {
        List<Film> listWithCurrentIdFilm = filmService.searchFilmByField("IMDBIdentifier","id");

        for (Film film : listWithCurrentIdFilm) {
            return film;
        }
        return null;
    }
}
