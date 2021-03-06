package org.verapdf.cos;

import org.verapdf.cos.visitor.ICOSVisitor;
import org.verapdf.cos.visitor.IVisitor;

/**
 * @author Timur Kamalov
 */
public class COSBoolean extends COSDirect {

    public static final COSBoolean TRUE = new COSBoolean(true);
    public static final COSBoolean FALSE = new COSBoolean(false);

    private boolean value;

    protected COSBoolean() {
    }

    protected COSBoolean(final boolean initValue) {
        super();
        this.value = initValue;
    }

    public COSObjType getType() {
        return COSObjType.COS_BOOLEAN;
    }

    public static COSObject construct(final boolean initValue) {
        return new COSObject(new COSBoolean(initValue));
    }

    public void accept(final IVisitor visitor) {
        visitor.visitFromBoolean(this);
    }

    public Object accept(final ICOSVisitor visitor) {
        return visitor.visitFromBoolean(this);
    }

    public Boolean getBoolean() {
        return get();
    }

    public boolean setBoolean(final boolean value) {
        set(value);
        return true;
    }

    public boolean get() {
        return this.value;
    }

    public void set(final boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof COSBoolean)) return false;

        COSBoolean that = (COSBoolean) o;

        return value == that.value;

    }
}
