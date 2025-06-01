package cassetu.solarium.datagen;

import cassetu.solarium.Solarium;
import cassetu.solarium.block.ModBlocks;
import cassetu.solarium.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> RESIDUUM_SMELTABLES = List.of(ModBlocks.CHARRED_RESIDUUM,
                ModBlocks.MOLTEN_RESIDUUM);

        offerSmelting(exporter, RESIDUUM_SMELTABLES, RecipeCategory.MISC, ModItems.ASHEN_REMNANTS, 0.05f, 500, "residuum");
        offerBlasting(exporter, RESIDUUM_SMELTABLES, RecipeCategory.MISC, ModItems.ASHEN_REMNANTS, 0.05f, 250, "residuum");

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VERDANCY_CORE, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PHOTOSYNTHETIC_FILAMENT)
                .pattern(" SP")
                .pattern(" PI")
                .pattern("   ")
                .input('P', ModItems.PLANT_FIBER)
                .input('S', Items.STRING)
                .input('I', Items.IRON_NUGGET)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion(hasItem(ModItems.PLANT_FIBER), conditionsFromItem(ModItems.PLANT_FIBER))
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PEDESTAL)
                .pattern(" M ")
                .pattern(" C ")
                .pattern("MMM")
                .input('M', Items.SMOOTH_STONE_SLAB)
                .input('C', Items.COBBLESTONE)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.SMOOTH_STONE_SLAB), conditionsFromItem(Items.SMOOTH_STONE_SLAB))
                .offerTo(exporter);

        //ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VERDANCY_CORE, 9)
        //        .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
        //        .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
        //        .offerTo(exporter);
    }
}
