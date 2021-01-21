package Bullet;
import javafx.scene.Group;
import javafx.scene.shape.Sphere;
import javafx.scene.PerspectiveCamera;
import Enemy.Enemy;

public class Bullet{
    public void sphereShoot(Group root, PerspectiveCamera camera, Enemy enemy){
        Sphere bullet = bulletGenerate(root, camera);
        while(true){
            if(distanceCalculation(bullet, enemy) < 3){
                root.getChildren().remove(enemy.get_Enemy());
                root.getChildren().remove(bullet);
                enemy.enemy_Remove();
                enemy.enemy_Generate(root);
                System.out.println("remove Enemy");
                break;
            }
            else if(bullet.getTranslateZ() > 100){
                root.getChildren().remove(bullet);
                break;
            }
            else{
                bullet.setTranslateZ(bullet.getTranslateZ()+1.0);
            }
        }

    }

    public Sphere bulletGenerate(Group root, PerspectiveCamera camera){
        Sphere bullet = new Sphere(5);
        bullet.setTranslateX(camera.getTranslateX());
        bullet.setTranslateY(camera.getTranslateY());
        bullet.setTranslateZ(camera.getTranslateZ());
        bullet.setRotate(camera.getRotate());
        return bullet;
    }

    public double distanceCalculation(Sphere ball, Enemy enemy){
        double distance = getDistanceXCalculation(ball, enemy) + getDistanceYCalculation(ball, enemy) + getDistanceZCalculation(ball, enemy);
        return Math.sqrt(distance);
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
} 