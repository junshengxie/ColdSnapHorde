package com.villain.coldsnaphorde.mixin;

import com.villain.coldsnaphorde.component.ComponentStarter;
import com.villain.coldsnaphorde.component.PlayerCooldownComponent;
import com.villain.coldsnaphorde.events.MixinEvents;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public class PlayerTickMixin {

        @Inject(at = @At("TAIL"), method = "tick")
        private void coldSnapTick(CallbackInfo ci){
            PlayerCooldownComponent h = ComponentStarter.PLAYERCOMPONENT.get((ServerPlayer) (Object) this);
            h.tickCooldown();
            MixinEvents.PlayerTick((ServerPlayer) (Object) this);
        }
}
