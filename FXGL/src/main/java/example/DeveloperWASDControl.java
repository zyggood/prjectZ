package example;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;

public class DeveloperWASDControl extends Component {

    double speed = 0;


    @Override
    public void onAdded() {
        FXGL.getInput().addAction(new UserAction("dev_up") {
            @Override
            protected void onAction() {
                entity.translateY(-5 * speed);
            }
        }, KeyCode.W);
        FXGL.getInput().addAction(new UserAction("dev_down") {
            @Override
            protected void onAction() {
                entity.translateY(5 * speed);
            }
        }, KeyCode.S);
        FXGL.getInput().addAction(new UserAction("dev_left") {
            @Override
            protected void onAction() {
                entity.translateX(-5 * speed);
            }
        }, KeyCode.A);
        FXGL.getInput().addAction(new UserAction("dev_right") {
            @Override
            protected void onAction() {
                entity.translateX(5 * speed);
            }
        }, KeyCode.D);


    }

    @Override
    public void onUpdate(double tpf) {
        speed = tpf * 60;
    }

    @Override
    public boolean isComponentInjectionRequired() {
        return false;
    }
}
