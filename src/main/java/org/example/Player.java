package org.example;

public class Player {
    private String name;
    private int healthPercentage;
    private Weapon weapon;

    public Player(String name, int healthPercentage,Weapon weapon) {
        this.name = name;
        this.healthPercentage = healthPercentage;
        checkAndSetHealt(healthPercentage);
        this.weapon = weapon;
    }

    private void checkAndSetHealt(int healthPercentage){
        if(healthPercentage>100){
            this.healthPercentage = 100;
        }
        if(healthPercentage<0){
            this.healthPercentage = 0;
        }
    }

    public Weapon getWeapon(){
        return this.weapon;
    }

    public int healthRemaining(){
        return this.healthPercentage;
    }

    public void loseHealth(int damage){
        int healthRemain = healthPercentage - damage;
        if (healthRemain <= 0){
            System.out.println(name + " player has been knocked out of game");
        }
        healthPercentage = healthRemain;// healthPercentage değişkenini günceller
        checkAndSetHealt(healthPercentage);
    }

    public void restoreHealth(int healthPotion){
        this.healthPercentage += healthPotion;
        checkAndSetHealt(this.healthPercentage);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", healthPercentage=" + healthPercentage +
                ", weapon=" + weapon +
                '}';
    }
}