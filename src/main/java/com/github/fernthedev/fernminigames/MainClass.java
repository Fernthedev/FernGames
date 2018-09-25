package com.github.fernthedev.fernminigames;

import me.kangarko.gameapi.registry.ArenaRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

    private static MinigameManager manager;
    private static MainClass instance;

    private static FernArenaPlugin fernArenaPlugin;

    private ArenaTest arenaTest;

    public static FernArenaPlugin getArenaPlugin() {
        return fernArenaPlugin;
    }

    public static MinigameManager getManager() {return manager;}

    @Override
    public void onEnable() {
        instance = this;


        fernArenaPlugin = new FernArenaPlugin(this);

        manager = new MinigameManager();
        arenaTest = new ArenaTest("test",fernArenaPlugin);
        ArenaRegistry.getArenas(fernArenaPlugin).add(arenaTest);

        // Plugin startup logic
    }

    public static MainClass getInstance() {return instance;}

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
