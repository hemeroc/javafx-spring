package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavafxSpringsApplication extends Application {

    @Autowired
    private SpringFxmlLoader springFxmlLoader;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent load = (Parent) springFxmlLoader.load("window.fxml");
        primaryStage.setScene(new Scene(load));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    @Override
    public void init() {
        new SpringApplication(getClass()).
                run(super.getParameters().getRaw().toArray(new String[0])).
                getAutowireCapableBeanFactory().autowireBean(this);
    }

    public static void main(String[] args) {
        Application.launch(JavafxSpringsApplication.class, args);
    }
}

