import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class ButtonInPane extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {

    // Create buttons with labels
    Button abram = new Button("Abram");
    Button juliet = new Button("Juliet");
    Button romeo = new Button("Romeo");

    // With an inner class
    class AbramEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            System.out.println("Do you bite your thumb at us, sir?\n");
        }
    }

    abram.setOnAction(new AbramEventHandler());


    // With an anyonymous inner class
    juliet.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            System.out.println("O, Romeo, Romeo! Wherefore art thou Romeo?\n"
                    + "Deny thy father and refuse thy name.\n"
                    + "Or, if thou wilt not, be but sworn my love,\n"
                    + "And I'll no longer be a Capulet.\n");
        }
    });


    // With a lambda
    romeo.setOnAction((event) -> {
        System.out.println("Did my heart love till now? Forswear it, sight,\n"
                + "For I ne'er saw true beauty till this night.\n");
    });

    // Create vbox for storing buttons;
    VBox vbox = new VBox();
    // Add buttons to vbox
    vbox.getChildren().addAll(juliet, romeo, abram);

    // Create background image
    Image image = new Image("romeoandjuliet.jpg");
    ImageView iv = new ImageView();
    iv.setImage(image);

    // Create pane for vbox and image
    StackPane pane = new StackPane();

    // Add image and vbox to background
    pane.getChildren().addAll(iv, vbox);

    primaryStage.setTitle("Shakespeare's Romeo and Juliet"); // Set the stage title
    primaryStage.setScene(new Scene(pane)); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  public static void main(String[] args) {
    launch(args);
  }
}
