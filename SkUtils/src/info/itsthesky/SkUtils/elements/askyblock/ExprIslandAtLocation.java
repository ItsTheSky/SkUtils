package info.itsthesky.SkUtils.elements.askyblock;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import com.wasteofplastic.askyblock.Island;
import ch.njol.util.Kleenean;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("aSkyBlock Islands at Location")
@RequiredPlugins("aSkyBlock")
@Description("Return island at the given world location")
@Since("alpha-0.2")
@Examples("askyblock island at player's location")
public class ExprIslandAtLocation extends SimpleExpression<Island> {

    private Expression<Location> location;

    @Override
    public Class<? extends Island> getReturnType() {
        return Island.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.location = (Expression<Location>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected Island[] get(Event event) {
        Location loc = location.getSingle(event);
        Island islandLocation = ASkyBlockAPI.getInstance().getIslandAt(loc);
        if (islandLocation == null) {
            return new Island[0];
        } else {
            return new Island[] {islandLocation};
        }
    }
}