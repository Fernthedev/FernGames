package com.github.fernthedev.fernminigames;

import me.kangarko.gameapi.ArenaManager;
import me.kangarko.gameapi.ArenaPlugin;
import org.bukkit.plugin.Plugin;

public class FernArenaPlugin implements ArenaPlugin {


    @Override
    public ArenaManager getArenas() {
        throw new UnsupportedOperationException("Use ArenaRegistry to get ArenaManager");
    }

    @Override
    public String getName() {
        return MainClass.getInstance().getName();
    }

    @Override
    public Plugin getPlugin() {
        return MainClass.getInstance();
    }
}
