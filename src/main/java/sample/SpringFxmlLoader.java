package sample;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SpringFxmlLoader {

    private final ApplicationContext applicationContext;
    private final ResourceLoader resourceLoader;

    public SpringFxmlLoader(ApplicationContext applicationContext, ResourceLoader resourceLoader) {
        this.applicationContext = applicationContext;
        this.resourceLoader = resourceLoader;
    }

    private FXMLLoader generateFXMLLoader(String url) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.resourceLoader.getResource(url).getURL());
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        return fxmlLoader;
    }

    public Object load(String url) {
        try {
            return generateFXMLLoader(url).load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}