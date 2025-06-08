package cassetu.solarium.effect;

import cassetu.solarium.Solarium;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> RUSTBIND = registerStatusEffect("rustbind",
            new RustbindEffect(StatusEffectCategory.HARMFUL, 0x8B4513) // Brown rust color
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED,
                            Identifier.of(Solarium.MOD_ID, "rustbind"), -0.5f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> BLIGHTROT = registerStatusEffect("blightrot",
            new BlightRotEffect(StatusEffectCategory.HARMFUL, 0x5A3E4F)
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_ABSORPTION,
                            Identifier.of(Solarium.MOD_ID, "blightrot"), -20f,
                            EntityAttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,
                            Identifier.of(Solarium.MOD_ID, "blightrot"), -0.2f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));



    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Solarium.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Solarium.LOGGER.info("Registering Mod Effects for " + Solarium.MOD_ID);
    }
}
