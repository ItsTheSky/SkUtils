package info.itsthesky.SkUtils.elements.musics;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
import java.io.File;

@Name("Play NoteBlockAPI Sound to Player")
@Description("Play a specific NBAPI song (located in `plugins/SkUtils/Songs/`) to a player")
@Since("alpha-0.1")
@RequiredPlugins("NoteBlockAPI")
@Examples("play song named \"test.nbs\" to the player")
public class EffPlaySound extends Effect {

    private Expression<Player> player;
    private Expression<String> sound;

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.sound = (Expression<String>) exprs[0];
        this.player = (Expression<Player>) exprs[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //Explaining this still below in the tutorial
        return null;
    }

    @Override
    protected void execute(Event event) {
        String s = sound.getSingle(event);
        Player p = player.getSingle(event);
        if (s != null && p != null) {
            Song song = NBSDecoder.parse(new File("plugins/SkUtils/Songs"));
            if (song == null) {
                Bukkit.getServer().getLogger().warning("[SkUtils] The songs file `plugins/SkUtils/Songs/" + s + ".nbs` cannot be found!");
                return;
            }
            RadioSongPlayer rsp = new RadioSongPlayer(song);
            rsp.addPlayer(p);
            rsp.setPlaying(true);
        }
    }
}