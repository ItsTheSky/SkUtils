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

@Name("Structure Generation")
@Description("Return if structure can be generate in the specific world")
@Since("alpha-0.1")
@Examples("structure generation of world(\"world\")")
public class ExprGenStructure extends SimpleExpression<Boolean> {


    private Expression<World> world;

    @Override
    public Class<? extends Boolean> getReturnType() {
        return Boolean.class;
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
    protected Boolean[] get(Event event) {
        World w = world.getSingle(event);
        if (w != null) {
            return new Boolean[] {w.canGenerateStructures()};
        }
        return null;
    }
}