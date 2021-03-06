/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.papaharni.amcserver.commands;

import de.papaharni.amcserver.AMCServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 *
 * @author Pappi
 */
public class nachtsicht implements CommandExecutor {
    private final AMCServer _plugin;
    
    public nachtsicht(AMCServer plugin) {
        _plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if(p == null) {
            sender.sendMessage("Dieser Befehl kann nur von Spielern ausgeführt werden.");
            return true;
        }
        
        if(!p.hasPermission("amcserver.nachtsicht") && !p.isOp()) {
            p.sendMessage("Du hast keine Rechte um diesen Befehl zu verwenden.");
            return true;
        }
        
        if(p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
            p.removePotionEffect(PotionEffectType.NIGHT_VISION);
            p.sendMessage("Nachtsicht Effekt wurde deaktiviert.");
        } else {
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
            p.sendMessage("Nachtsicht Effekt wurde aktiviert.");
        }
        return true;
    }
}
