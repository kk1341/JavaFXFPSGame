package Bullet;
import javafx.scene.Group;
import javafx.scene.shape.Sphere;
import javafx.scene.PerspectiveCamera;
import Enemy.Enemy;

public class Bullet{
    public void sphereShoot(Group root, PerspectiveCamera camera, Enemy enemy){
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