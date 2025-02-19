import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * The {@code TitlesFrame} class initialize user interface and contain a graphical panel.
 * It extends {@link JFrame}.
 *
 * <p>It displays a {@code TitlesPanel} and has predefined dimensions.</p>
 *
 * @author VladKozhushko
 *
 * @version 1.0
 */
public class TitlesFrame extends JFrame {
   /**
    * Constructs {@code TitlesFrame} initialize the UI.
    */
   //Constructs initializes the UI
   public TitlesFrame() {
      this.initUI();
   }

   /**
    * Method for initialize the user interface contains {@code TitlesPanel},
    * set predefined dimensions.
    */
   //Method for initialize the user interface
   private void initUI() {
      this.setTitle("Криві фігури");
      this.setDefaultCloseOperation(3);
      this.add(new TitlesPanel(37));
      this.setSize(350, 350);
      this.setLocationRelativeTo((Component)null);
   }

   /**
    * Main method that starts the program.
    *
    * @param args command-line arguments (not used).
    */
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
