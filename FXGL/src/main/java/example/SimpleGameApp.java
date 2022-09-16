package example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SimpleGameApp extends GameApplication {
    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(800);
        gameSettings.setHeight(800);
        gameSettings.setTitle("aili");
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new SimpleFactory());

        FXGL.spawn("enemy", 100, 100);

        FXGL.entityBuilder().at(150, 150).view(new Rectangle(40, 40, Color.BLUE))
                .buildAndAttach();

        FXGL.entityBuilder().at(400, 300)
                .view(new Rectangle(40, 40))
                .with(new RotatingComponent())
                .buildAndAttach();
    }

    @Override
    protected void initInput() {
        // 1. get input service
        Input input = FXGL.getInput();

        // 2. add key/mouse bound actions
        // when app is running press F to see output to console
        input.addAction(new UserAction("Print Line") {
            @Override
            protected void onActionBegin() {
                System.out.println("Action Begin");
            }

            @Override
            protected void onAction() {
                System.out.println("On Action");
            }

            @Override
            protected void onActionEnd() {
                System.out.println("Action End");
            }
        }, KeyCode.F);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
