package info.itsthesky.SkUtils.elements.slimefun;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import info.itsthesky.SkUtils.SkUtils;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.io.File;

@Name("Register SlimeFun Item")
@Description("Register new SlimeFun item with the choosed category, RecipeType, recipe items and SlimeFunItemStack.")
@Since("alpha-0.4")
@RequiredPlugins("Slimefun")
@Examples("register slimefun item {_sfitemstack} in category {_cat} with recipe type {_recipetype} and recipe with air, stick, air, stick, diamond block, stick, air, stick and air")
public class EffRegisterSFItem extends Effect {

    private Expression<SlimefunItemStack> itemstack;
    private Expression<Category> category;
    private Expression<RecipeType> type;
    private Expression<ItemStack[]> recipe;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.itemstack = (Expression<SlimefunItemStack>) exprs[0];
        this.category = (Expression<Category>) exprs[1];
        this.type = (Expression<RecipeType>) exprs[2];
        this.recipe = (Expression<ItemStack[]>) exprs[3];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //Explaining this still below in the tutorial
        return null;
    }

    @Override
    protected void execute(Event event) {
        if (itemstack.getSingle(event) != null || category.getSingle(event) != null || type.getSingle(event) != null || recipe.getSingle(event) != null) {
            SlimefunItem sfItem = new SlimefunItem(category.getSingle(event), itemstack.getSingle(event), type.getSingle(event), recipe.getSingle(event));
            sfItem.register((SlimefunAddon) SkUtils.getInstance());
        }
    }
}