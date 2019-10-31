package FilmsProject.View;

public class SearchWait implements Runnable {

    public void run() {
        System.out.print("Поиск фильмов.Пожалуйста,подождите");
        while (!Thread.interrupted()) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
