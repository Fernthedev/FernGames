package com.github.fernthedev.fernminigames;

import me.kangarko.gameapi.Arena;
import me.kangarko.gameapi.ArenaManager;
import me.kangarko.gameapi.ArenaSign;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

import java.util.*;

public class MinigameManager implements ArenaManager {
    private Set<Arena> arenas;

    public List<String> getArenaNames() {
        List<String> arenasNames = new ArrayList<>();

        for(Arena arena : arenas) {
            arenasNames.add(arena.getName());
        }

        return arenasNames;
    }

    public Arena getArenaByName(String name) {
        Map<String,Arena> arenasMap = new HashMap<>();

        for(Arena arena : arenas) {
            arenasMap.put(arena.getName(),arena);
        }

        if(!arenasMap.containsKey(name)) return null;

        return arenasMap.get(name);
    }

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
