package com.example.calculateur.core.action;

public enum ActionType {
    INITIALISATION("i"),
    CALCULER("c"),
    RE_CALCULER("r"),
    SAUVEGUARDER("s"),
    QUITTER("q");

    private final String action;

    ActionType(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
