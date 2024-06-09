package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import javafx.scene.paint.Color;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private static final Map<Color, String> colorNames = new HashMap<>();
    static {
        colorNames.put(Color.RED, "rojo");
        colorNames.put(Color.BLUE, "azul");
        colorNames.put(Color.GREEN, "verde");
        colorNames.put(Color.BLACK, "negro");
        colorNames.put(Color.WHITE, "blanco");
        colorNames.put(Color.YELLOW, "amarillo");
        colorNames.put(Color.PINK, "rosa");
        colorNames.put(Color.PURPLE, "morado");
        colorNames.put(Color.ORANGE, "naranja");
        colorNames.put(Color.BROWN, "marrón");
        
    }

    @Override
    public void start(Stage primaryStage) {

        Label dateLabel = new Label("Selecciona una fecha:");
        DatePicker datePicker = new DatePicker();
        Label colorLabel = new Label("Selecciona un color:");
        ColorPicker colorPicker = new ColorPicker();
        Button confirmButton = new Button("Aceptar ...>");

        confirmButton.setOnAction(event -> {
            LocalDate selectedDate = datePicker.getValue();
            Color selectedColor = colorPicker.getValue();
            String colorName = getColorName(selectedColor);
            System.out.println("Fecha seleccionada ------> " + selectedDate);
            System.out.println("Color seleccionado------ " + colorName);
        });

   
        VBox vbox = new VBox(10, dateLabel, datePicker, colorLabel, colorPicker, confirmButton);
        vbox.setSpacing(10);

   
        Scene scene = new Scene(vbox, 300, 200);
    
        primaryStage.setTitle("DatePicker and ColorPicker Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private String getColorName(Color color) {
        for (Map.Entry<Color, String> entry : colorNames.entrySet()) {
            if (colorsAreEqual(color, entry.getKey())) {
                return entry.getValue();
            }
        }
        return "color desconocido"; // Por si el color no está en el mapa
    }

    private boolean colorsAreEqual(Color c1, Color c2) {
        return Math.abs(c1.getRed() - c2.getRed()) < 0.01 &&
               Math.abs(c1.getGreen() - c2.getGreen()) < 0.01 &&
               Math.abs(c1.getBlue() - c2.getBlue()) < 0.01;
    }
}