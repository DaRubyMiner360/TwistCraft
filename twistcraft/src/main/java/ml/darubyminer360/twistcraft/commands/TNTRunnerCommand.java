package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.scheduler.BukkitScheduler;

public class TNTRunnerCommand implements CommandExecutor {
    public static boolean enabled;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            if (args.length > 0) {
                int cooldown = Integer.getInteger(args[0]);

                BukkitScheduler scheduler = p.getServer().getScheduler();
                scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                    @Override
                    public void run() {
                        Entity tnt = p.getWorld().spawn(p.getLocation(), TNTPrimed.class);
                        ((TNTPrimed)tnt).setFuseTicks(80);
                    }
                }, cooldown * 20L, cooldown * 20L);

                TwistCraft.instance.messageServer("TNT Runner enabled with a cooldown of " + args[0] + "!", p);
                enabled = true;
            }
            else {
                p.sendMessage("Add the amount of time between TNT spawns (in seconds) as an argument!");
            }
        }
        else {
            TwistCraft.instance.messageServer("TNT Runner disabled!", p);
            enabled = false;
        }

        return true;
    }
}
