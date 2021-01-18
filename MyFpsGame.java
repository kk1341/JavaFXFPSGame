import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import Enemy.Enemy;
import Bullet.Bullet;
import CameraMovement.CameraMovement;

public class MyFpsGame extends Application{
    @Override
    public void start(Stage stage){
        stage.setHeight(800); //画面の大きさの設定
        stage.setWidth(800);
        Group root = new Group();

        Enemy enemy = new Enemy();
        enemy.enemy_Generate(root);

        Bullet bullet = new Bullet();

        CameraMovement cameraMovement = new CameraMovement();

        PerspectiveCamera camera = new PerspectiveCamera(true);
        Translate cameraTranslate = new Translate(0, 0, -100);
        Rotate cameraRotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate cameraRotateY = new Rotate(0, Rotate.Y_AXIS);
        Rotate cameraRotateZ = new Rotate(0, Rotate.Z_AXIS);
        camera.getTransforms().addAll(
            cameraRotateX,
            cameraRotateY,
            cameraRotateZ,
            cameraTranslate
        );
        camera.setFarClip(1000);
        camera.setFieldOfView(45.5d);

        Scene scene = new Scene(root, 320, 320, true, SceneAntialiasing.BALANCED);
        scene.setCamera(camera);

        stage.setTitle("たくさん遊びましょう");
        stage.setScene(scene);
        stage.show();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                scene.setOnKeyPressed(event -> cameraMovement.cameraTranslation(event, camera));   
                scene.setOnMouseClicked(event -> bullet.sphereShoot(root, camera, enemy));
                scene.setOnMouseMoved(event -> cameraMovement.set_CameraRotate(event, cameraRotateX, cameraRotateY, cameraRotateZ));
            }
        };
        animationTimer.start();
    }
}