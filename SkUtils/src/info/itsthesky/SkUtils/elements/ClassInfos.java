package info.itsthesky.SkUtils.elements;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.classes.Serializer;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import ch.njol.yggdrasil.Fields;
import com.gmail.filoghost.holographicdisplays.api.Hologram;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideLayout;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BossBar;
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
                    public String toString(Hologram holo, int i) {
                        return holo.toString();
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
        Classes.registerClass(new ClassInfo<>(BossBar.class, "bossbar")
                .user("bossbars?")
                .name("BossBar")
                .description("Represents a Bukkit BossBar")
                .defaultExpression(new EventValueExpression<>(BossBar.class))
                .parser(new Parser<BossBar>() {

                    @Override
                    @Nullable
                    public BossBar parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toString(BossBar holo, int i) {
                        return holo.toString();
                    }

                    @Override
                    public String toVariableNameString(BossBar holo) {
                        return holo.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return ".+";
                    }

                }).serializer(new Serializer<BossBar>() {

                    @Override
                    public Fields serialize(BossBar holo) throws NotSerializableException {
                        Fields fields = new Fields();
                        return fields;
                    }

                    @Override
                    public BossBar deserialize(Fields fields) throws StreamCorruptedException {
                        //return new Raid(etc);
                        return null;
                    }

                    @Override
                    public void deserialize(BossBar plugin, Fields fields) throws StreamCorruptedException, NotSerializableException {
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
        Classes.registerClass(new ClassInfo<>(SlimefunGuideLayout.class, "guide")
                .user("guide")
                .name("guide")
                .description("Represents a SlimeFun guide's type (BOOK, CHEAT_SHEET or CHEST)")
                .defaultExpression(new EventValueExpression<>(SlimefunGuideLayout.class))
                .parser(new Parser<SlimefunGuideLayout>() {

                    @Override
                    @Nullable
                    public SlimefunGuideLayout parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toString(SlimefunGuideLayout holo, int i) {
                        return holo.toString();
                    }

                    @Override
                    public String toVariableNameString(SlimefunGuideLayout holo) {
                        return holo.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return ".+";
                    }

                }));
        Classes.registerClass(new ClassInfo<>(CustomItem.class, "customitem")
                .user("customitem")
                .name("customitem")
                .description("Represents a SlimeFun's custom item to use into Category's creation. Contain a material and a (colored) name.")
                .defaultExpression(new EventValueExpression<>(CustomItem.class))
                .parser(new Parser<CustomItem>() {

                    @Override
                    @Nullable
                    public CustomItem parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toString(CustomItem holo, int i) {
                        return holo.toString();
                    }

                    @Override
                    public String toVariableNameString(CustomItem holo) {
                        return holo.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return ".+";
                    }

                }));
        Classes.registerClass(new ClassInfo<>(NamespacedKey.class, "namespacedkey")
                .user("namespacedkey")
                .name("namespacedkey")
                .description("Represent NamespacedKey with unique ID based on the plugin (here, SkUtils) to register it. Used into most of SlimeFun's registration effects.")
                .defaultExpression(new EventValueExpression<>(NamespacedKey.class))
                .parser(new Parser<NamespacedKey>() {

                    @Override
                    @Nullable
                    public NamespacedKey parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toString(NamespacedKey holo, int i) {
                        return holo.toString();
                    }

                    @Override
                    public String toVariableNameString(NamespacedKey holo) {
                        return holo.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return ".+";
                    }

                }));
        Classes.registerClass(new ClassInfo<>(RecipeType.class, "recipetype")
                .user("recipetype")
                .name("recipetype")
                .description("Represent a SlimeFun recipe type. That's like the machine ID used into a new recipe system, as \"ENHANCED_CRAFTING_TABLE\" for example.")
                .defaultExpression(new EventValueExpression<>(RecipeType.class))
                .parser(new Parser<RecipeType>() {

                    @Override
                    @Nullable
                    public RecipeType parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toString(RecipeType holo, int i) {
                        return holo.toString();
                    }

                    @Override
                    public String toVariableNameString(RecipeType holo) {
                        return holo.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return ".+";
                    }

                }));
        Classes.registerClass(new ClassInfo<>(SlimefunItemStack.class, "slimefunitemstack")
                .user("slimefunitemstack")
                .name("slimefunitemstack")
                .description("Represent a SlimeFun ItemStack. That's the main item system (these items are used into category)")
                .defaultExpression(new EventValueExpression<>(SlimefunItemStack.class))
                .parser(new Parser<SlimefunItemStack>() {

                    @Override
                    @Nullable
                    public SlimefunItemStack parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toString(SlimefunItemStack holo, int i) {
                        return holo.toString();
                    }

                    @Override
                    public String toVariableNameString(SlimefunItemStack holo) {
                        return holo.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return ".+";
                    }

                }));
        Classes.registerClass(new ClassInfo<>(Category.class, "category")
                .user("category")
                .name("category")
                .description("Represent a SlimeFun Category.")
                .defaultExpression(new EventValueExpression<>(Category.class))
                .parser(new Parser<Category>() {

                    @Override
                    @Nullable
                    public Category parse(String input, ParseContext context) {
                        return null;
                    }

                    @Override
                    public boolean canParse(ParseContext context) {
                        return false;
                    }

                    @Override
                    public String toString(Category holo, int i) {
                        return holo.toString();
                    }

                    @Override
                    public String toVariableNameString(Category holo) {
                        return holo.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return ".+";
                    }

                }));
    }

}