package info.itsthesky.SkUtils.elements.hd;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Add Hologram Line")
@Description("Add a new line to an HolographicDisplays Hologram")
@Since("alpha-0.3")
@RequiredPlugins("HolographicDisplays")
@Examples("add new line \"&3Line &b:D\" to holo {_holo}")
public class EffAddLine extends Effect {

    private Expression<String> text;
    private Expression<Hologram> holo;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.text = (Expression<String>) exprs[0];
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
        String t = text.getSingle(event);
        Hologram h = holo.getSingle(event);
        if (h != null) {
            if (t != null) {
                h.appendTextLine(t);
            }
        }
    }
}