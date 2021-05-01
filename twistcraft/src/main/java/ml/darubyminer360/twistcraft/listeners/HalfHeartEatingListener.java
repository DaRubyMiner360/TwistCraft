package ml.darubyminer360.twistcraft.listeners;

import com.comphenix.protocol.wrappers.BlockPosition;
import ml.darubyminer360.twistcraft.WrapperPlayClientBlockPlace;
import ml.darubyminer360.twistcraft.WrapperPlayClientUseItem;
import ml.darubyminer360.twistcraft.commands.HalfHeartEatingCommand;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class HalfHeartEatingListener implements Listener {
    @EventHandler
    public void onPlayerConsumeItem(PlayerItemConsumeEvent event) {
        if (HalfHeartEatingCommand.enabled) {
            if (event.getItem().getType().name().toLowerCase().contains("potion"))
                return;
            if (event.getItem().getType().name().toLowerCase().contains("bucket"))
                return;

            event.getPlayer().setHealth(0.5);
        }
    }
}

