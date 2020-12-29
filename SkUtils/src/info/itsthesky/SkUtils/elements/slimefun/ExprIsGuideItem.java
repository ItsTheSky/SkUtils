package info.itsthesky.SkUtils.elements.slimefun;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuide;

import javax.annotation.Nullable;


@Name("SlimeFun Guide Item")
@RequiredPlugins("Slimefun")
@Description("Return true if the specified item is a slimefun book, else false.")
@Since("alpha-0.4")
@Examples("item player's tool is slimefun guide")
public class ExprIsGuideItem extends SimpleExpression<Boolean> {

    private Expression<ItemStack> item;

    @Override
    public Class<? extends Boolean> getReturnType() {
        return Boolean.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.item = (Expression<ItemStack>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected Boolean[] get(Event event) {
        return new Boolean[] {SlimefunGuide.isGuideItem(item.getSingle(event))};
    }
}