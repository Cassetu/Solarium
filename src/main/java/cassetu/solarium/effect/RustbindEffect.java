package cassetu.solarium.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class RustbindEffect extends StatusEffect {
    public RustbindEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
        entity.getWorld().playSound(
                null, // No specific player to play for (plays for all nearby)
                entity.getX(),
                entity.getY(),
                entity.getZ(),
                SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE,
                SoundCategory.PLAYERS,
                0.5F, // Volume (0.0 to 1.0)
                0.8F + (float) Math.random() * 0.4F // Pitch (slightly randomized)
        );
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        // If entity is using shield, disable it temporarily
        if (entity instanceof PlayerEntity player && player.isUsingItem()) {
            if (player.getActiveItem().isOf(Items.SHIELD)) {
                player.stopUsingItem();
                player.getItemCooldownManager().set(Items.SHIELD, 20 * (2 + amplifier)); // 2-second cooldown + amplifier
            }
        }

        if (entity.getWorld().isClient) {
            this.spawnCustomParticles(entity, amplifier);
        }


        return true;
    }
    private void spawnCustomParticles(LivingEntity entity, int amplifier) {
        int particleCount = 3 + amplifier * 2;

        float width = entity.getWidth();
        float height = entity.getHeight();

        for (int i = 0; i < particleCount; i++) {
            double xOffset = (Math.random() - 0.5) * width * 1.5;
            double yOffset = Math.random() * height;
            double zOffset = (Math.random() - 0.5) * width * 1.5;



            entity.getWorld().addParticle(
                    ParticleTypes.CRIMSON_SPORE,
                    entity.getX() + xOffset,
                    entity.getY() + yOffset,
                    entity.getZ() + zOffset,
                    0.0, 0.0, 0.0
            );
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // Apply effect every 5 ticks for particles (4 times per second)
        return duration % 5 == 0;
    }

}