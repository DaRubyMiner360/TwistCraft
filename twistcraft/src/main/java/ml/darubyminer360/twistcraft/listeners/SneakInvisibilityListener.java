package ml.darubyminer360.twistcraft.listeners;

import com.comphenix.protocol.wrappers.BlockPosition;
import ml.darubyminer360.twistcraft.WrapperPlayClientBlockPlace;
import ml.darubyminer360.twistcraft.WrapperPlayClientUseItem;
import ml.darubyminer360.twistcraft.commands.SneakInvisibilityCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.entity.Player;
import org.bukkit.*;

public class SneakInvisibilityListener implements Listener {
    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        Player p = event.getPlayer();
        if (SneakInvisibilityCommand.enabled) {
            if (p.isSneaking()) {
                p.setInvisible​(true);
            }
            else {
                p.setInvisible​(false);
            }
        }
    }
}
