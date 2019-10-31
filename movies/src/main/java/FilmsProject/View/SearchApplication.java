package FilmsProject.View;

import FilmsProject.Controller.FilmOperationImpl;
import FilmsProject.Controller.FilmStorage;
import FilmsProject.Model.Film;
import FilmsProject.Model.FilmType;

import java.time.LocalDate;
import java.util.Scanner;

public class SearchApplication {

    private static FilmStorage filmStorage = FilmStorage.getInstance();

    SearchApplication(){}

    private static void addFilms(){
        LocalDate date1 = LocalDate.of(2019,8,13);
        LocalDate date2 = LocalDate.of(2019,10,22);

        Film newFilm = new Film("Marvel Avengers","wadq213213", FilmType.FILM,"Action",
                date1, 8.1,"Marvel Film");
        Film newFilm2 = new Film("Games Of Thrones","43242213213",FilmType.SERIES,"Series",
                date2, 7.1,"Game of Thrones is an American fantasy drama television series created by " +
                "David Benioff and D. B. Weiss for HBO. It is an adaptation of A Song of Ice and Fire, George R. R. ... " +
                "The series premiered on HBO in the United States on April 17, 2011, and concluded on May 19, 2019, with " +
                "73 episodes broadcast over eight seasons.");
        Film newFilm3 = new Film("Woody Woodpecker","435345433",FilmType.CARTOON,"Comedy",
                date2, 9.1,"Woody Woodpecker is an animated cartoon character, an anthropomorphic" +
                " red-headed woodpecker who appeared in theatrical short films produced by the Walter Lantz animation" +
                " studio and distributed by Universal Studios.");

        filmStorage.addNewFilm(newFilm);
        filmStorage.addNewFilm(newFilm2);
        filmStorage.addNewFilm(newFilm3);
    }

    private static void searchFilm(){

        Scanner scanner = new Scanner(System.in);
        addFilms(); 
        System.out.println("Найти фильм: ");
        System.out.println("1.По идентификатору");
        System.out.println("2.По названию");
        System.out.println("3.По дате релиза");

        int choose = 0;

        while (choose !=1 && choose !=2 && choose !=3) {

            String inputData = scanner.nextLine();

            if (tryParseInt(inputData)) {
                choose = Integer.parseInt(inputData);
            }
            else {
                System.err.println("Oшибка.Введите число");
                continue;
            }

            FilmOperationImpl filmOperationImpl = FilmOperationImpl.getInstance();
            Thread searchWait = new Thread(new SearchWait());
            switch (choose) {
                case 1:
                    System.out.println("Введите идентификатор:");
                    String input = scanner.nextLine();
                    searchWait.start();
                    ConsoleInfo.getSearchResult(filmOperationImpl.searchFilmByIdentifier(input));
                    searchWait.interrupt();
                    break;
                case 2:
                    System.out.println("Введите название:");
                    input = scanner.nextLine();
                    searchWait.start();
                    ConsoleInfo.getSearchResult(filmOperationImpl.searchFilmByTitle(input));
                    searchWait.interrupt();
                    break;
                case 3:
                    System.out.println("Введите дату релиза в формате YYYY.M/MM.D/DD:");
                    input = scanner.nextLine();
                    searchWait.start();
                    String[] dateArray = input.split("\\.");
                    int year = Integer.parseInt(dateArray[0]);
                    int month = Integer.parseInt(dateArray[1]);
                    int day = Integer.parseInt(dateArray[2]);
                    LocalDate date = LocalDate.of(year,month,day);
                    ConsoleInfo.getSearchResult(filmOperationImpl.searchFilmByReleaseDate(date));
                    searchWait.interrupt();
                    break;
            }

        }
    }
    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        searchFilm();
    }
}
