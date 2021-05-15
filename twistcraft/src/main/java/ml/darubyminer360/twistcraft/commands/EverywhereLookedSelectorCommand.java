package ml.darubyminer360.twistcraft.commands;

import ml.darubyminer360.twistcraft.TwistCraft;
import ml.darubyminer360.twistcraft.inventories.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EverywhereLookedSelectorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        EverywhereLookedScreen everywhereLookedSelector = new EverywhereLookedScreen();
        p.openInventory(everywhereLookedSelector.getInventory());

        return true;
    }
}
