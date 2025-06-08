package cassetu.solarium.datagen;

import cassetu.solarium.block.ModBlocks;
import cassetu.solarium.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GROWTH_CHAMBER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLIGHTED_SILT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DISSOLVER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOLTEN_RESIDUUM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHARRED_RESIDUUM);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.VERDANCY_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ECHO_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RADIANT_SILK, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIVING_FIBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PHOTOSYNTHETIC_FILAMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OXYGEN_CONTAINER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLANT_FIBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASHEN_REMNANTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEARL_FRAGMENTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLIGHTED_SILT_DUST, Models.GENERATED);

    }
}
