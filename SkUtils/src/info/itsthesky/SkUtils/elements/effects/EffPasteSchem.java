package info.itsthesky.SkUtils.elements.effects;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Event;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.math.BlockVector3;

import java.io.File;
import java.io.IOException;

import javax.annotation.Nullable;

@Name("Paste Schematics")
@Description("Paste a specific FAWE or WE schematic to location")
@Since("alpha-0.4")
@Examples("paste schem \"plugins/FastAsyncWorldEdit/schematics/house.schem\" at player's location including air true")
public class EffPasteSchem extends Effect {

    private Expression<String> schem;
    private Expression<Location> location;
    private Expression<Boolean> isair;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.schem = (Expression<String>) exprs[0];
        this.location = (Expression<Location>) exprs[1];
        this.isair = (Expression<Boolean>) exprs[2];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //Explaining this still below in the tutorial
        return null;
    }

    @Override
    protected void execute(Event event) {
        Location loc = location.getSingle(event);
        String s = schem.getSingle(event);
        Boolean air = isair.getSingle(event);
        if (loc != null) {
            if (s != null) {
                File schematic = new File(s);
                BlockVector3 bv3 = BlockVector3.at(loc.getX(), loc.getY(), loc.getZ());
                if (!schematic.exists()) {
                    Bukkit.getConsoleSender().sendMessage("§c[SkUtils] The schematic file `§4" + s.toString() + "`§ccannot be found on server folder!");
                    return;
                }
                if (schematic.toString().contains(".schematic")) {
                    Bukkit.getConsoleSender().sendMessage("§c[SkUtils] Please, rename every schematics with `schem` extension instead of `schematic` in order for this effect to work fine!");
                    return;
                }
                try {
                    ClipboardFormats.findByFile(schematic).load(schematic).paste(new BukkitWorld(loc.getWorld()), bv3, true, air, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}