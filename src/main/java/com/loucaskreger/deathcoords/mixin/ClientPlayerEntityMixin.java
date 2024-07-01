package com.loucaskreger.deathcoords.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.loucaskreger.deathcoords.DeathCoords;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

	@Inject(method = "requestRespawn", at = @At("TAIL"))
	public void requestRespawn(CallbackInfo ci) {
		var client = MinecraftClient.getInstance();

		var text = DeathCoords.BuildDeathCoordsMessage(client.player);
		var deathCoordsLiteral = Text.literal(text);
		deathCoordsLiteral.setStyle(deathCoordsLiteral.getStyle().withColor(Formatting.GOLD));
		client.player.sendMessage(deathCoordsLiteral, false);
	}
}
