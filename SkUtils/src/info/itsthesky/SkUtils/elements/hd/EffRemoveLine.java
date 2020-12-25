package info.itsthesky.SkUtils.elements.hd;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Remove Hologram Line")
@Description("Remove a specific line to a HolographicDisplays Hologram")
@Since("alpha-0.3")
@RequiredPlugins("HolographicDisplays")
@Examples("remove line 1 of holo {_holo}")
public class EffRemoveLine extends Effect {

    private Expression<Integer> line;
    private Expression<Hologram> holo;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.line = (Expression<Integer>) exprs[0];
        this.holo = (Expression<Hologram>) exprs[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //Explaining this still below in the tutorial
        return null;
    }

    @Override
    protected void execute(Event event) {
        Integer l = line.getSingle(event);
        Hologram h = holo.getSingle(event);
        if (h != null) {
            if (l != null) {
                h.removeLine(l);
            }
        }
    }
}