package io.github.yuko1101.enhancedgoldenapples.mixin.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {
    @ModifyArg(method = "tryUseTotem", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;)Z"))
    private StatusEffectInstance injectedEffect(StatusEffectInstance effect) {
        final int duration;
        final int amplifier;
        if (effect.getEffectType() == StatusEffects.REGENERATION) {
            duration = 40;
            amplifier = 5;
        } else if (effect.getEffectType() == StatusEffects.ABSORPTION) {
            duration = effect.getDuration();
            amplifier = 2;
        } else {
            duration = effect.getDuration();
            amplifier = effect.getAmplifier();
        }
        return new StatusEffectInstance(effect.getEffectType(), duration, amplifier);
    }
}