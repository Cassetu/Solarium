package cassetu.solarium.block;

import cassetu.solarium.Solarium;
import cassetu.solarium.block.custom.DissolverBlock;
import cassetu.solarium.block.custom.GrowthChamberBlock;
import cassetu.solarium.block.custom.PedestalBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BLIGHTED_SILT = registerBlock("blighted_silt",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.SOUL_SAND)));

    public static final Block CHARRED_RESIDUUM = registerBlock("charred_residuum",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE)));

    public static final Block MOLTEN_RESIDUUM = registerBlock("molten_residuum",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE)));

    public static final Block DISSOLVER = registerBlock("dissolver",
            new DissolverBlock(AbstractBlock.Settings.create()));

    public static final Block PEDESTAL = registerBlock("pedestal",
            new PedestalBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block GROWTH_CHAMBER = registerBlock("growth_chamber",
            new GrowthChamberBlock(AbstractBlock.Settings.create()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Solarium.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Solarium.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Solarium.LOGGER.info("Registering Mod Blocks for " + Solarium.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.BLIGHTED_SILT);
        });
    }
}