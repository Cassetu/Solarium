package cassetu.solarium;

import cassetu.solarium.block.ModBlocks;
import cassetu.solarium.block.entity.ModBlockEntities;
import cassetu.solarium.item.ModItemGroups;
import cassetu.solarium.item.ModItems;
import cassetu.solarium.util.ModLootTableModifiers;
import cassetu.solarium.util.ModTags;
import net.fabricmc.api.ModInitializer;

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
	}
}