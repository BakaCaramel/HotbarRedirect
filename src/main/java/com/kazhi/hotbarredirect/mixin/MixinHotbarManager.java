package com.kazhi.hotbarredirect.mixin;

import com.kazhi.hotbarredirect.Config;
import net.minecraft.client.HotbarManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.nio.file.Path;

@Mixin(HotbarManager.class)
public class MixinHotbarManager {
    @ModifyArg(method = "load",at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NbtIo;read(Ljava/nio/file/Path;)Lnet/minecraft/nbt/CompoundTag;"))
    private Path redirectLoad(Path p_310670_){
        return p_310670_.getParent().resolve(Config.location);
    }
}
