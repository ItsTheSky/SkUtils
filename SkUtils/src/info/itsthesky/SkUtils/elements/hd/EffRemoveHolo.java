package info.itsthesky.SkUtils.elements.hd;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Remove Hologram")
@Description("Remove a HolographicDisplays hologram (CANNOT BE UNDONE)")
@Since("alpha-0.3")
@RequiredPlugins("HolographicDisplays")
@Examples("delete holo {_holo}")
public class EffRemoveHolo extends Effect {

    private Expression<Hologram> holo;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.holo = (Expression<Hologram>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //Explaining this still below in the tutorial
        return null;
    }

    @Override
    protected void execute(Event event) {
        Hologram h = holo.getSingle(event);
        if (h != null) {
            h.delete();
        }
    }
}