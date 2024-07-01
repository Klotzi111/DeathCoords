package com.loucaskreger.deathcoords;

import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public record RegistryIdPair(Identifier registry, Identifier id) {
	public RegistryIdPair(RegistryKey<?> registryKey) {
		this(registryKey.getRegistry(), registryKey.getValue());
	}
}
