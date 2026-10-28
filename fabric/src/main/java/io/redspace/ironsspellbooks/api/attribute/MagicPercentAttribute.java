package io.redspace.ironsspellbooks.api.attribute;

public class MagicPercentAttribute extends PercentageAttribute implements IMagicAttribute {
    public MagicPercentAttribute(String pDescriptionId, double pDefaultValue, double pMin, double pMax) {
        super(pDescriptionId, pDefaultValue, pMin, pMax);
    }
}
