package info.itsthesky.SkUtils.elements.expressions;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.util.Timespan;
import ch.njol.util.Kleenean;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;
import org.bukkit.Statistic;

import javax.annotation.Nullable;

@Name("Play Time of Player")
@Description("Return the play time of specific player")
@Since("alpha-0.1")
@Examples("play time of player")
public class ExprPlayTime extends SimpleExpression<Timespan> {


    private Expression<OfflinePlayer> player;

    @Override
    public Class<? extends Timespan> getReturnType() {
        return Timespan.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.player = (Expression<OfflinePlayer>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected Timespan[] get(Event event) {
        OfflinePlayer p = player.getSingle(event);
        if (p != null) {
            return new Timespan[] {Timespan.fromTicks_i(p.getStatistic(Statistic.PLAY_ONE_MINUTE))};
        }
        return null;
    }
}