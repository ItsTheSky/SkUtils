package info.itsthesky.SkUtils.elements.effects;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import org.bukkit.World;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Save World")
@Description("Save a specific world on the disk")
@Since("alpha-0.1")
@Examples("save world world(\"world\") on disk")
public class EffSaveWorld extends Effect {

    private Expression<World> world;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.world = (Expression<World>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //Explaining this still below in the tutorial
        return null;
    }

    @Override
    protected void execute(Event event) {
        World w = world.getSingle(event);
        if (w != null) {
            w.save();
        }
    }
}