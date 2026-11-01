package com.example.backpackedaddon.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "com.mrcrayfish.backpacked.component.QuiverlinkComponent")
public class BackpackedFireworksMixin {

    @Inject(method = "isValidAmmo", at = @At("HEAD"), cancellable = true, remap = false)
    private void allowFireworks(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.is(Items.FIREWORK_ROCKET)) {
            cir.setReturnValue(true);
        }
    }
}
