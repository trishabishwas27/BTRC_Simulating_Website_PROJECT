module org.main.btrc_simulating_website_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.main.btrc_simulating_website_project to javafx.fxml;
    exports org.main.btrc_simulating_website_project;
}