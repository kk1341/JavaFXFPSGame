import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import Enemy.Enemy;
import Bullet.Bullet;
import CameraMovement.CameraMovement;

public class MyFpsGame extends Application{
    static PerspectiveCamera camera = new PerspectiveCamera(true);
    @Override
    public void start(Stage stage){
        stage.setHeight(800); //画面の大きさの設定
        stage.setWidth(800);
        Group root = new Group();

        Enemy enemy = new Enemy();
        enemy.enemy_Generate(root);

        Bullet bullet = new Bullet();

        CameraMovement cameraMovement = new CameraMovement();

        Scene scene = new Scene(root, 320, 320, true, SceneAntialiasing.BALANCED);
        camera.setTranslateZ(-100);
        camera.setFarClip(1000);
        scene.setCamera(camera);

        stage.setTitle("たくさん遊びましょう");
        stage.setScene(scene);
        stage.show();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                scene.setOnKeyPressed(event -> cameraMovement.cameraTranslation(event, camera));   
                scene.setOnMouseClicked(event -> bullet.sphereShoot(root, camera, enemy));
            }
        };
        animationTimer.start();
    }
}