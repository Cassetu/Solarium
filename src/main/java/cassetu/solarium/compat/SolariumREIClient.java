package cassetu.solarium.compat;

import cassetu.solarium.block.ModBlocks;
import cassetu.solarium.recipe.GrowthChamberRecipe;
import cassetu.solarium.recipe.ModRecipes;
import cassetu.solarium.screen.custom.GrowthChamberScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class SolariumREIClient implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new GrowthChamberCategory());

        registry.addWorkstations(GrowthChamberCategory.GROWTH_CHAMBER, EntryStacks.of(ModBlocks.GROWTH_CHAMBER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(GrowthChamberRecipe.class, ModRecipes.GROWTH_CHAMBER_TYPE,
                GrowthChamberDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                ((screen.height - 166) / 2) + 30, 20, 25), GrowthChamberScreen.class,
                GrowthChamberCategory.GROWTH_CHAMBER);
    }
}
