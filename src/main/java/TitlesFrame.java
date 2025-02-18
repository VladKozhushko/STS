import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TitlesFrame extends JFrame {
   //Constructs initializes the UI
   public TitlesFrame() {
      this.initUI();
   }

   //Method for initialize the user interface
   private void initUI() {
      this.setTitle("Криві фігури");
      this.setDefaultCloseOperation(3);
      this.add(new TitlesPanel(37));
      this.setSize(350, 350);
      this.setLocationRelativeTo((Component)null);
   }

   //Main method that starts the program
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            TitlesFrame ps = new TitlesFrame();
            ps.setVisible(true);
         }
      });
   }
}
