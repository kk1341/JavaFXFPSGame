import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import Enemy.Enemy;

public class MyFpsGame extends Application{
    static Enemy enemy = new Enemy();
    static PerspectiveCamera camera = new PerspectiveCamera(true);
    @Override
    public void start(Stage stage){
        stage.setHeight(800); //画面の大きさの設定
        stage.setWidth(800);
        Group root = new Group();

        enemy.enemy_Generate(root);

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
                scene.setOnMouseClicked(event -> sphereShoot(root));
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
    public void sphereShoot(Group root){
        Sphere ball = new Sphere(10);
        ball.setTranslateZ(camera.getTranslateZ());
        ball.setTranslateX(camera.getTranslateX());
        root.getChildren().add(ball);
        while(true){
            if(Math.abs(ball.getTranslateZ()) - Math.abs(enemy.get_Enemy().getTranslateZ()) < 3.0 &&
                    Math.abs(ball.getTranslateX()) - Math.abs(enemy.get_Enemy().getTranslateX()) < 3.0){
                root.getChildren().remove(enemy.get_Enemy());
                root.getChildren().remove(ball);
                System.out.println("ボールが削除されました");
                break;
            }
            else if(ball.getTranslateZ() > 1000){
                root.getChildren().remove(ball);
                break;
            }
            else{
                ball.setTranslateZ(ball.getTranslateZ()+0.01);
            }
        }

    }
}