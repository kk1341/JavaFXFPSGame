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
            if(distanceCalculation(ball, enemy) < 3){
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

    public double getDistanceXCalculation(Sphere ball, Enemy enemy){
        Sphere enemyTransformX = enemy.get_Enemy();
        double distanceX = ball.getTranslateX()-enemyTransformX.getTranslateZ();
        return Math.pow(distanceX, 2);
    }

    public double getDistanceYCalculation(Sphere ball, Enemy enemy){
        Sphere enemyTransformY = enemy.get_Enemy();
        double distanceY = ball.getTranslateY()-enemyTransformY.getTranslateY();
        return Math.pow(distanceY, 2);
    }

    public double getDistanceZCalculation(Sphere ball, Enemy enemy){
        Sphere enemyTranformZ = enemy.get_Enemy();
        double distanceZ = ball.getTranslateZ()-enemyTranformZ.getTranslateZ();
        return Math.pow(distanceZ, 2);
    }

    public double distanceCalculation(Sphere ball, Enemy enemy){
        double distance = getDistanceXCalculation(ball, enemy) - getDistanceYCalculation(ball, enemy) - getDistanceZCalculation(ball, enemy);
        return Math.sqrt(distance);
    }
} 