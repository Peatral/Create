package com.simibubi.create.foundation.item.render;

import com.simibubi.create.CreateClient;

import net.minecraft.world.item.Item;
import net.minecraftforge.client.IItemRenderProperties;

public class SimpleCustomRenderer implements IItemRenderProperties {

	protected CustomRenderedItemModelRenderer<?> renderer;

	protected SimpleCustomRenderer(CustomRenderedItemModelRenderer<?> renderer) {
		this.renderer = renderer;
	}

	public static SimpleCustomRenderer create(Item item, CustomRenderedItemModelRenderer<?> renderer) {
		CreateClient.MODEL_SWAPPER.getCustomRenderedItems().register(item.delegate, renderer::createModel);
		return new SimpleCustomRenderer(renderer);
	}

	@Override
	public CustomRenderedItemModelRenderer<?> getItemStackRenderer() {
		return renderer;
	}

}
