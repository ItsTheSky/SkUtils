package info.itsthesky.SkUtils.elements.DeluxeBazaar;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.sedattr.bazaar.api.BazaarAPI;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("Bazaar Item Sell Price")
@Description("Return the sell price of a specific item")
@Since("alpha-0.1")
@RequiredPlugins("DeluxeBazaar")
@Examples("bazaar sell price of \"COBBLESTONE\" ")
public class ExprSellPrice extends SimpleExpression<Double> {


    private Expression<String> item;

    @Override
    public Class<? extends Double> getReturnType() {
        return Double.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.item = (Expression<String>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected Double[] get(Event event) {
        final String i = item.getSingle(event);
        if (i != null) {
            return new Double[] {new BazaarAPI().getSellPrice(i)};
        }
        return null;
    }
}