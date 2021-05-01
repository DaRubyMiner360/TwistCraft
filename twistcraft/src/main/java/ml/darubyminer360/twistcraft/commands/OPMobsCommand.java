package ml.darubyminer360.twistcraft.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class OPMobsCommand implements CommandExecutor {
    public static boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            p.sendMessage("OP Mobs enabled!");
            enabled = true;
        }
        else {
            p.sendMessage("OP Mobs disabled!");
            enabled = false;
        }

        return true;
    }
}
