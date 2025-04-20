package com.example.myapplication;

import java.io.Serializable;

public abstract class Lutemon implements Serializable {
    protected String name, color;
    protected int attack, defense, maxHealth, currentHealth;
    protected int experience, totalBattles, victories, trainingDays;

    public Lutemon(String name, String color, int attack, int defense, int maxHealth) {
        this.name = name; this.color = color; this.attack = attack;
        this.defense = defense; this.maxHealth = maxHealth;
        this.currentHealth = maxHealth; this.experience = 0;
        this.totalBattles = 0; this.victories = 0; this.trainingDays = 0;
    }

    public int attack() {
        int bonusAtk = (experience/3)*2;
        return attack + bonusAtk;
    }

    public void defend(int damage) {
        int bonusDef = experience/3;
        int dmgTaken = Math.max(0, damage - (defense+bonusDef));
        currentHealth -= dmgTaken;
    }

    public boolean isAlive() { return currentHealth>0; }
    public void heal() { currentHealth = maxHealth; }
    public void train() { experience++; trainingDays++; }
    public void recordBattleResult(boolean win) {
        totalBattles++;
        if (win) victories++;
    }

    public String getStats() {
        return name+"("+color+") ATK:"+attack()
                +" DEF:"+(defense+(experience/3))
                +" XP:"+experience
                +" HP:"+currentHealth+"/"+maxHealth;
    }

    public int getTotalBattles(){ return totalBattles; }
    public int getTrainingDays(){ return trainingDays; }
    public String getName(){ return name; }
    public String getColor(){ return color; }
}
