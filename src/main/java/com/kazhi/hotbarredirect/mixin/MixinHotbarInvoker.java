package com.kazhi.hotbarredirect.mixin;

import net.minecraft.client.HotbarManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(HotbarManager.class)
public interface MixinHotbarInvoker {
    @Invoker(value = "load")
    void invokeLoad();
}
