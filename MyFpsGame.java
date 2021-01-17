import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import Enemy.Enemy;
import Bullet.Bullet;

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
                scene.setOnKeyPressed(event -> press(event));   
                scene.setOnMouseClicked(event -> bullet.sphereShoot(root, camera, enemy));
            }
        };
        animationTimer.start();
    }
    public void press(KeyEvent event){
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