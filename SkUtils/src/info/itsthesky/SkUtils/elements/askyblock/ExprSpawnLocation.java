package info.itsthesky.SkUtils.elements.askyblock;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import org.bukkit.Location;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("aSkyBlock Spawn Location")
@Description("Return the configured aSkyBlock's spawn location")
@Since("alpha-0.2")
@RequiredPlugins("aSkyBlock")
@Examples("askyblock spawn location")
public class ExprSpawnLocation extends SimpleExpression<Location> {


    @Override
    public Class<? extends Location> getReturnType() {
        return Location.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected Location[] get(Event event) {
        return new Location[] {ASkyBlockAPI.getInstance().getSpawnLocation()};
    }
}