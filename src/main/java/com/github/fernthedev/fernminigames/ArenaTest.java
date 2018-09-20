package com.github.fernthedev.fernminigames;

import me.kangarko.gameapi.*;
import me.kangarko.gameapi.cause.JoinCause;
import me.kangarko.gameapi.cause.LeaveCause;
import me.kangarko.gameapi.cause.StopCause;
import org.bukkit.entity.Player;

import java.util.Collection;

public class ArenaTest extends ArenaTemplate {
    protected ArenaTest(String name, ArenaPlugin plugin) {
        super(name, plugin);
    }

    @Override
    protected boolean handleJoin(Player player, JoinCause cause) {
        return false;
    }

    @Override
    protected boolean handleLeave(Player player, LeaveCause cause) {
        return false;
    }

    @Override
    protected boolean handleArenaStart() {
        return false;
    }

    @Override
    protected void handleArenaStop(StopCause cause) {

    }

    @Override
    public Collection<Player> getPlayers() {
        return null;
    }

    @Override
    public ArenaSettings getSettings() {
        return null;
    }

    @Override
    public ArenaData getData() {
        return null;
    }

    @Override
    public ArenaSnapshot getSnapshot() {
        return null;
    }

    @Override
    public Setup getSetup() {
        return null;
    }

    @Override
    public ArenaPhase getPhase() {
        return null;
    }

    @Override
    public int getRemainingSeconds() {
        return 0;
    }

    @Override
    public void restoreSnapshots(boolean b) {

    }
}
