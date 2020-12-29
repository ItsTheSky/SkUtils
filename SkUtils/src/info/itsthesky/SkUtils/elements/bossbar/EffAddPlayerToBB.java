package info.itsthesky.SkUtils.elements.bossbar;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.crafting.CraftingStation;
import net.Indyuce.mmoitems.gui.CraftingStationView;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Add Player to Bossbar")
@Description("Add a player to a specific server bossbar")
@Since("alpha-0.4")
@Examples("add player to bossbar {_boss}")
public class EffAddPlayerToBB extends Effect {

    private Expression<Player> player;
    private Expression<BossBar> boss;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.boss = (Expression<BossBar>) exprs[1];
        this.player = (Expression<Player>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //Explaining this still below in the tutorial
        return null;
    }

    @Override
    protected void execute(Event event) {
        BossBar b = boss.getSingle(event);
        Player p = player.getSingle(event);
        if (p != null) {
            if (b != null) {
                b.addPlayer(p);
            }
        }
    }
}