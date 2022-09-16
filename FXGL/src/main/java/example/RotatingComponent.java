package example;

import com.almasb.fxgl.entity.component.Component;

public class RotatingComponent extends Component {
    @Override
    public void onUpdate(double tpf) {
        entity.rotateBy(tpf * 45);
    }
}
