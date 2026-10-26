package com.example.calculateur.core.action;

public enum ActionType {
    INITIALISATION("i"),
    CALCULER("c"),
    RECALCULER("r"),
    QUITTER("q");

    private final String action;

    ActionType(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
