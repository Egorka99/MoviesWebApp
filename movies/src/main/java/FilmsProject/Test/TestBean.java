package FilmsProject.Test;

import org.springframework.stereotype.Component;

@Component("someBean")
public class TestBean {
    private String name;

    public TestBean(String name) {
        this.name = name;
    }

    public TestBean() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("Class \"TestBean\" method called");
    }
}