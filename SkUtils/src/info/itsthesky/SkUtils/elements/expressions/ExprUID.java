package info.itsthesky.SkUtils.elements.expressions;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.World;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.util.UUID;

@Name("UID of World")
@Description("Return the UID of a specific world")
@Since("alpha-0.1")
@Examples("uid of world(\"world\")")
public class ExprUID extends SimpleExpression<UUID> {


    private Expression<World> world;

    @Override
    public Class<? extends UUID> getReturnType() {
        return UUID.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.world = (Expression<World>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected UUID[] get(Event event) {
        World w = world.getSingle(event);
        if (w != null) {
            return new UUID[] {w.getUID()};
        }
        return null;
    }
}