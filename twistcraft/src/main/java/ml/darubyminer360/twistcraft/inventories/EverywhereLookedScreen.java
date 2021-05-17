package ml.darubyminer360.twistcraft.inventories;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import java.util.*;

public class EverywhereLookedScreen implements InventoryHolder {
    Inventory inv;

    public EverywhereLookedScreen() {
        inv = Bukkit.createInventory(this, 27, "Everywhere Looked Mode Selector"); // 54 is the max size
        init();
    }

    void init() {
        ItemStack fillerItem = createItem(" ", Material.BLACK_STAINED_GLASS_PANE);
        for (int i = 0; i < 27; i++) {
            if (i == 11) {
                // Turns to Random Blocks
                ItemStack item = createItem("Turns to Random Blocks", Material.COBBLESTONE, "§1Twist Mode", "", "Makes it to where every block you look at turns to random blocks.");
                inv.setItem(i, item);
            }
            else if (i == 13) {
                // Turns to Bedrock
                ItemStack item = createItem("Turns to Bedrock", Material.BEDROCK, "§1Twist Mode", "", "Makes it to where every block you look at turns to bedrock.");
                inv.setItem(i, item);
            }
            else if (i == 15) {
                // Explodes
                ItemStack item = createItem("Explodes", Material.TNT, "§1Twist Mode", "", "Makes it to where every block you look at explodes.");
                inv.setItem(i, item);
            }
            else {
                inv.setItem(i, fillerItem);
            }
        }
    }

    ItemStack createItem(String name, Material mat, String... lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }
    
    @Override
    public Inventory getInventory() {
        return inv;
    }
}
