package info.itsthesky.SkUtils.elements.hd;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import org.bukkit.Location;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Teleport Hologram")
@Description("Teleport a HolographicDisplays to a location")
@Since("alpha-0.3")
@RequiredPlugins("HolographicDisplays")
@Examples("teleport holo {_holo} to player's location")
public class EffTeleportHolo extends Effect {

    private Expression<Hologram> holo;
    private Expression<Location> location;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.holo = (Expression<Hologram>) exprs[0];
        this.location = (Expression<Location>) exprs[1];
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
        Location loc = location.getSingle(event);
        if (h != null) {
            if (loc != null) {
                h.teleport(loc);
            }
        }
    }
}