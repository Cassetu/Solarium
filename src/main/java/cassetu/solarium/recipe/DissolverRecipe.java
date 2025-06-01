package cassetu.solarium.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record DissolverRecipe(Ingredient inputItem, ItemStack output) implements Recipe<DissolverRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    // read Recipe JSON files --> new DissolverRecipe

    @Override
    public boolean matches(DissolverRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(DissolverRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.DISSOLVER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.DISSOLVER_TYPE;
    }

    public static class Serializer implements RecipeSerializer<DissolverRecipe> {
        public static final MapCodec<DissolverRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(DissolverRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(DissolverRecipe::output)
        ).apply(inst, DissolverRecipe::new));

        public static final PacketCodec<RegistryByteBuf, DissolverRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, DissolverRecipe::inputItem,
                        ItemStack.PACKET_CODEC, DissolverRecipe::output,
                        DissolverRecipe::new);

        @Override
        public MapCodec<DissolverRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, DissolverRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
