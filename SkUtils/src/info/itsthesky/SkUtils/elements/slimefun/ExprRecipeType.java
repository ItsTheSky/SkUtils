package info.itsthesky.SkUtils.elements.slimefun;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;


@Name("SlimeFun Recipe Type")
@RequiredPlugins("Slimefun")
@Description("Return the formated value of SlimeFun recipe's type")
@Since("alpha-0.4")
@Examples("set {_recipetype} to slimefun recipe type \"ENHANCED_CRAFTING_TABLE\"")
public class ExprRecipeType extends SimpleExpression<RecipeType> {

    private Expression<String> type;

    @Override
    public Class<? extends RecipeType> getReturnType() {
        return RecipeType.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.type = (Expression<String>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected RecipeType[] get(Event event) {
        if (type.getSingle(event) != null) {
            List<String> types = Arrays.asList("MULTIBLOCK", "ARMOR_FORGE", "GRIND_STONE", "SMELTERY", "ORE_CRUSHER", "GOLD_PAN", "COMPRESSOR", "PRESSURE_CHAMBER", "MAGIC_WORKBENCH", "ORE_WASHER", "ENHANCED_CRAFTING_TABLE", "JUICER", "ANCIENT_ALTAR", "MOB_DROP", "BARTER_DROP", "HEATED_PRESSURE_CHAMBER", "FOOD_FABRICATOR", "FOOD_COMPOSTER", "FREEZER", "REFINERY", "GEO_MINER", "NUCLEAR_REACTOR");
            if (!types.contains(type)) {
                Bukkit.getConsoleSender().sendMessage("§c[SkUtils] Cannot found valid RecipeType ID for `§4" + type + "§c`, check docs for all possible IDs !");
                return new RecipeType[0];
            }
            RecipeType f = null;
            if (type.getSingle(event).equalsIgnoreCase("MULTIBLOCK")) { f = RecipeType.MULTIBLOCK; }
            if (type.getSingle(event).equalsIgnoreCase("ARMOR_FORGE")) { f = RecipeType.ARMOR_FORGE; }
            if (type.getSingle(event).equalsIgnoreCase("GRIND_STONE")) { f = RecipeType.GRIND_STONE; }
            if (type.getSingle(event).equalsIgnoreCase("SMELTERY")) { f = RecipeType.SMELTERY; }
            if (type.getSingle(event).equalsIgnoreCase("ORE_CRUSHER")) { f = RecipeType.ORE_CRUSHER; }
            if (type.getSingle(event).equalsIgnoreCase("GOLD_PAN")) { f = RecipeType.GOLD_PAN; }
            if (type.getSingle(event).equalsIgnoreCase("COMPRESSOR")) { f = RecipeType.COMPRESSOR; }
            if (type.getSingle(event).equalsIgnoreCase("PRESSURE_CHAMBER")) { f = RecipeType.PRESSURE_CHAMBER; }
            if (type.getSingle(event).equalsIgnoreCase("MAGIC_WORKBENCH")) { f = RecipeType.MAGIC_WORKBENCH; }
            if (type.getSingle(event).equalsIgnoreCase("ORE_WASHER")) { f = RecipeType.ORE_WASHER; }
            if (type.getSingle(event).equalsIgnoreCase("ENHANCED_CRAFTING_TABLE")) { f = RecipeType.ENHANCED_CRAFTING_TABLE; }
            if (type.getSingle(event).equalsIgnoreCase("JUICER")) { f = RecipeType.JUICER; }
            if (type.getSingle(event).equalsIgnoreCase("ANCIENT_ALTAR")) { f = RecipeType.ANCIENT_ALTAR; }
            if (type.getSingle(event).equalsIgnoreCase("MOB_DROP")) { f = RecipeType.MOB_DROP; }
            if (type.getSingle(event).equalsIgnoreCase("BARTER_DROP")) { f = RecipeType.BARTER_DROP; }
            if (type.getSingle(event).equalsIgnoreCase("HEATED_PRESSURE_CHAMBER")) { f = RecipeType.HEATED_PRESSURE_CHAMBER; }
            if (type.getSingle(event).equalsIgnoreCase("FOOD_FABRICATOR")) { f = RecipeType.FOOD_FABRICATOR; }
            if (type.getSingle(event).equalsIgnoreCase("FOOD_COMPOSTER")) { f = RecipeType.FOOD_COMPOSTER; }
            if (type.getSingle(event).equalsIgnoreCase("FREEZER")) { f = RecipeType.FREEZER; }
            if (type.getSingle(event).equalsIgnoreCase("REFINERY")) { f = RecipeType.REFINERY; }
            if (type.getSingle(event).equalsIgnoreCase("GEO_MINER")) { f = RecipeType.GEO_MINER; }
            if (type.getSingle(event).equalsIgnoreCase("NUCLEAR_REACTOR")) { f = RecipeType.NUCLEAR_REACTOR; }
            return new RecipeType[] {f};
        }
        return new RecipeType[0];
    }
}