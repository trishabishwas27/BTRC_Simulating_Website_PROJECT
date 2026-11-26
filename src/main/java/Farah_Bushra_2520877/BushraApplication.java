package Farah_Bushra_2520877;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BushraApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                BushraApplication.class.getResource(
                        "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/CitizenServiceUserView/DeviceIMEIVerficationView.fxml"
                )
        );

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Bushra - BTRC");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}