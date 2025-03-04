package com.example.helloPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HelloPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Messaggio visualizzato quando il plugin viene abilitato
        getLogger().info("HelloPlugin è stato attivato!");
    }

    @Override
    public void onDisable() {
        // Messaggio visualizzato quando il plugin viene disabilitato
        getLogger().info("HelloPlugin è stato disattivato!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hello")) {
            if (sender instanceof Player player) { // Controlla se il mittente è un giocatore
                // Ottieni tutti i giocatori online
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    // Invia il titolo a ogni giocatore
                    onlinePlayer.sendTitle(
                            ChatColor.GREEN + "" + ChatColor.BOLD + "Ciao! Benvenuto nel mio server Minecraft!", // Titolo verde in grassetto
                            ChatColor.BLUE + "" + ChatColor.ITALIC + "by Matty47ghigo", // Sottotitolo blu in corsivo
                            10, // Tempo di fade-in (in ticks)
                            70, // Tempo di visualizzazione (in ticks)
                            20   // Tempo di fade-out (in ticks)
                    );
                }

                // Invia un messaggio nel chat del server
                getServer().broadcastMessage(ChatColor.YELLOW + "Il comando /hello è stato eseguito da " + player.getName());
            } else {
                sender.sendMessage("Questo comando può essere eseguito solo da un giocatore.");
            }
            return true;
        }
        return false;
    }
}