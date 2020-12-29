package info.itsthesky.SkUtils;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.util.Timespan;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import info.itsthesky.SkUtils.elements.ClassInfos;
import info.itsthesky.SkUtils.elements.DeluxeBazaar.*;
import info.itsthesky.SkUtils.elements.MMOItems.EffOpenStation;
import info.itsthesky.SkUtils.elements.MMOItems.ExprItem;
import info.itsthesky.SkUtils.elements.askyblock.*;
import info.itsthesky.SkUtils.elements.bossbar.*;
import info.itsthesky.SkUtils.elements.effects.EffPasteSchem;
import info.itsthesky.SkUtils.elements.effects.EffSaveWorld;
import info.itsthesky.SkUtils.elements.expressions.*;
import info.itsthesky.SkUtils.elements.hd.*;
import info.itsthesky.SkUtils.elements.musics.*;
import info.itsthesky.SkUtils.elements.slimefun.*;
import info.itsthesky.SkUtils.elements.usbc.ExprGetStats;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideLayout;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.*;
import org.bukkit.boss.BossBar;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.UUID;

public class SkUtils extends JavaPlugin {

    SkriptAddon addon;

    private static SkUtils instance;

    public static SkUtils getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;

        Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§3 Loading of SkUtils version " + getDescription().getVersion() + " by " + getDescription().getAuthors());
        if (!Bukkit.getServer().getPluginManager().isPluginEnabled("Skript")) {
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8] §cSkript not found ! Disabling ...");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        ClassInfos.registerTypes();
        addon = Skript.registerAddon(this);
        registerSkriptSyntaxes();
        if (Bukkit.getServer().getPluginManager().getPlugin("DeluxeBazaar") == null) {
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§e Cannot found the DeluxeBazaar depend! You cannot use these syntaxes!");
        }

        if (!Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§e Cannot found the NoteBlockAPI depend! You cannot use these syntaxes!");
        }
        if (!Bukkit.getPluginManager().isPluginEnabled("ASkyBlock")){
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§e Cannot found the aSkyBlock depend! You cannot use these syntaxes!");
        }
        if (!Bukkit.getPluginManager().isPluginEnabled("UltraSkyBlock-Core")){
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§e Cannot found the UltraSkyBlock-Core depend! You cannot use these syntaxes!");
        }
        if (!Bukkit.getPluginManager().isPluginEnabled("FastAsyncWorldEdit")){
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§e Cannot found the FastAsyncWorldEdit depend! You cannot use these syntaxes!");
        }
        /*
        if (!Bukkit.getPluginManager().isPluginEnabled("Slimefun")){
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§e Cannot found the SlimeFun depend! You cannot use these syntaxes!");
        } */

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
        Skript.registerExpression(ExprBossbar.class, BossBar.class, ExpressionType.COMBINED, "[skutils] new [bukkit] boss[bar]");

