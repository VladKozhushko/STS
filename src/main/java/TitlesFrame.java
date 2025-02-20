import javax.swing.*;

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
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.add(new TitlesPanel(3,7));
      this.setSize(350, 350);
      this.setLocationRelativeTo(null);
   }

   /**
    * Main method that starts the program.
    *
    * @param args command-line arguments (not used).
    */
   //Main method that starts the program
   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         TitlesFrame ps = new TitlesFrame();
         ps.setVisible(true);
      });
   }
}
