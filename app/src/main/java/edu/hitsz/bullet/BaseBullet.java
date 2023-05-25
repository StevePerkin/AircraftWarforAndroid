package edu.hitsz.bullet;

import edu.hitsz.activity.ModeChooseActivity;
import edu.hitsz.aircraft.Observer;
import edu.hitsz.basic.AbstractFlyingObject;


/**
 * 子弹类。
 * 也可以考虑不同类型的子弹
 *
 * @author hitsz
 */
public abstract class BaseBullet extends AbstractFlyingObject implements Observer {


    private int power;

    public BaseBullet(int locationX, int locationY, int speedX, int speedY, int power) {
        super(locationX, locationY, speedX, speedY);
        this.power = power;
    }

    @Override
    public void forward() {
        super.forward();

        // 判定 x 轴出界
        if (locationX <= 0 || locationX >= ModeChooseActivity.screenWidth) {
            vanish();
        }

        // 判定 y 轴出界
        if (speedY > 0 && locationY >= ModeChooseActivity.screenHeight ) {
            // 向下飞行出界
            vanish();
        }else if (locationY <= 0){
            // 向上飞行出界
            vanish();
        }

    }

    public int getPower() {
        return power;
    }

    public abstract void update();
}
