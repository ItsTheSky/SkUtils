package info.itsthesky.SkUtils.elements.usbc;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import io.github.Leonardo0013YT.UltraSkills.api.UltraSkillsAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

@Name("USBC Set Player Stats")
@RequiredPlugins("UltraSkyBlock-Core")
@Description("Set the specific stats value of the player.\nAvailable stats : health, intelligence, shield, force, speed, critdamage, critchance")
@Since("alpha-0.2")
@Examples("usbc set stats \"speed\" of player to 50")
public class EffSetStats extends Effect {

    private Expression<Player> player;
    private Expression<String> station;
    private Expression<Number> value;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.station = (Expression<String>) exprs[0];
        this.player = (Expression<Player>) exprs[1];
        this.value = (Expression<Number>) exprs[2];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //Explaining this still below in the tutorial
        return null;
    }

    @Override
    protected void execute(Event event) {
        String s = station.getSingle(event);
        Player p = player.getSingle(event);
        Number v = value.getSingle(event);
        assert s != null;
        if (s.equalsIgnoreCase("health")) {
            UltraSkillsAPI.setHealth(p,v.intValue());
        } else if (s.equalsIgnoreCase("speed")) {
            UltraSkillsAPI.setSpeed(p,v.intValue());
        } else if (s.equalsIgnoreCase("CritDamage")) {
            UltraSkillsAPI.setCritChance(p,v.intValue());
        } else if (s.equalsIgnoreCase("intelligence")) {
            UltraSkillsAPI.setIntelligence(p,v.intValue());
        } else if (s.equalsIgnoreCase("shield")) {
            UltraSkillsAPI.setShield(p,v.intValue());
        } else if (s.equalsIgnoreCase("force")) {
            UltraSkillsAPI.setForce(p,v.intValue());
        } else {
            Bukkit.getConsoleSender().sendMessage("§8[§6SkUtils§8]§c Cannot found the USBC " + s + " stats !");
        }
    }
}