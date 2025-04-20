package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static Storage instance;
    private final Map<Integer, Lutemon> lutemons;
    private int nextId = 1;

    private Storage() { lutemons = new HashMap<>(); }
    public static Storage getInstance() {
        if (instance == null) instance = new Storage();
        return instance;
    }
    public void addLutemon(Lutemon l) { lutemons.put(nextId++, l); }
    public Lutemon getLutemon(int id) { return lutemons.get(id); }
    public void removeLutemon(int id) { lutemons.remove(id); }
    public List<Lutemon> getAllLutemons() { return new ArrayList<>(lutemons.values()); }
    public int getTotalBattles() {
        int sum = 0;
        for (Lutemon l : lutemons.values()) sum += l.getTotalBattles();
        return sum;
    }
    public int getTotalTrainingDays() {
        int sum = 0;
        for (Lutemon l : lutemons.values()) sum += l.getTrainingDays();
        return sum;
    }
}
