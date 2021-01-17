package Enemy;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.shape.Sphere;

public class Enemy{
    ArrayList<Sphere> enemyList;
    public Enemy(){
        enemyList = new ArrayList<Sphere>();
    }

    public void enemy_Generate(Group root){
        Sphere enemy = new Sphere(3);
        enemy.setTranslateZ(0.0);
        enemyList.add(enemy);
        root.getChildren().add(enemyList.get(0));
    }

    public Sphere get_Enemy(){
        Sphere enemy = enemyList.get(0);
        return enemy;
    }
}