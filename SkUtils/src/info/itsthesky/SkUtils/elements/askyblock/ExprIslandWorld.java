package info.itsthesky.SkUtils.elements.askyblock;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import org.bukkit.World;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("aSkyBlock Islands World")
@RequiredPlugins("aSkyBlock")
@Description("Return the world where all islands are located")
@Since("alpha-0.2")
@Examples("askyblock island world")
public class ExprIslandWorld extends SimpleExpression<World> {


    @Override
    public Class<? extends World> getReturnType() {
        return World.class;
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
    protected World[] get(Event event) {
        return new World[] {ASkyBlockAPI.getInstance().getIslandWorld()};
    }
}