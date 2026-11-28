module org.main.btrc_simulating_website_project {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.main.btrc_simulating_website_project to javafx.fxml;
    exports org.main.btrc_simulating_website_project;

    exports Farah_Bushra_2520877;
    opens Farah_Bushra_2520877 to javafx.fxml;


    opens Farah_Bushra_2520877.CitizenServiceUser
            to javafx.fxml, javafx.base;
    opens Farah_Bushra_2520877.TelecomOperatorRepresentive
            to javafx.fxml, javafx.base;

}