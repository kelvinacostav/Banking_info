/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Kelvi
 */
public class Banking2 extends Application {
    
    public static Stage stage = null;
    
    private double xoffset = 0;
    private double yoffset = 0;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        
        
        
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/Design/design.css").toExternalForm());
        
        stage.initStyle(StageStyle.UNDECORATED);
        
        stage.setScene(scene);
        
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 xoffset = event.getSceneX();
                 yoffset = event.getSceneY();
            }
        });
        
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 stage.setX(event.getScreenX()- xoffset);
                 stage.setY(event.getScreenY()- yoffset);
            }
        });
    
            
            
    
        this.stage = stage;
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
