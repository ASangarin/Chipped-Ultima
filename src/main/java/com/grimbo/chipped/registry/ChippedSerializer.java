package com.grimbo.chipped.registry;

import com.grimbo.chipped.Chipped;
import com.grimbo.chipped.recipe.ChippedRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;

public class ChippedSerializer {
	//Add new RecipeTypes here
	public static final RecipeType<ChippedRecipe> BOTANIST_WORKBENCH_TYPE = RecipeType.register(Chipped.MOD_ID + ":botanist_workbench");
	public static final RecipeType<ChippedRecipe> GLASSBLOWER_TYPE = RecipeType.register(Chipped.MOD_ID + ":glassblower");
	public static final RecipeType<ChippedRecipe> CARPENTERS_TABLE_TYPE = RecipeType.register(Chipped.MOD_ID + ":carpenters_table");
	public static final RecipeType<ChippedRecipe> LOOM_TABLE_TYPE = RecipeType.register(Chipped.MOD_ID + ":loom_table");
	public static final RecipeType<ChippedRecipe> MASON_TABLE_TYPE = RecipeType.register(Chipped.MOD_ID + ":mason_table");
	public static final RecipeType<ChippedRecipe> ALCHEMY_BENCH_TYPE = RecipeType.register(Chipped.MOD_ID + ":alchemy_bench");
	public static final RecipeType<ChippedRecipe> MECHANIST_WORKBENCH_TYPE = RecipeType.register(Chipped.MOD_ID + ":mechanist_workbench");
	public static final RecipeType<ChippedRecipe> CONVERSION_TABLE_TYPE = RecipeType.register(Chipped.MOD_ID + ":conversion_table");

	public static void register() {
		Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "botanist_workbench"),
				new ChippedRecipe.Serializer(BOTANIST_WORKBENCH_TYPE, ChippedBlocks.BOTANIST_WORKBENCH));
		Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "glassblower"),
				new ChippedRecipe.Serializer(GLASSBLOWER_TYPE, ChippedBlocks.GLASSBLOWER));
		Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "carpenters_table"),
				new ChippedRecipe.Serializer(CARPENTERS_TABLE_TYPE, ChippedBlocks.CARPENTERS_TABLE));
		Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "loom_table"),
				new ChippedRecipe.Serializer(LOOM_TABLE_TYPE, ChippedBlocks.LOOM_TABLE));
		Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "mason_table"),
				new ChippedRecipe.Serializer(MASON_TABLE_TYPE, ChippedBlocks.MASON_TABLE));
		Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "alchemy_bench"),
				new ChippedRecipe.Serializer(ALCHEMY_BENCH_TYPE, ChippedBlocks.ALCHEMY_BENCH));
		Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "mechanist_workbench"),
				new ChippedRecipe.Serializer(MECHANIST_WORKBENCH_TYPE, ChippedBlocks.MECHANIST_WORKBENCH));
		Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Chipped.MOD_ID, "conversion_table"),
				new ChippedRecipe.Serializer(CONVERSION_TABLE_TYPE, ChippedBlocks.CONVERSION_TABLE));
	}
}

