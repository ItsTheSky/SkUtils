package info.itsthesky.SkUtils.elements;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.classes.Serializer;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ch.njol.yggdrasil.Fields;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;
import java.io.NotSerializableException;
import java.io.StreamCorruptedException;

public class ClassInfos {

    public static void registerTypes() {
        Classes.registerClass(new ClassInfo<>(Plugin.class, "plugin")
                .user("plugins?")
                .name("Plugin")
                .description("Represents an installed and loaded server plugin")
                .defaultExpression(new EventValueExpression<>(Plugin.class))
                .parser(new Parser<Plugin>() {

                    @Override
                    @Nullable
                    public Plugin parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toString(Plugin plugin, int i) {
                        return null;
                    }

                    @Override
                    public String toVariableNameString(Plugin plugin) {
                        return plugin.getName();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return ".+";
                    }

                }).serializer(new Serializer<Plugin>() {

                    @Override
                    public Fields serialize(Plugin plugin) throws NotSerializableException {
                        Fields fields = new Fields();
                        fields.putPrimitive("name", plugin.getName());
                        fields.putPrimitive("config", plugin.getConfig());
                        fields.putPrimitive("loader", plugin.getPluginLoader());
                        fields.putPrimitive("folder", plugin.getDataFolder());
                        fields.putPrimitive("description", plugin.getDescription());
                        return fields;
                    }

                    @Override
                    public Plugin deserialize(Fields fields) throws StreamCorruptedException {
                        //return new Raid(etc);
                        return null;
                    }

                    @Override
                    public void deserialize(Plugin plugin, Fields fields) throws StreamCorruptedException, NotSerializableException {
                        assert false;
                    }

                    @Override
                    public boolean mustSyncDeserialization() {
                        return true;
                    }

                    @Override
                    protected boolean canBeInstantiated() {
                        return false;
                    }

                }));

        Classes.registerClass(new ClassInfo<>(Hologram.class, "hologram")
                .user("hologram")
                .name("Hologram")
                .description("Represents a HolographicDisplays Hologram")
                .defaultExpression(new EventValueExpression<>(Hologram.class))
                .parser(new Parser<Hologram>() {

                    @Override
                    @Nullable
                    public Hologram parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toString(Hologram plugin, int i) {
                        return null;
                    }

                    @Override
                    public String toVariableNameString(Hologram holo) {
                        return holo.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return ".+";
                    }

                }).serializer(new Serializer<Hologram>() {

                    @Override
                    public Fields serialize(Hologram holo) throws NotSerializableException {
                        Fields fields = new Fields();
                        fields.putPrimitive("location", holo.getLocation());
                        fields.putPrimitive("height", holo.getHeight());
                        fields.putPrimitive("world", holo.getWorld());
                        fields.putPrimitive("size", holo.size());
                        return fields;
                    }

                    @Override
                    public Hologram deserialize(Fields fields) throws StreamCorruptedException {
                        //return new Raid(etc);
                        return null;
                    }

                    @Override
                    public void deserialize(Hologram plugin, Fields fields) throws StreamCorruptedException, NotSerializableException {
                        assert false;
                    }

                    @Override
                    public boolean mustSyncDeserialization() {
                        return true;
                    }

                    @Override
                    protected boolean canBeInstantiated() {
                        return false;
                    }

                }));
    }

}