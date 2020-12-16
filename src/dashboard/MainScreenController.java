
package dashboard;

import static accountinfo.AccountInformationController.ac;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import login.LoginScreenController;

/**
 * FXML Controller class
 *
 * @author Kelvi
 */
public class MainScreenController implements Initializable {
    
    public static String ac = LoginScreenController.acc;
    
    @FXML
    private Label name;
    
    @FXML
    private Label body;
    
    public void setInfo(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String sql = "SELECT * FROM userdata WHERE AccountNo=?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, ac);
            
            
            rs = ps.executeQuery();
            if(rs.next()){
                
                name.setText(rs.getString("Name"));
                
              
               
            
            }
            else{
            
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("ERROR IN LOGIN");
                a.setContentText("Your account number or password is wrong.. TRY AGAIN!!");
                a.showAndWait();
            
            
            }
            
         }
        catch(ClassNotFoundException | SQLException e){
            
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Account Not Created.");
            a.setContentText("There is some error. TRY AGAIN!!"+ e.getMessage());
            a.showAndWait();
        
        }
}
    

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        body.setText(" Bank of Kelvin Corporation is an American multinational investment bank\n and financial services holding company headquartered in Charlotte,\n North Carolina, with central hubs in New York City,\nFlorida, Dallas, Toronto, London, and Hong Kong");
        setInfo();
    }    
    
}
