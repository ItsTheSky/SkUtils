package info.itsthesky.SkUtils.elements.slimefun;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideLayout;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;

import javax.annotation.Nullable;


@Name("Register SlimeFun Category")
@RequiredPlugins("Slimefun")
@Description("Register a new SlimeFun category with NamespacedKey and CustomItem and return it.")
@Since("alpha-0.4")
@Examples("set {_category} to new category with id nsk \"cool_category\" and with item customitem with iron ingot named \"&6My Cool &e&lCategory &6:D\"")
public class ExprNewCategory extends SimpleExpression<Category> {

    private Expression<NamespacedKey> nsk;
    private Expression<CustomItem> ci;

    @Override
    public Class<? extends Category> getReturnType() {
        return Category.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.nsk = (Expression<NamespacedKey>) exprs[0];
        this.ci = (Expression<CustomItem>) exprs[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected Category[] get(Event event) {
        NamespacedKey n = nsk.getSingle(event);
        CustomItem c = ci.getSingle(event);
        if (n != null && c != null) {
            Category cat = new Category(n, c);
            return new Category[] {cat};
        }
        return new Category[0];
    }
}