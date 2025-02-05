package io.github.yuko1101.enhancedgoldenapples.mixin.logic;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerManager.class)
public abstract class PlayerManagerMixin {
    @Unique
    private static final Identifier HEALTH_BOOST_ID = Identifier.of("enhancedgoldenapples", "health_boost");
    @Unique
    private static final EntityAttributeModifier HEALTH_BOOST = new EntityAttributeModifier(HEALTH_BOOST_ID, 20.0, EntityAttributeModifier.Operation.ADD_VALUE);

    @ModifyArg(method = "respawnPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;setHealth(F)V"), index = 0)
    private float setHealth(float health) {
        return 1.0F;
    }

    @Inject(method = "respawnPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;setHealth(F)V"))
    private void respawnPlayer(ServerPlayerEntity player, boolean alive, Entity.RemovalReason removalReason, CallbackInfoReturnable<ServerPlayerEntity> cir, @Local(ordinal = 1) ServerPlayerEntity serverPlayerEntity) {
        serverPlayerEntity.setGlowing(true);
        var maxHealth = serverPlayerEntity.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (maxHealth != null) {
            maxHealth.addPersistentModifier(HEALTH_BOOST);
        }
        serverPlayerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 60 * 20, 0, true, false));
    }
}
