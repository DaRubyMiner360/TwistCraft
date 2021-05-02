package ml.darubyminer360.twistcraft;

import ml.darubyminer360.twistcraft.commands.*;

import ml.darubyminer360.twistcraft.listeners.*;
import ml.darubyminer360.twistcraft.util.Config;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

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
        getCommand("deathswap").setExecutor(new DeathSwapCommand());
        getCommand("tntrunner").setExecutor(new TNTRunnerCommand());

        getServer().getPluginManager().registerEvents(new CraftableCommandBlocksListener(), this);
        getServer().getPluginManager().registerEvents(new OPMobsListener(), this);
        getServer().getPluginManager().registerEvents(new HalfHeartEatingListener(), this);
        getServer().getPluginManager().registerEvents(new ManhuntListener(), this);
        getServer().getPluginManager().registerEvents(new EverywhereLookedListener(), this);

        Config.setup();
        Config.get().addDefault("BroadcastMessages", false);
        Config.get().options().copyDefaults(true);
        Config.save();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public void messageServer(String message, Player p) {
        if (Config.get().getBoolean("BroadcastMessages")) {
            p.getServer().broadcastMessage(message);
        }
        else {
            p.sendMessage(message);
        }
    }
}
