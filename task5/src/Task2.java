import java.util.Deque;
import java.util.LinkedList;

class BrowserHistory {
    private Deque<String> history = new LinkedList<>();

    // Напишите свое решение ниже
    public void visitSite(String site) {
        // Напишите свое решение ниже
        history.addFirst(site);
    }

    public String back(int steps) {
        // Напишите свое решение ниже
        if (steps >= history.size()) {
            return null;
        }
        return history.stream().skip(steps).findFirst().orElse(null);

    }

    public Deque<String> getHistory() {
        // Напишите свое решение ниже
        return history;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки

public class Task2 {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        browserHistory.visitSite("google.com");
        browserHistory.visitSite("stackoverflow.com");
        browserHistory.visitSite("github.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.getHistory());
    }
}