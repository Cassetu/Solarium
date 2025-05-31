package cassetu.solarium.item;

import cassetu.solarium.Solarium;
import cassetu.solarium.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SOLARIUM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Solarium.MOD_ID, "solarium_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.VERDANCY_CORE))
                    .displayName(Text.translatable("itemgroup.solarium.items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PLANT_FIBER);
                        entries.add(ModItems.PHOTOSYNTHETIC_FILAMENT);
                        entries.add(ModItems.VERDANCY_CORE);
                        entries.add(ModItems.OXYGEN_CONTAINER);
                        entries.add(ModItems.RADIANT_SILK);
                        entries.add(ModItems.LIVING_FIBER);
                        entries.add(ModItems.ECHO_PLATE);
                        entries.add(ModItems.ASHEN_REMNANTS);
                        entries.add(ModItems.PEARL_FRAGMENTS);

                    }).build());

    public static final ItemGroup SOLARIUM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Solarium.MOD_ID, "solarium_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PEDESTAL))
                    .displayName(Text.translatable("itemgroup.solarium.blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PEDESTAL);
                        entries.add(ModBlocks.GROWTH_CHAMBER);
                        entries.add(ModBlocks.BLIGHTED_SILT);
                        entries.add(ModBlocks.DISSOLVER);
                    }).build());


    public static void registerItemGroups() {
        Solarium.LOGGER.info("Registering Item Groups for " + Solarium.MOD_ID);
    }
}