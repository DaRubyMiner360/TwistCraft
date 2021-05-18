package ml.darubyminer360.twistcraft.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class OPLootSelectionScreen implements InventoryHolder {
    Inventory inv;

    public OPLootSelectionScreen() {
        inv = Bukkit.createInventory(this, 27, "OP Loot Selector"); // 54 is the max size
        init();
    }

    void init() {
        ItemStack fillerItem = createItem(" ", Material.BLACK_STAINED_GLASS_PANE);
        for (int i = 0; i < inv.getSize(); i++) {
            if (i == 10) {
                // Doors Drop OP Loot
                ItemStack item = createItem("Doors Drop OP Loot", Material.OAK_DOOR, "§1Twist", "", "Check this twist's name.");
                inv.setItem(i, item);
            }
            else if (i == 11) {
                // Trapdoors Drop OP Loot
                ItemStack item = createItem("Trapdoors Drop OP Loot", Material.OAK_TRAPDOOR, "§1Twist", "", "Check this twist's name.");
                inv.setItem(i, item);
            }
            else if (i == 12) {
                // Shearing Animals Drops OP Loot
                ItemStack item = createItem("Shearing Animals Drops OP Loot", Material.SHEARS, "§1Twist", "", "Check this twist's name.");
                inv.setItem(i, item);
            }
            else if (i == 12) {
                // Mending Items Drops OP Loot
                ItemStack item = createItem("Mending Items Drops OP Loot", Material.ANVIL, "§1Twist", "", "Check this twist's name.");
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
