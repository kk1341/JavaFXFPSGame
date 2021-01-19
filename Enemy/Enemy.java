package Enemy;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.shape.Sphere;

public class Enemy{
    ArrayList<Sphere> enemyList;
    static int count =  0;
    public Enemy(){
        enemyList = new ArrayList<Sphere>();
    }

    public void enemy_Generate(Group root){
        Sphere enemy = new Sphere(10);
        Random random = new Random();
        random_SetTransform(enemy, random);
        enemyList.add(enemy);
        root.getChildren().add(enemyList.get(count));
        count++;
    }

    public Sphere get_Enemy(){
        Sphere enemy = enemyList.get(0);
        return enemy;
    }

    public double random_GetTransformX(Random random){
        return random.nextDouble()*300 - 150; 
    }

    public double random_GetTransformZ(Random random){
        return random.nextDouble()*300 - 150;
    }

    public void random_SetTransform(Sphere enemy, Random random){
        enemy.setTranslateX(random_GetTransformX(random));
        enemy.setTranslateZ(random_GetTransformZ(random));
    }
}