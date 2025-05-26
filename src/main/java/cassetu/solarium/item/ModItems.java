package cassetu.solarium.item;

import cassetu.solarium.Solarium;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item PHOTOSYNTHETIC_FILAMENT = registerItem("photosynthetic_filament", new Item(new Item.Settings()));
    public static final Item VERDANCY_CORE = registerItem("verdancy_core", new Item(new Item.Settings()));
    public static final Item OXYGEN_CONTAINER = registerItem("oxygen_container", new Item(new Item.Settings()));
    public static final Item PLANT_FIBER= registerItem("plant_fiber", new Item(new Item.Settings()));
    public static final Item ECHO_PLATE= registerItem("echo_plate", new Item(new Item.Settings()));
    public static final Item LIVING_FIBER = registerItem("living_fiber", new Item(new Item.Settings()));
    public static final Item RADIANT_SILK = registerItem("radiant_silk", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Solarium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Solarium.LOGGER.info("Registering Mod Items for " + Solarium.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PHOTOSYNTHETIC_FILAMENT);
            entries.add(VERDANCY_CORE);
            entries.add(OXYGEN_CONTAINER);
            entries.add(PLANT_FIBER);
        });
    }
}
