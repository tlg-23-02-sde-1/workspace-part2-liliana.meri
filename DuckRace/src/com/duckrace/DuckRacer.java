package com.duckrace;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer {
    // fields
    private final int id;
    private String name;
    private List<Reward> rewards = new ArrayList<>();

    // constructors
    public DuckRacer(int id, String name) {
        this.id = id; // add id on instantiation
        setName(name);
    }

    // action or business methods
    public void win(Reward reward) {
        rewards.add(reward);
    }

    // accessor methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // a derived property, we can "calculate: the number os wins form the 'rewards' collection
    public int getWins() {
        return rewards.size(); // begin at 0
    }

    // NOTE: we are  returning a read-only view of our List<Reward>
    //client cant mess with it (add/remove/clear) but is "live" view
    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards); // Collections.unmodifiableList();
    }

    @Override
    public String toString() {
        return String.format("%s: id=%s, name=%s, wins=%s, rewards=%s",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }


}