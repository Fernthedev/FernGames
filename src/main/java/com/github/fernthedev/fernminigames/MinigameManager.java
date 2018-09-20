package com.github.fernthedev.fernminigames;

import me.kangarko.gameapi.Arena;
import me.kangarko.gameapi.ArenaManager;
import me.kangarko.gameapi.ArenaSign;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Set;

public class MinigameManager implements ArenaManager {
    private Set<Arena> arenas;

    @Override
    public Set<Arena> getArenas() {
        return arenas;
    }

    @Override
    public List<String> getAvailable() {
        return null;
    }

    @Override
    public Arena findArena(Player player) {
        return null;
    }

    @Override
    public Arena findArena(String s) {
        return null;
    }

    @Override
    public Arena findArena(Location location) {
        return null;
    }

    @Override
    public ArenaSign findSign(Sign sign) {
        return null;
    }

    @Override
    public Arena findEditedArena(Player player) {
        return null;
    }

    @Override
    public boolean isPlaying(Player player) {
        return false;
    }

    @Override
    public boolean isEditing(Player player) {
        return false;
    }
}
