package com.loucaskreger.deathcoords;

import java.util.HashMap;
import java.util.Map;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.world.World;

public class DeathCoords implements ModInitializer {

	private static final Map<RegistryIdPair, String> WORLD_KEY_TO_NAME = new HashMap<>();

	@Override
	public void onInitialize() {
		WORLD_KEY_TO_NAME.put(new RegistryIdPair(World.OVERWORLD), "Overworld");
		WORLD_KEY_TO_NAME.put(new RegistryIdPair(World.NETHER), "Nether");
		WORLD_KEY_TO_NAME.put(new RegistryIdPair(World.END), "End");
	}

	public static String BuildDeathCoordsMessage(ClientPlayerEntity player) {
		var pos = player.getPos();
		var dimKey = player.getWorld().getRegistryKey();
		var dimensionName = WORLD_KEY_TO_NAME.getOrDefault(new RegistryIdPair(dimKey), "Unknown");
		var text = String.format("You died at X: %.2f, Y: %.2f, Z: %.2f in the %s.", pos.x, pos.y, pos.z, dimensionName);
		return text;
	}
}
