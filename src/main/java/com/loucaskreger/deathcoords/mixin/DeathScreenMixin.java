package com.loucaskreger.deathcoords.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.loucaskreger.deathcoords.DeathCoords;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.DeathScreen;

@Mixin(DeathScreen.class)
public class DeathScreenMixin {

	@Inject(method = "render", at = @At("TAIL"), cancellable = true)
	private void onRender(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
		var client = MinecraftClient.getInstance();
		var screen = (DeathScreen) (Object) this;

		var text = DeathCoords.BuildDeathCoordsMessage(client.player);
		context.drawCenteredTextWithShadow(((ScreenAccessor) screen).getTextRenderer(), text, screen.width / 2, 115, 0xFFFFFF);
	}

}
