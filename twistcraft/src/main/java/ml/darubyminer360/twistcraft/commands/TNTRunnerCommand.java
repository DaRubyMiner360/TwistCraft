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

    public static int task;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (!enabled) {
            if (args.length > 0) {
                int cooldown = Integer.parseInt(args[0]);

                BukkitScheduler scheduler = p.getServer().getScheduler();
                task = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                    @Override
                    public void run() {
                        Entity tnt = p.getWorld().spawn(p.getLocation(), TNTPrimed.class);
                        ((TNTPrimed)tnt).setFuseTicks(80);
                    }
                }, cooldown, cooldown);

                TwistCraft.instance.messageServer("TNT Runner enabled with a cooldown of " + args[0] + " ticks!", p);
                enabled = true;
        }
            else {
                p.sendMessage("Add the amount of time between TNT spawns in ticks (20 ticks is 1 second) as an argument!");
            }
        }
        else {
            p.getServer().getScheduler().cancelTask(task);

            TwistCraft.instance.messageServer("TNT Runner disabled!", p);
            enabled = false;
        }

        return true;
    }
}
