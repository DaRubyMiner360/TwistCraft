package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class DeathSwapCommand implements CommandExecutor {
    public static boolean enabled;

    public static int task1;
    public static int task2;
    public static int task3;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p1 = (Player) sender;

        if (!enabled) {
            if (args.length > 0) {
                Player p2 = p1.getServer().getPlayer(args[0]);

                BukkitScheduler scheduler = p1.getServer().getScheduler();
                task1 = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                    int num = 10;

                    @Override
                    public void run() {
                        if (num == 0) {
                            p1.getServer().broadcastMessage("Go!");
                            p1.getServer().getScheduler().cancelTask(task1);
                        }
                        else {
                            p1.getServer().broadcastMessage(Integer.toString(num--));
                        }
                    }
                }, 20L, 20L);
                task2 = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                    @Override
                    public void run() {
                        task3 = scheduler.scheduleSyncRepeatingTask(TwistCraft.instance, new Runnable() {
                            int num = 20;

                            @Override
                            public void run() {
                                if (num == 0) {
                                    Location l1 = p1.getLocation();
                                    p1.teleport(p2.getLocation());
                                    p2.teleport(l1);
                                    p1.getServer().getScheduler().cancelTask(task3);
                                }
                                else {
                                    p1.getServer().broadcastMessage(Integer.toString(num--));
                                }
                            }
                        }, 0L, 20L);
                    }
                }, 6020L, 6000L);

                TwistCraft.instance.messageServer("Death Swap enabled! The players are " + p1.getDisplayName() + " and " + args[0] + "!", p1);
                enabled = true;
            }
            else {
                p1.sendMessage("Add the other player as an argument!");
            }
        }
        else {
            p1.getServer().getScheduler().cancelTask(task1);
            p1.getServer().getScheduler().cancelTask(task2);
            p1.getServer().getScheduler().cancelTask(task3);
            TwistCraft.instance.messageServer("Death Swap disabled!", p1);
            enabled = false;
        }

        return true;
    }
}
