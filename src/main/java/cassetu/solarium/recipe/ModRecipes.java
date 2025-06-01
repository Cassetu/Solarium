package cassetu.solarium.recipe;

import cassetu.solarium.Solarium;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<GrowthChamberRecipe> GROWTH_CHAMBER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Solarium.MOD_ID, "growth_chamber"),
                    new GrowthChamberRecipe.Serializer());
    public static final RecipeType<GrowthChamberRecipe> GROWTH_CHAMBER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Solarium.MOD_ID, "growth_chamber"), new RecipeType<GrowthChamberRecipe>() {
                @Override
                public String toString() {
                    return "growth_chamber";
                }
            });

    public static final RecipeSerializer<DissolverRecipe> DISSOLVER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Solarium.MOD_ID, "dissolver"),
            new DissolverRecipe.Serializer());
    public static final RecipeType<DissolverRecipe> DISSOLVER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Solarium.MOD_ID, "dissolver"), new RecipeType<DissolverRecipe>() {
                @Override
                public String toString() {
                    return "dissolver";
                }
            });


    public static void registerRecipes() {
        Solarium.LOGGER.info("Registering Custom Recipes for " + Solarium.MOD_ID);
    }
}
