package com.github.fernthedev.fernminigames;

import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

    private static MinigameManager manager;
    private static MainClass instance;

    public static MinigameManager getManager() {return manager;}

    @Override
    public void onEnable() {
        instance = this;

        manager = new MinigameManager();

        // Plugin startup logic
    }

    public static MainClass getInstance() {return instance;}

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
