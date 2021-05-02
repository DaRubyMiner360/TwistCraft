package ml.darubyminer360.twistcraft;

import ml.darubyminer360.twistcraft.commands.*;

import ml.darubyminer360.twistcraft.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class TwistCraft extends JavaPlugin {
    public static TwistCraft instance;

    @Override
    public void onEnable() {
        instance = this;

        getCommand("twist").setExecutor(new TwistCommand());
        getCommand("craftablecommandblocks").setExecutor(new CraftableCommandBlocksCommand());
        getCommand("opmobs").setExecutor(new OPMobsCommand());
        getCommand("halfhearteating").setExecutor(new HalfHeartEatingCommand());
        getCommand("manhunt").setExecutor(new ManhuntCommand());
        getCommand("everywherelooked").setExecutor(new EverywhereLookedCommand());

        getServer().getPluginManager().registerEvents(new CraftableCommandBlocksListener(), this);
        getServer().getPluginManager().registerEvents(new OPMobsListener(), this);
        getServer().getPluginManager().registerEvents(new HalfHeartEatingListener(), this);
        getServer().getPluginManager().registerEvents(new ManhuntListener(), this);
        getServer().getPluginManager().registerEvents(new EverywhereLookedListener(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
