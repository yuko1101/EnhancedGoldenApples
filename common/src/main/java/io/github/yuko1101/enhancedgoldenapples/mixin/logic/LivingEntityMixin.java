package io.github.yuko1101.enhancedgoldenapples.mixin.logic;

import io.github.yuko1101.enhancedgoldenapples.EnhancedGoldenApples;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Shadow @Final private AttributeContainer attributes;

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getMaxHealth()F"))
    private void init(EntityType<?> entityType, World world, CallbackInfo ci) {
        if (((LivingEntity)(Object) this) instanceof PlayerEntity player) {
            var maxHealth = this.attributes.getCustomInstance(EntityAttributes.MAX_HEALTH);
            if (maxHealth != null) {
                maxHealth.addPersistentModifier(EnhancedGoldenApples.HEALTH_BOOST);
            }

            player.setGlowing(true);
        }
    }
}
