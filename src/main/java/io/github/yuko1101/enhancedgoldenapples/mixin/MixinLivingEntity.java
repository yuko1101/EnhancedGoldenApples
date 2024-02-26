package io.github.yuko1101.enhancedgoldenapples.mixin;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {
    @ModifyArg(method = "checkTotemDeathProtection", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;addEffect(Lnet/minecraft/world/effect/MobEffectInstance;)Z"))
    private MobEffectInstance injectedEffect(MobEffectInstance effect) {
        final int amplifier;
        if (effect.getEffect() == MobEffects.REGENERATION) {
            amplifier = 3;
        } else if (effect.getEffect() == MobEffects.ABSORPTION) {
            amplifier = 2;
        } else {
            amplifier = effect.getAmplifier();
        }
        return new MobEffectInstance(effect.getEffect(), effect.getDuration(), amplifier);
    }
}
