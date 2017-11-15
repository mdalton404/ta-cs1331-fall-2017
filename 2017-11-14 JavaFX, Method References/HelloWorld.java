import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.input.InputEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class HelloWorld extends Application {
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello World!");
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});
		StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();

        primaryStage.setTitle("BorderPane Practice");
		BorderPane root = new BorderPane();

		HBox box = new HBox(30);


		Label topLabel = new Label("Top label");
		Label leftLabel = new Label("Left label");
		Label rightLabel = new Label("Right label");
		Label centerLabel = new Label("Center label");
		Label bottomLabel = new Label("Bottom label");

		box.getChildren().add(topLabel);
		box.getChildren().add(leftLabel);
		box.getChildren().add(rightLabel);
		box.getChildren().add(centerLabel);
		box.getChildren().add(bottomLabel);

		root.setTop(topLabel);
		root.setLeft(leftLabel);
		root.setRight(rightLabel);
		root.setCenter(centerLabel);
		root.setBottom(bottomLabel);

		root.setAlignment(topLabel, Pos.CENTER);
		root.setAlignment(bottomLabel, Pos.CENTER);
		root.setAlignment(centerLabel, Pos.CENTER);
		root.setAlignment(leftLabel, Pos.CENTER);
		root.setAlignment(rightLabel, Pos.CENTER);



		primaryStage.setScene(new Scene(root, 600, 600));
		primaryStage.show();
	}

	
		
	


}