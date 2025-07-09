package com.ru.pattern.creationals.singleton.DragonBallsEx;

public class DragonBalls {
    private static DragonBalls dragonBalls;
    private int ballsCollected;

    private DragonBalls(){
        this.ballsCollected = 0;
    }

    public static DragonBalls getInstance(){
        if (dragonBalls == null) {
            if (dragonBalls == null){
                dragonBalls = new DragonBalls();
                System.out.println("Dragon balls created");
            }
        }
        return dragonBalls;
    }

    void collectBall(){
        if(this.ballsCollected < 7 ){
            this.ballsCollected++;
            System.out.println("Dragon ball collected");
        } else{
            System.out.println("7 Balls already collected, you can't collect more, Sheinlongs awaits for you");
        }
    }

    void summonShenlong(){
        if(this.ballsCollected == 7){
            System.out.println("Shenlong summoned");
            this.ballsCollected= 0;
        } else {
            System.out.println("Shenlong is not summoned yet, missing balls");
        }
    }

}
