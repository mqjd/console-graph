package org.mqjd.common;

public class MixinKey {
    private final String key1;
    private final String key2;

    public MixinKey(String key1, String key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public static MixinKey of(String key1, String key2) {
        return new MixinKey(key1, key2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MixinKey mixinKey = (MixinKey) o;
        return this.hashCode() == mixinKey.hashCode();
    }

    @Override
    public int hashCode() {
        return key1.hashCode() + key2.hashCode();
    }
}
