package info.itsthesky.SkUtils.elements.expressions;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Damage Dealt From Player")
@Description("Return damage dealt from a specific player")
@Since("alpha-0.1")
@Examples("total damage dealt of player")
public class ExprDamageDealt extends SimpleExpression<Integer> {


    private Expression<OfflinePlayer> player;

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
    protected Integer[] get(Event event) {
        OfflinePlayer p = player.getSingle(event);
        if (p != null) {
            return new Integer[] {p.getStatistic(Statistic.DAMAGE_DEALT)};
        }
        return null;
    }
}