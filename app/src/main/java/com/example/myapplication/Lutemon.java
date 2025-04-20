package com.example.myapplication;

import java.io.Serializable;

public abstract class Lutemon implements Serializable {
    protected String name, color;
    protected int attack, defense, maxHealth, currentHealth;
    protected int experience, totalBattles, victories, trainingDays;

    public Lutemon(String name, String color, int attack, int defense, int maxHealth) {
        this.name = name; this.color = color;
        this.attack = attack; this.defense = defense;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public int attack() {
        int bonus = (experience/3)*2;
        return attack + bonus + (int)(Math.random()*3);
    }

    public void defend(int dmg) {
        int bonus = experience/3;
        int taken = Math.max(0, dmg - (defense+bonus));
        currentHealth -= taken;
    }

    public boolean isAlive() { return currentHealth>0; }

    public void heal() { currentHealth = maxHealth; }

    public void train() { experience++; trainingDays++; }

    public void recordBattle(boolean win) {
        totalBattles++;
        if (win) victories++;
        heal();
    }

    public String getStats() {
        return name+" ("+color+")  ATK:"+attack()
                +" DEF:"+(defense+experience/3)
                +" XP:"+experience
                +" HP:"+currentHealth+"/"+maxHealth;
    }

    public String getName() { return name; }
    public String getColor() { return color; }
    public int getTotalBattles() { return totalBattles; }
    public int getTrainingDays() { return trainingDays; }
}
