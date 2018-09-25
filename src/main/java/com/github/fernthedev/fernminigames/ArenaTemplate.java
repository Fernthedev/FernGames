package com.github.fernthedev.fernminigames;

import me.kangarko.gameapi.Arena;
import me.kangarko.gameapi.ArenaMessenger;
import me.kangarko.gameapi.ArenaPlugin;
import me.kangarko.gameapi.ArenaSnapshotStage;
import me.kangarko.gameapi.cause.DeathCause;
import me.kangarko.gameapi.cause.JoinCause;
import me.kangarko.gameapi.cause.LeaveCause;
import me.kangarko.gameapi.cause.StopCause;
import me.kangarko.gameapi.event.*;
import me.kangarko.gameapi.impl.BasicMessenger;
import me.kangarko.gameapi.type.ArenaState;
import me.kangarko.gameapi.utils.ExpItemTag;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public abstract class ArenaTemplate implements Arena {

    private String name;

    /**
     * Your plugin that creates the arena
     */
    private final ArenaPlugin plugin;

    protected ArenaTemplate(String name, ArenaPlugin plugin) {
        this.name = name;
        this.plugin = plugin;
    }


    /**
     * The inbuilt messenger for sending messages.
     */
    private final ArenaMessenger messenger = new BasicMessenger(this);


    /**
     * Arena state.
     */
    private ArenaState state = ArenaState.STOPPED;

    /**
     * An internal flag to workaround some stuff.
     */
    private boolean stopping;



    @Override
    public void onPostLoad() {
    }


    @Override
    public final boolean joinPlayer(Player pl, JoinCause cause) {
        if (!callEvent(new ArenaPreJoinEvent(this, cause, pl)))
            return false;

        final boolean success = handleJoin(pl, cause);

        callEvent(new ArenaJoinEvent(this, cause, pl));
        return success;
    }


    /**
     * Called after the player attempts to join,
     * and the {@link ArenaPreJoinEvent} has been fired and not cancelled.
     *
     * @param player the player
     * @param cause the cause
     */
    protected abstract boolean handleJoin(Player player, JoinCause cause);


    @Override
    public final boolean kickPlayer(Player pl, LeaveCause cause) {
        if (!callEvent(new ArenaPreLeaveEvent(this, cause, pl)))
            return false;

        final boolean success = handleLeave(pl, cause);

        callEvent(new ArenaLeaveEvent(this, cause, pl));
        return success;
    }

    /**
     * Called after the player attempts to quit,
     * and the {@link ArenaPreLeaveEvent} has been fired and not cancelled.
     *
     * @param player the player
     * @param cause the cause
     */
    protected abstract boolean handleLeave(Player player, LeaveCause cause);

    @Override
    public final boolean onArenaStart() {
        state = ArenaState.RUNNING;

        callEvent(new ArenaPostStartEvent(this));
        return handleArenaStart();
    }

    /**
     * Called after arena starts and the {@link ArenaPostStartEvent} has been fired.
     */
    protected abstract boolean handleArenaStart();

    @Override
    public final void onLobbyStart() {
        state = ArenaState.LOBBY;

        Bukkit.getPluginManager().callEvent(new LobbyStartEvent(this));
    }


    @Override
    public final void onArenaStop(StopCause cause) {
        if (stopping)
            return;

        state = ArenaState.STOPPED;
        stopping = true;

        try {
            handleArenaStop(cause);

            Bukkit.getPluginManager().callEvent(new ArenaPostStopEvent(this, cause));
        } finally {
            stopping = false;
        }
    }

    /**
     * Called when the arena ends and the {@link ArenaPostStopEvent} has been fired.
     */
    protected abstract void handleArenaStop(StopCause cause);







    @Override
    public void teleportPlayerToSpawn(Player pl) {
    }

    @Override
    public void onSnapshotUpdate(boolean save, ArenaSnapshotStage stage) {
    }

    @Override
    public void onPlayerPvP(EntityDamageByEntityEvent e, Player damager, Player victim, double damage) {
    }

    @Override
    public void onPlayerPvE(Player damager, LivingEntity victim, double damage) {
    }

    @Override
    public void onPlayerDamage(EntityDamageByEntityEvent e, Player player, Entity source, double damage) {

    }

    @Override
    public void onPlayerBlockDamage(EntityDamageByBlockEvent e, Player player, double damage) {
    }

    @Override
    public void onPlayerDeath(Player pl, Player killer) {
    }

    @Override
    public void onPlayerDeath(Player pl, DeathCause cause) {
    }

    @Override
    public void onPlayerClick(Player pl, Block clickedBlock, ItemStack hand) {
    }

    @Override
    public void onPlayerClickAir(Player pl, ItemStack hand) {
    }

    @Override
    public void onPlayerBlockPlace(BlockPlaceEvent e) {
    }

    @Override
    public void onPlayerBlockBreak(BlockBreakEvent e) {
    }

    @Override
    public void onEntityTarget(EntityTargetEvent e) {
    }

    @Override
    public void onEntityDeath(EntityDeathEvent e) {
    }

    @Override
    public void onPlayerRespawn(PlayerRespawnEvent e) {
    }


    @Override
    public void onPlayerPickupTag(PlayerPickupItemEvent e, ExpItemTag tag) {
    }

    @Override
    public void onProjectileHit(ProjectileHitEvent e) {
    }

    @Override
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
    }

    @Override
    public void onEntitySpawn(LivingEntity en) {
    }

    /**
     * An utility method to call events.
     *
     * @param e the event
     * @return true if the event was not cancelled, meaning it has passed.
     */
    private boolean callEvent(org.bukkit.event.Event e) {
        Bukkit.getPluginManager().callEvent(e);

        return !(e instanceof Cancellable) || !((Cancellable) e).isCancelled();
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final ArenaPlugin getPlugin() {
        return plugin;
    }

    @Override
    public final ArenaMessenger getMessenger() {
        return messenger;
    }

    @Override
    public final boolean isStopping() {
        return stopping;
    }

    @Override
    public final ArenaState getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Arena{name=" + name + ",plugin=" + plugin.getName() + "}";
    }
}
