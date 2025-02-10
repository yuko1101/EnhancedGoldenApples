package io.github.yuko1101.enhancedgoldenapples.mixin.logic;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getMaxHealth()F"))
    private void init(EntityType<?> entityType, World world, CallbackInfo ci) {
        if (((LivingEntity)(Object) this) instanceof PlayerEntity player) {
            player.setGlowing(true);
        }
    }
}
