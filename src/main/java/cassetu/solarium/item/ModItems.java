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

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Solarium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Solarium.LOGGER.info("Registering Mod Items for " + Solarium.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PHOTOSYNTHETIC_FILAMENT);
            entries.add(VERDANCY_CORE);
        });
    }
}
