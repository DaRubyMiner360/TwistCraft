package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class OPMobsCommand implements CommandExecutor {
    public static boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            TwistCraft.instance.messageServer("OP Mobs enabled!", p);
            enabled = true;
        }
        else {
            TwistCraft.instance.messageServer("OP Mobs disabled!", p);
            enabled = false;
        }

        return true;
    }
}
