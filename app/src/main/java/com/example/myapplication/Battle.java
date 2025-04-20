package com.example.myapplication;

import java.util.Random;

public class Battle {
    private Lutemon a,b;
    private final Random rand=new Random();

    public Battle(Lutemon a,Lutemon b){ this.a=a; this.b=b; }

    public String start(){
        StringBuilder log=new StringBuilder();
        Lutemon atk=a, def=b;
        while(atk.isAlive()&&def.isAlive()){
            int dmg=atk.attack()+rand.nextInt(3);
            log.append(atk.getName()).append(" attacks ").append(def.getName()).append("\n");
            def.defend(dmg);
            if(def.isAlive()){
                log.append(def.getName()).append(" HP=").append(def.currentHealth).append("\n");
                Lutemon tmp=atk; atk=def; def=tmp;
            } else {
                log.append(def.getName()).append(" died\n");
                atk.recordBattleResult(true);
                def.recordBattleResult(false);
                atk.heal();
            }
        }
        return log.toString();
    }
}
