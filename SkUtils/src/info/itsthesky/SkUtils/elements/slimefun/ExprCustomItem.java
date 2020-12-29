package info.itsthesky.SkUtils.elements.slimefun;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import info.itsthesky.SkUtils.SkUtils;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;


@Name("New CustomItem")
@Description("Create and return new SlimeFun's CustomItem with itemstack (only material & name are used)")
@Since("alpha-0.4")
@Examples("set {_ci} to new customitem with iron ingot named \"&6Best &eCategory &c:D\"")
public class ExprCustomItem extends SimpleExpression<CustomItem> {

    private Expression<ItemStack> material;

    @Override
    public Class<? extends CustomItem> getReturnType() {
        return CustomItem.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.material = (Expression<ItemStack>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected CustomItem[] get(Event event) {
        ItemStack m = material.getSingle(event);
        String name = null;
        if (m != null) {
            if (m.getItemMeta().getDisplayName() == null) {
                name = "Default Category Name";
            } else {
                name = m.getItemMeta().getDisplayName();
            }
            CustomItem ci = new CustomItem(m.getType(), name);
            return new CustomItem[] {ci};
        }
        return new CustomItem[0];
    }
}