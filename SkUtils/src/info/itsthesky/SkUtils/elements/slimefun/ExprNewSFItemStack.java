package info.itsthesky.SkUtils.elements.slimefun;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;


@Name("New SlimeFun ItemStack")
@Description("Create and return new SlimeFun's ItemStack with name, material and lore. Used as item which are into SlimeFun's Categories.")
@Since("alpha-0.4")
@Examples("set {_sfitemstack} to new sf itemstack based on iron sword named \"&6My Best &c&lSword\" with lore \"&7This is the best sword you can\" and \"&7ever crated ans use !\"")
public class ExprNewSFItemStack extends SimpleExpression<SlimefunItemStack> {

    private Expression<ItemStack> material;

    @Override
    public Class<? extends SlimefunItemStack> getReturnType() {
        return SlimefunItemStack.class;
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
    protected SlimefunItemStack[] get(Event event) {
        ItemStack m = material.getSingle(event);
        String name = null;
        String[] lore = null;
        if (m != null) {
            if (m.getItemMeta().getDisplayName() == null) {
                name = "Default Category Name";
            } else {
                name = m.getItemMeta().getDisplayName();
            }
            if (m.getItemMeta().getLore() == null) {
                lore = new String[] {"Default Category Name"};
            } else {
                lore = m.getItemMeta().getLore().toArray(new String[0]);
            }
            SlimefunItemStack ci = new SlimefunItemStack(name.toUpperCase(), m.getType(), String.valueOf(lore));
            return new SlimefunItemStack[] {ci};
        }
        return new SlimefunItemStack[0];
    }
}