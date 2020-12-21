package info.itsthesky.SkUtils.elements.askyblock;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("aSkyBlock Islands Count")
@Description("Return the total of current island on the server")
@Since("alpha-0.2")
@RequiredPlugins("aSkyBlock")
@Examples("askyblock all server islands")
public class ExprIslandCount extends SimpleExpression<Integer> {


    @Override
    public Class<? extends Integer> getReturnType() {
        return Integer.class;
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
    protected Integer[] get(Event event) {
        return new Integer[] {ASkyBlockAPI.getInstance().getIslandCount()};
    }
}