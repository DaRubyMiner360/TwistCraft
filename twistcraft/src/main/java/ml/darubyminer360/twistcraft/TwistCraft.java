package ml.darubyminer360.twistcraft;

import ml.darubyminer360.twistcraft.commands.CraftableCommandBlocksCommand;
import ml.darubyminer360.twistcraft.commands.HalfHeartEatingCommand;
import ml.darubyminer360.twistcraft.commands.OPMobsCommand;
import ml.darubyminer360.twistcraft.commands.TwistCommand;

import ml.darubyminer360.twistcraft.listeners.CraftableCommandBlocksListener;
import ml.darubyminer360.twistcraft.listeners.HalfHeartEatingListener;
import ml.darubyminer360.twistcraft.listeners.OPMobsListener;
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

        getServer().getPluginManager().registerEvents(new CraftableCommandBlocksListener(), this);
        getServer().getPluginManager().registerEvents(new OPMobsListener(), this);
        getServer().getPluginManager().registerEvents(new HalfHeartEatingListener(), this); }

    @Override
    public void onDisable() {
        instance = null;
    }
}
