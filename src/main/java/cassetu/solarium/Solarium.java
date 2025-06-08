package cassetu.solarium;

import cassetu.solarium.block.ModBlocks;
import cassetu.solarium.block.entity.ModBlockEntities;
import cassetu.solarium.effect.ModEffects;
import cassetu.solarium.item.ModItemGroups;
import cassetu.solarium.item.ModItems;
import cassetu.solarium.potion.ModPotions;
import cassetu.solarium.recipe.ModRecipes;
import cassetu.solarium.sound.ModSounds;
import cassetu.solarium.util.ModLootTableModifiers;
import cassetu.solarium.util.ModTags;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Solarium implements ModInitializer {
	public static final String MOD_ID = "solarium";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModLootTableModifiers.modifyLootTables();
		ModBlockEntities.registerBlockEntities();
		ModRecipes.registerRecipes();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModSounds.registerSounds();

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.BLIGHTED_SILT_DUST, ModPotions.BLIGHT_POTION);
			builder.registerPotionRecipe(ModPotions.BLIGHT_POTION, ModItems.PHOTOSYNTHETIC_FILAMENT, ModPotions.RUSTBIND_POTION);
		});

	}
}