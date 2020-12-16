
package accountinfo;

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
import javafx.scene.text.Text;
import login.LoginScreenController;


public class AccountInformationController implements Initializable {
    
    public static String ac = LoginScreenController.acc;
    
    @FXML
    private Text account_no;
    @FXML
    private Text sex;
    @FXML
    private Text account_type;
    @FXML
    private Text religion;
    @FXML
    private Label balance;
    
    
    
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
                
                balance.setText(rs.getString("Balance"));
                account_no.setText(rs.getString("AccountNo"));
                sex.setText(rs.getString("Gender"));
                account_type.setText(rs.getString("AccountType"));
                religion.setText(rs.getString("Religion"));
                
                
              
               
            
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
        
        setInfo();
        
        
        // TODO
    }    
    
}
