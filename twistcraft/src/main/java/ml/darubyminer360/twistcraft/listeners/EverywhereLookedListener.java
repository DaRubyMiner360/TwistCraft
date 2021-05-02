package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.commands.EverywhereLookedCommand;
import ml.darubyminer360.twistcraft.commands.ManhuntCommand;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Random;

public class EverywhereLookedListener implements Listener {
    public HashMap<String, Location> plb = new HashMap<String, Location>();
    public Material[] mats = Material.values();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (EverywhereLookedCommand.enabled) {
            Player player = event.getPlayer();
            Block block = player.getTargetBlock(null, 100);
            Location location = block.getLocation();
            Material material = block.getType();

            if (material == Material.OBSIDIAN || material == Material.END_PORTAL_FRAME || material == Material.END_PORTAL || material == Material.NETHER_PORTAL || material == Material.END_GATEWAY || material == Material.AIR || material == Material.CAVE_AIR || material == Material.WATER || material == Material.LAVA) {
            }
            else {
                String name = player.getName();

                if (plb.containsKey(name)) {
                    Location oloc = plb.get(name);

                    if (oloc.getBlockX() != location.getBlockX() || oloc.getBlockY() != location.getBlockY() || oloc.getBlockZ() != location.getBlockZ()) {
                        if (EverywhereLookedCommand.mode == EverywhereLookedCommand.EverywhereLookedMode.Random) {
                            plb.replace(name, location);

                            Random rnd = new Random();
                            Material newMaterial = mats[rnd.nextInt(mats.length)];

                            while (newMaterial == Material.END_PORTAL || newMaterial == Material.NETHER_PORTAL || newMaterial == Material.END_GATEWAY || !newMaterial.isBlock() || newMaterial.isLegacy()) {
                                newMaterial = mats[rnd.nextInt(mats.length)];
                            }

                            oloc.getBlock().setType(newMaterial);
                        }
                        else if (EverywhereLookedCommand.mode == EverywhereLookedCommand.EverywhereLookedMode.Bedrock) {
                            plb.replace(name, location);
                            Material newMaterial = Material.BEDROCK;

                            oloc.getBlock().setType(newMaterial);
                        }
                        else if (EverywhereLookedCommand.mode == EverywhereLookedCommand.EverywhereLookedMode.Explodes) {
                            Entity tnt = player.getWorld().spawn(oloc, TNTPrimed.class);
                            ((TNTPrimed)tnt).setFuseTicks(0);
                        }
                    }
                }
                else {
                    plb.put(name, location);
                }
            }
        }
    }
}

