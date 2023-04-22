package net.anchikai.endium.world.gen;

public class ModWorldGen {
    public static void generateModWorldGen() {
        ModTreeGen.generateTrees();
        ModFeatureGen.generateFeatures();
    }
}
