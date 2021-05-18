package ml.darubyminer360.twistcraft.listeners;

import ml.darubyminer360.twistcraft.TwistCraft;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.meta.tags.*;
import org.bukkit.*;

import java.util.*;

public class OPItemsListener implements Listener {
    @EventHandler
    public void onPlayerUseTotem(EntityResurrectEvent event) {
        if (!event.isCancelled()) {
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();

                NamespacedKey key = new NamespacedKey(TwistCraft.instance, "regenerating_totem");
                
                ItemStack totem;
                ItemStack mainhand = player.getInventory().getItemInMainHand();
                ItemStack offhand = player.getInventory().getItemInOffHand();
                boolean shouldContinue = true;
                if (offhand != null && offhand.getType() == Material.TOTEM_OF_UNDYING) {
                    if (!offhand.getItemMeta().getCustomTagContainer().hasCustomTag(key, ItemTagType.DOUBLE)) {
                        shouldContinue = false;
                    }
                    totem = offhand;
                }
                else if (mainhand != null && mainhand.getType() == Material.TOTEM_OF_UNDYING) {
                    if (!mainhand.getItemMeta().getCustomTagContainer().hasCustomTag(key, ItemTagType.DOUBLE)) {
                        shouldContinue = false;
                    }
                    totem = mainhand;
                }
                if (totem != null && shouldContinue) {
                    ItemMeta totemMeta = totem.getItemMeta();
                    ItemStack newTotem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
                    newTotem.setItemMeta(totemMeta);
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(item);
                    }
                    else {
                        player.getWorld().dropItem(player.getLocation(), item);
                    }
                    // totem.setAmount(2);
                }
            }
        }


        
        // ItemStack regeneratingTotem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
        // NamespacedKey regeneratingTotemKey = new NamespacedKey(this, "regenerating_totem");
        // ItemMeta regeneratingTotemMeta = regeneratingTotem.getItemMeta();
        // regeneratingTotemMeta.setDisplayName("Regenerating Totem");
        // regeneratingTotemMeta.getCustomTagContainer().setCustomTag(regeneratingTotemKey, ItemTagType.DOUBLE, 1);
        // regeneratingTotem.setItemMeta(regeneratingTotemMeta);
    }
}
