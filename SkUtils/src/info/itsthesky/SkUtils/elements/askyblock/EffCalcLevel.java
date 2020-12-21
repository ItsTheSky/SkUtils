package info.itsthesky.SkUtils.elements.askyblock;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.util.UUID;

@Name("aSkyBlock Refresh Island Level")
@Description("Refresh the island level of the given player")
@Since("alpha-0.2")
@RequiredPlugins("aSkyBlock")
@Examples("refresh the askyblock island level of player")
public class EffCalcLevel extends Effect {

    private Expression<Player> player;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
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
        Player p = player.getSingle(event);
        if (p != null) {
            UUID uuid = p.getUniqueId();
            ASkyBlockAPI.getInstance().calculateIslandLevel(uuid);
        }
    }
}