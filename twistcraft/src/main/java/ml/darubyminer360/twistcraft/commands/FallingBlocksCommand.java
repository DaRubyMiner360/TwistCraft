package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Random;

public class FallingBlocksCommand implements CommandExecutor {
    public static Material[] mats = Material.values();

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
                        Random rnd = new Random();
                        Material material = mats[rnd.nextInt(mats.length)];

                        while (!material.isBlock() || material.isLegacy()) {
                            material = mats[rnd.nextInt(mats.length)];
                        }

                        int x = rnd.nextInt(16);
                        if (rnd.nextBoolean()) {
                            x = -x;
                        }

                        int z = rnd.nextInt(16);
                        if (rnd.nextBoolean()) {
                            z = -z;
                        }

                        Location location = p.getLocation();
                        location.add(x, 100, z);

                        location.getWorld().spawnFallingBlock(location, material.createBlockData());
                    }
                }, cooldown, cooldown);

                TwistCraft.instance.messageServer("Falling Blocks enabled with a cooldown of " + args[0] + "!", p);
                enabled = true;
            }
            else {
                p.sendMessage("Add the amount of time between blocks in ticks (20 ticks is 1 second) as an argument!");
            }
        }
        else {
            p.getServer().getScheduler().cancelTask(task);

            TwistCraft.instance.messageServer("Falling Blocks disabled!", p);
            enabled = false;
        }

        return true;
    }
}

