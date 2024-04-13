package com.customer.self.checkout.sys;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest extends Main{
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/views/MainView.fxml"));
        BorderPane mainLayout = new BorderPane();
        mainLayout = loader.load();

        Scene scene = new Scene(mainLayout);
        stage.setScene(scene);
        stage.show();
    }
    @Test
    public void test(){

    }

}