package com.github.fernthedev.fernminigames;

import me.kangarko.gameapi.ArenaManager;
import me.kangarko.gameapi.ArenaPlugin;
import org.bukkit.plugin.Plugin;

public class FernArenaPlugin implements ArenaPlugin {

    private Plugin plugin;

    public FernArenaPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public ArenaManager getArenas() {
        return MainClass.getManager();
        //throw new UnsupportedOperationException("Use ArenaRegistry to get ArenaManager");
    }

    @Override
    public String getName() {
        return plugin.getName();
    }

    @Override
    public Plugin getPlugin() {
        return plugin;
    }
}
