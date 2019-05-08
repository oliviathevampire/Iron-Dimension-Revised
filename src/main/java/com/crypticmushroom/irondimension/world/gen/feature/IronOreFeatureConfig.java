package com.crypticmushroom.irondimension.world.gen.feature;

import com.crypticmushroom.irondimension.registry.BlocksID;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.predicate.block.BlockPredicate;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IronOreFeatureConfig extends OreFeatureConfig implements FeatureConfig {
    public final IronOreFeatureConfig.Target irontarget;

    public IronOreFeatureConfig(IronOreFeatureConfig.Target irontargett,OreFeatureConfig.Target oreFeatureConfig$Target_1, BlockState blockState_1, int int_1) {
        super(oreFeatureConfig$Target_1, blockState_1, int_1);
        irontarget = irontargett;
    }


    public <T> Dynamic<T> serialize(DynamicOps<T> dynamicOps_1) {
        return new Dynamic(dynamicOps_1, dynamicOps_1.createMap(ImmutableMap.of(dynamicOps_1.createString("size"), dynamicOps_1.createInt(this.size), dynamicOps_1.createString("target"), dynamicOps_1.createString(this.target.getName()), dynamicOps_1.createString("state"), BlockState.serialize(dynamicOps_1, this.state).getValue())));
    }

    public static IronOreFeatureConfig deserialize(Dynamic<?> dynamic_1) {
        int int_1 = dynamic_1.get("size").asInt(0);
        IronOreFeatureConfig.Target oreFeatureConfig$Target_1 = IronOreFeatureConfig.Target.byName(dynamic_1.get("irontarget").asString(""));
        BlockState blockState_1 = (BlockState)dynamic_1.get("state").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        return new IronOreFeatureConfig(oreFeatureConfig$Target_1, null, blockState_1, int_1);
    }

    public static enum Target {
        IRON("netherrack", new BlockPredicate(BlocksID.ironstone));

        private static final Map<String, IronOreFeatureConfig.Target> nameMap = (Map) Arrays.stream(values()).collect(Collectors.toMap(IronOreFeatureConfig.Target::getName, (oreFeatureConfig$Target_1) -> {
            return oreFeatureConfig$Target_1;
        }));
        private final String name;
        private final Predicate<BlockState> predicate;

        private Target(String string_1, Predicate<BlockState> predicate_1) {
            this.name = string_1;
            this.predicate = predicate_1;
        }

        public String getName() {
            return this.name;
        }

        public static IronOreFeatureConfig.Target byName(String string_1) {
            return (IronOreFeatureConfig.Target)nameMap.get(string_1);
        }

        public Predicate<BlockState> getCondition() {
            return this.predicate;
        }
    }
}
