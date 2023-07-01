package com.villain.coldsnaphorde.mixin;

import com.villain.coldsnaphorde.events.MixinEvents;
import net.minecraft.server.level().ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayer.class)
public class PlayerHurtMixin {

        @Inject(at = @At("TAIL"), method = "hurt")
        private void coldSnapHurt(DamageSource damageSource, float f, CallbackInfoReturnable<Boolean> cir){
            MixinEvents.PlayerHurt((ServerPlayer) (Object) this, damageSource);
        }
}
