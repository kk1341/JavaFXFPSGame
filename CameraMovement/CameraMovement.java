package CameraMovement;
import javafx.scene.PerspectiveCamera;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

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

    public void set_CameraRotate(MouseEvent event, Rotate cameraRotateX, Rotate cameraRotateY){
        cameraRotateX.setAngle(event.getSceneY() * 2);
        cameraRotateY.setAngle(event.getSceneX()/2);
    }
}
