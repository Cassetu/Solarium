package cassetu.solarium.potion;

import cassetu.solarium.Solarium;
import cassetu.solarium.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> RUSTBIND_POTION = registerPotion("rustbind_potion",
            new Potion(new StatusEffectInstance(ModEffects.RUSTBIND, 1200, 0)));

    public static final RegistryEntry<Potion> BLIGHT_POTION = registerPotion("blight_potion",
            new Potion(new StatusEffectInstance(ModEffects.BLIGHTROT, 900, 0)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(Solarium.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        Solarium.LOGGER.info("Registering Mod Potions for " + Solarium.MOD_ID);
    }
}
