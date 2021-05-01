package ml.darubyminer360.twistcraft;

import ml.darubyminer360.twistcraft.commands.TwistCommand;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TwistCraft extends JavaPlugin {
    @Override
    public void onEnable() {
      getCommand("twist").setExecutor(new TwistCommand());
    }

    @Override
    public void onDisable() {
    }
}
