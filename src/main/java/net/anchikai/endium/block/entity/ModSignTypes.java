package net.anchikai.endium.block.entity;

import net.anchikai.endium.mixin.SignTypeAccessor;
import net.minecraft.util.SignType;

public class ModSignTypes {
    public static final SignType AMARANTH =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("amaranth"));
}