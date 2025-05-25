package cassetu.solarium.datagen;

import cassetu.solarium.Solarium;
import cassetu.solarium.block.ModBlocks;
import cassetu.solarium.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
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
        //List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.VERDANCY_CORE, ModBlocks.PINK_GARNET_ORE,
        //        ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        //offerSmelting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.VERDANCY_CORE, 0.25f, 200, "pink_garnet");
        //offerBlasting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.VERDANCY_CORE, 0.25f, 100, "pink_garnet");

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VERDANCY_CORE, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

        //ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
        //        .pattern("RRR")
        //        .pattern("RRR")
        //        .pattern("RRR")
        //        .input('R', ModItems.VERDANCY_CORE)
        //        .criterion(hasItem(ModItems.VERDANCY_CORE), conditionsFromItem(ModItems.VERDANCY_CORE))
        //        .offerTo(exporter);

        //ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VERDANCY_CORE, 9)
        //        .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
        //        .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
        //        .offerTo(exporter);
    }
}
