package com.grimbo.chipped.compat;

import com.grimbo.chipped.recipe.ChippedRecipe;
import com.grimbo.chipped.registry.ChippedBlocks;
import com.grimbo.chipped.registry.ChippedSerializer;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class REIChippedPlugin implements REIClientPlugin {
	@Override
	public void registerCategories(CategoryRegistry registry) {
		registry.add(new ChippedRecipeCategory(ChippedBlocks.BOTANIST_WORKBENCH), new ChippedRecipeCategory(ChippedBlocks.GLASSBLOWER),
				new ChippedRecipeCategory(ChippedBlocks.CARPENTERS_TABLE), new ChippedRecipeCategory(ChippedBlocks.LOOM_TABLE),
				new ChippedRecipeCategory(ChippedBlocks.MASON_TABLE), new ChippedRecipeCategory(ChippedBlocks.ALCHEMY_BENCH),
				new ChippedRecipeCategory(ChippedBlocks.MECHANIST_WORKBENCH), new ChippedRecipeCategory(ChippedBlocks.CONVERSION_TABLE));
	}

	@Override
	public void registerDisplays(DisplayRegistry registry) {
		RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
		registerRecipes(recipeManager, registry, ChippedSerializer.BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH);
		registerRecipes(recipeManager, registry, ChippedSerializer.CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE);
		registerRecipes(recipeManager, registry, ChippedSerializer.LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE);
		registerRecipes(recipeManager, registry, ChippedSerializer.MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE);
		registerRecipes(recipeManager, registry, ChippedSerializer.ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH);
		registerRecipes(recipeManager, registry, ChippedSerializer.MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH);
		registerRecipes(recipeManager, registry, ChippedSerializer.CONVERSION_TABLE_TYPE, ChippedBlocks.CONVERSION_TABLE);
	}

	private void registerRecipes(RecipeManager recipeManager, DisplayRegistry registry, RecipeType<ChippedRecipe> type, Block block) {
		final ResourceLocation category = Registry.BLOCK.getKey(block);
		for (ChippedRecipeCategory.FlattenedRecipe recipe : flatten(recipeManager.getAllRecipesFor(type), CategoryIdentifier.of(category))) {
			registry.add(recipe);
		}
	}

	private static List<ChippedRecipeCategory.FlattenedRecipe> flatten(Collection<ChippedRecipe> recipes, CategoryIdentifier<ChippedRecipeCategory.FlattenedRecipe> category) {
		List<ChippedRecipeCategory.FlattenedRecipe> flattenedRecipes = new ArrayList<>();
		for (ChippedRecipe recipe : recipes) {
			for (HolderSet<Item> tag : recipe.tags()) {
				var items = tag.stream().filter(Holder::isBound).map(Holder::value).toList();
				Ingredient ingredient = Ingredient.of(items.stream().map(ItemStack::new));
				for (Item item : items) {
					flattenedRecipes.add(new ChippedRecipeCategory.FlattenedRecipe(ingredient, new ItemStack(item), category));
				}
			}
		}
		return flattenedRecipes;
	}
}
