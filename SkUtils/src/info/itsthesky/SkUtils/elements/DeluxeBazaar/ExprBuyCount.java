package info.itsthesky.SkUtils.elements.DeluxeBazaar;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.sedattr.bazaar.api.BazaarAPI;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

@Name("Bazaar Item Buy Count")
@Description("Return the total buy count of a specific item")
@Since("alpha-0.1")
@RequiredPlugins("DeluxeBazaar")
@Examples("bazaar buy count of \"COBBLESTONE\"")
public class ExprBuyCount extends SimpleExpression<Integer> {


    private Expression<String> item;

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
    protected Integer[] get(Event event) {
        final String i = item.getSingle(event);
        if (i != null) {
            return new Integer[] {new BazaarAPI().getBuyCount(i)};
        }
        return null;
    }
}