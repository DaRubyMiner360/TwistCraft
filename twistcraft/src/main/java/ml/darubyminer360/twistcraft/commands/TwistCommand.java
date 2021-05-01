package ml.darubyminer360.twistcraft.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TwistCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        
        if (args[0].toLowerCase() == "list") {
          p.sendMessage("- Craftable Command Blocks (craftablecommandblocks)");
        }
        else if (args[0].toLowerCase() == "enable") {
          if (args[1].toLowerCase() == "craftablecommandblocks") {
            // Enable Craftable Command Blocks

            p.sendMessage("Craftable Command Blocks enabled!");
          }
          else {
            return false;
          }
        }
        else if (args[0].toLowerCase() == "disable") {
          // Disable Craftable Command Blocks

          if (args[1].toLowerCase() == "craftablecommandblocks") {
            p.sendMessage("Craftable Command Blocks disabled!");
          }
          else {
            return false;
          }
        }
        else if (args[0].toLowerCase() == "info") {
          if (args[1].toLowerCase() == "craftablecommandblocks") {
            p.sendMessage("Craftable Command Blocks allows you to craft and use command blocks in survival mode.");
          }
          else {
            return false;
          }
        }
        else {
          return false;
        }

        return true;
    }
}
