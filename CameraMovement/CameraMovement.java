package CameraMovement;
import javafx.scene.input.KeyEvent;
import javafx.scene.PerspectiveCamera;

public class CameraMovement {
    public void cameraTranslation(KeyEvent event, PerspectiveCamera camera){
        switch(event.getCode()){
            case A:
                camera.setTranslateX(camera.getTranslateX()-1.0);
                break;
            case D:
                camera.setTranslateX(camera.getTranslateX()+1.0);
                break;
            case W:
                camera.setTranslateZ(camera.getTranslateZ()+1.0);
                break;
            case S:
                camera.setTranslateZ(camera.getTranslateZ()-1.0);
                break;
            default:
                break;
        }
    }
}
