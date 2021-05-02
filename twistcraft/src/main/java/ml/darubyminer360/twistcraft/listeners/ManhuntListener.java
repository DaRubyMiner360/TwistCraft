package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.commands.ManhuntCommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class ManhuntListener implements Listener {
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        if (ManhuntCommand.enabled) {
            Player player = event.getPlayer();
            player.getInventory().addItem(new ItemStack(Material.COMPASS));
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (ManhuntCommand.enabled) {
            Player player = event.getPlayer();
            Material held = event.getItem().getType();
            Action action = event.getAction();

            if (!player.getName().equals(ManhuntCommand.hunted) && held == Material.COMPASS && (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
                Player hunted = player.getServer().getPlayer(ManhuntCommand.hunted);

                player.setCompassTarget(hunted.getLocation());
                player.sendMessage(("You are tracking " + ManhuntCommand.hunted));
            }
        }
    }
}
