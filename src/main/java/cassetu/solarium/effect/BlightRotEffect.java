package cassetu.solarium.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.UUID;

public class BlightRotEffect extends StatusEffect {

    public BlightRotEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public void onApplied(LivingEntity entity, AttributeContainer attributes) {
        // Play a sound effect when the effect is applied
        if (entity.getWorld().isClient && entity instanceof PlayerEntity) {
            entity.getWorld().playSound(
                    (PlayerEntity) entity,
                    entity.getX(),
                    entity.getY(),
                    entity.getZ(),
                    SoundEvents.BLOCK_SLIME_BLOCK_STEP,
                    SoundCategory.PLAYERS,
                    1.0F,
                    0.5F
            );
        }
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        spawnCustomParticles(entity, amplifier);
        return true;
    }

    private void spawnCustomParticles(LivingEntity entity, int amplifier) {
        // Spawn particles around the affected entity
        if (entity.getWorld().isClient) {
            for (int i = 0; i < 3 + amplifier; i++) {
                double d0 = entity.getRandom().nextGaussian() * 0.1D;
                double d1 = entity.getRandom().nextGaussian() * 0.1D;
                double d2 = entity.getRandom().nextGaussian() * 0.1D;

                entity.getWorld().addParticle(
                        ParticleTypes.ASH,
                        entity.getParticleX(0.5D),
                        entity.getRandomBodyY(),
                        entity.getParticleZ(0.5D),
                        d0, d1, d2
                );
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // Apply the effect on every tick for particles
        return true;
    }
}