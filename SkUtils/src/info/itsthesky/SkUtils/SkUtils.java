package info.itsthesky.SkUtils;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.util.Timespan;
import info.itsthesky.SkUtils.elements.DeluxeBazaar.*;
import info.itsthesky.SkUtils.elements.MMOItems.EffOpenStation;
import info.itsthesky.SkUtils.elements.MMOItems.ExprItem;
import info.itsthesky.SkUtils.elements.effects.EffSaveWorld;
import info.itsthesky.SkUtils.elements.expressions.*;
import info.itsthesky.SkUtils.elements.musics.EffPlaySound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.UUID;

public class SkUtils extends JavaPlugin {

    SkriptAddon addon;
    boolean NoteBlockAPI = true;

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§3 Loading of SkUtils version " + getDescription().getVersion() + " by " + getDescription().getAuthors());
        if (!Bukkit.getServer().getPluginManager().isPluginEnabled("Skript")) {
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8] §cSkript not found ! Disabling ...");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        addon = Skript.registerAddon(this);
        registerSkriptSyntaxes();
        if (Bukkit.getServer().getPluginManager().getPlugin("DeluxeBazaar") == null) {
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§e Cannot found the DeluxeBazaar depend! You cannot use these syntaxes!");
        }

        if (!Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§e Cannot found the NoteBlockAPI depend! You cannot use these syntaxes!");
            NoteBlockAPI = false;
        }

        try {
            addon.loadClasses("info.itsthesky.SkWorld", "elements");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void registerSkriptSyntaxes() {

        /* Expressions */
        Skript.registerExpression(ExprGenStructure.class, Boolean.class, ExpressionType.COMBINED, "[skutils] structure [generation] of [the] [world] %world%");
        Skript.registerExpression(ExprHasStorm.class, Boolean.class, ExpressionType.COMBINED, "[skutils] [the] storm [state] of [world] %world%");
        Skript.registerExpression(ExprIsHardcore.class, Boolean.class, ExpressionType.COMBINED, "[skutils] [the] hardcore [state] of [world] %world%");
        Skript.registerExpression(ExprUID.class, UUID.class, ExpressionType.COMBINED, "[skutils] [world] u[u]id [of] %world%");
        Skript.registerExpression(ExprViewDistance.class, Integer.class, ExpressionType.COMBINED, "[skutils] view distance of [world] %world%");
        Skript.registerExpression(ExprPluginCommand.class, String.class, ExpressionType.COMBINED, "[skutils] plugin of [the] [command] %string%");
        Skript.registerExpression(ExprPlayTime.class, Timespan.class, ExpressionType.COMBINED, "[skutils] [the] play time of [the] [player] %offlineplayer%");
        Skript.registerExpression(ExprDamageDealt.class, Integer.class, ExpressionType.COMBINED, "[skutils] [the] [total] damage dealt [stats] of [the] [player] %offlineplayer%");
        Skript.registerExpression(ExprDamageTaken.class, Integer.class, ExpressionType.COMBINED, "[skutils] [the] [total] damage taken [stats] of [the] [player] %offlineplayer%");
        Skript.registerExpression(ExprItemDrop.class, Integer.class, ExpressionType.COMBINED, "[skutils] [the] [total] items drop [stats] of [the] [player] %offlineplayer%");
        Skript.registerExpression(ExprAllPlugins.class, Plugin.class, ExpressionType.COMBINED, "[skutils] all [server|spigot|paper] [installed] plugins");
        Skript.registerExpression(ExprUUIDToPlayer.class, OfflinePlayer.class, ExpressionType.COMBINED, "[skutils] [the] player [from|with] u[u]id %string%");

        /* Effects */
        Skript.registerEffect(EffSaveWorld.class, "[skutils] save [the] [world] %world% [on disk]");

        /* Events */
        // Skript.registerEvent("Remaining Air", EvtOnEnchant.class, EnchantItemEvent.class, "[skutils] [on] enchant[er] [event]");

        /* Special DeluxeBazaar */
        if (Bukkit.getServer().getPluginManager().getPlugin("DeluxeBazaar") != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "§8[§6SkUtils§8]§b DeluxeBazaar found! Enabling DeluxeBazaar syntaxes!");
            Skript.registerExpression(ExprPlayerMode.class, String.class, ExpressionType.COMBINED, "[skutils] [deluxebazaar] [the] [bazaar] mode of [the] [player] %player%");
            Skript.registerExpression(ExprPlayerOrders.class, String.class, ExpressionType.COMBINED, "[skutils] [deluxebazaar] [all] [bazaar] orders of [the] [player] %player%");
            Skript.registerExpression(ExprBuyPrice.class, Double.class, ExpressionType.COMBINED, "[skutils] [deluxebazaar] [bazaar] buy price of [the] [item] [with id] %string%");
            Skript.registerExpression(ExprSellPrice.class, Double.class, ExpressionType.COMBINED, "[skutils] [deluxebazaar] [bazaar] sell price of [the] [item] [with id] %string%");
            Skript.registerExpression(ExprBuyCount.class, Integer.class, ExpressionType.COMBINED, "[skutils] [deluxebazaar] [bazaar] buy (count|number) of [the] [item] [with id] %string%");
            Skript.registerExpression(ExprSellCount.class, Integer.class, ExpressionType.COMBINED, "[skutils] [deluxebazaar] [bazaar] sell (count|number) of [the] [item] [with id] %string%");

        }
        /* Special MMOItems */
        if (Bukkit.getServer().getPluginManager().getPlugin("MMOItems") != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "§8[§6SkUtils§8]§b MMOItems found! Enabling MMOItems syntaxes!");
            Skript.registerExpression(ExprItem.class, ItemStack.class, ExpressionType.COMBINED, "[skutils] [mmoitems] item [with] [type] %string% and [with] [id] %string%");
            Skript.registerEffect(EffOpenStation.class, "[skutils] [mmoitems] open [the] station[s] [(named|with name|called|with id)] %string% to [the] [player] %player%");

        }

        /* Special NoteBlockAPI */
        if (Bukkit.getServer().getPluginManager().getPlugin("NoteBlockAPI") != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "§8[§6SkUtils§8]§b NoteBlockAPI found! Enabling NoteBlockAPI syntaxes!");
            // [(noteblockapi|nbapi|nba)]
            Skript.registerEffect(EffPlaySound.class, "[skutils] [(noteblockapi|nbapi|nba)] play [the] song [(called|with name|with id|named)] %string% to [the] [player] %player%");
        }
    }
}
