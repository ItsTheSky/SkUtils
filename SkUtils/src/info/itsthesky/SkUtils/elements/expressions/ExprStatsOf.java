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

@Name("Stats of Player")
@Description("Return the minecraft statistic of the specific player")
@Since("alpha-0.3")
@Examples("play time of player")
public class ExprStatsOf extends SimpleExpression<Object> {

    private Expression<Statistic> stats;
    private Expression<OfflinePlayer> player;

    @Override
    public Class<? extends Object> getReturnType() {
        return Object.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.stats = (Expression<Statistic>) exprs[0];
        this.player = (Expression<OfflinePlayer>) exprs[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected Object[] get(Event event) {
        OfflinePlayer p = player.getSingle(event);
        Statistic s = stats.getSingle(event);
        if (p != null) {
            if (s != null) {
                return new Object[] {p.getStatistic(s)};
            }
            return new Object[0];
        }
        return null;
    }
}