        /* Effects */
        Skript.registerEffect(EffSaveWorld.class, "[skutils] save [the] [world] %world% [on disk]");
        Skript.registerEffect(EffAddPlayerToBB.class, "[skutils] add [the] [player] %player% to [the] boss[bar] %bossbar%");
        Skript.registerEffect(EffDelPlayerFromBB.class, "[skutils] (delete|remove) [the] [player] %player% from [the] boss[bar] %bossbar%");
        Skript.registerEffect(EffChangeBossBarTitle.class, "[skutils] (set|change) [the] title of [the] boss[bar] %bossbar% to %string%");
        Skript.registerEffect(EffChangeBossBarColor.class, "[skutils] (set|change) [the] color of [the] boss[bar] %bossbar% to %string%");
        Skript.registerEffect(EffChangeBossBarStyle.class, "[skutils] (set|change) [the] style of [the] boss[bar] %bossbar% to %string%");
        Skript.registerEffect(EffChangeBossBarProgress.class, "[skutils] (set|change) [the] progress of [the] boss[bar] %bossbar% to %number%");

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
            Skript.registerEffect(EffOpenSFBook.class, "[skutils] open [(sf|slimefun)] [guide] %guide% to [the] [player] %player%");
        }

        /* Special SlimeFun
        if (Bukkit.getServer().getPluginManager().getPlugin("Slimefun") != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "§8[§6SkUtils§8]§b SlimeFun found! Enabling SlimeFun syntaxes!");
            Skript.registerExpression(ExprIsGuideItem.class, Boolean.class, ExpressionType.COMBINED, "[skutils] item %itemstack% is [the] [slimefun] guide");
            Skript.registerExpression(ExprGuide.class, SlimefunGuideLayout.class, ExpressionType.COMBINED, "[skutils] [(sf|slimefun)] book %string% [guide] [type]");
            Skript.registerExpression(ExprNSK.class, NamespacedKey.class, ExpressionType.COMBINED, "[skutils] [new] (namespacedkey|nsk) [(with id|named)] %string%");
            Skript.registerExpression(ExprCustomItem.class, CustomItem.class, ExpressionType.COMBINED, "[skutils] [new] [(slimefun|sf)] (customitem|ci) (with item|based on) %itemstack%");
            Skript.registerExpression(ExprRecipeType.class, RecipeType.class, ExpressionType.COMBINED, "[skutils] [(slimefun|sf)] recipe type [with id] %string%");
            Skript.registerExpression(ExprNewCategory.class, Category.class, ExpressionType.COMBINED, "[skutils] [new] [(slimefun|sf)] (category|cat) with id %namespacedkey% [and] with [custom]item %customitem%");
            Skript.registerExpression(ExprNewSFItemStack.class, SlimefunItemStack.class, ExpressionType.COMBINED, "[skutils] [new] [(slimefun|sf)] item[stack] (with item|based on) %itemstack%");
            Skript.registerEffect(EffRegisterSFItem.class, "[skutils] register [new] [(slimefun|sf)] item %slimefunitemstack% in cat[egory] %category% with [recipe] type %recipetype% and recipe [pattern] %itemstacks%");
        }*/

        /* Special NoteBlockAPI */
        if (Bukkit.getServer().getPluginManager().getPlugin("NoteBlockAPI") != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "§8[§6SkUtils§8]§b NoteBlockAPI found! Enabling NoteBlockAPI syntaxes!");
            Skript.registerEffect(EffPlaySound.class, "[skutils] [(noteblockapi|nbapi|nba)] play [the] song [(called|with name|with id|named)] %string% to [the] [player] %player%");
        }

        /* Special aSkyBlock */
        if (Bukkit.getServer().getPluginManager().getPlugin("ASkyBlock") != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "§8[§6SkUtils§8]§b aSkyBlock found! Enabling aSkyBlock syntaxes!");
            Skript.registerExpression(ExprIslandCount.class, Integer.class, ExpressionType.COMBINED, "[skutils] [askyblock] all [server] [enabled] is[lands]");
            Skript.registerExpression(ExprIslandWorld.class, World.class, ExpressionType.COMBINED, "[skutils] [askyblock] [the] is[lands] world");
            Skript.registerExpression(ExprNetherWorld.class, World.class, ExpressionType.COMBINED, "[skutils] [askyblock] [the] nether is[lands] world");
            Skript.registerExpression(ExprSpawnLocation.class, Location.class, ExpressionType.COMBINED, "[skutils] [askyblock] [the] [configured] spawn[point] loc[ation]");
            Skript.registerEffect(EffCalcLevel.class, "[skutils] refresh [askyblock] [island] level of [the] [player] %player%");

        }

        /* Special USBC */
        if (Bukkit.getServer().getPluginManager().getPlugin("UltraSkyBlock-Core") != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "§8[§6SkUtils§8]§b UltraSkyBlock-Core found! Enabling UltraSkyBlock-Core syntaxes!");
            Skript.registerExpression(ExprGetStats.class, Double.class, ExpressionType.COMBINED, "[skutils] [usbc] stats %string% of [the] [player] %player%");
            // Skript.registerEffect(EffCalcLevel.class, "[skutils] set [usbc] stats %string% of [the] [player] %player% to [the] [value] %");
        }

        /* Special HD */
        if (Bukkit.getServer().getPluginManager().getPlugin("HolographicDisplays") != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "§8[§6SkUtils§8]§b HolographicDisplays found! Enabling HolographicDisplays syntaxes!");
            Skript.registerExpression(ExprCreateHolo.class, Hologram.class, ExpressionType.COMBINED, "[skutils] new [hd] holo[gram] at %location% [with [the] text %string%]");
            Skript.registerEffect(EffAddLine.class, "[skutils] add [new] [line] %string% to [the] [hd] [holo] %hologram%");
            Skript.registerEffect(EffRemoveLine.class, "[skutils] remove [line] [number] %integer% of [the] [hd] [holo] %hologram%");
            Skript.registerEffect(EffRemoveHolo.class, "[skutils] delete [the] [hd] holo[gram] %hologram%");
            Skript.registerEffect(EffTeleportHolo.class, "[skutils] teleport [the] [hd] holo[gram] %hologram% to [the] [location] %location%");
            Skript.registerEffect(EffShowHolo.class, "[skutils] show [the] [dh] holo[gram] %hologram% to [the] [player] %player%");
            Skript.registerEffect(EffHideHolo.class, "[skutils] hide [the] [dh] holo[gram] %hologram% from [the] [player] %player%");
        }

        /* Special FAWE */
        if (Bukkit.getServer().getPluginManager().getPlugin("FastAsyncWorldEdit") != null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "§8[§6SkUtils§8]§b FastAsyncWorldEdit found! Enabling FastAsyncWorldEdit syntaxes!");
            Skript.registerEffect(EffPasteSchem.class, "[skutils] [fawe] paste [the] [schem[atic]] %string% at [the] [location] %location% including air %boolean%");
        }

    }
}
