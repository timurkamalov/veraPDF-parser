package org.verapdf.cos;

import org.verapdf.as.ASAtom;
import org.verapdf.cos.visitor.ICOSVisitor;
import org.verapdf.cos.visitor.IVisitor;

/**
 * @author Timur Kamalov
 */
public class COSName extends COSDirect {

    private ASAtom value;

    protected COSName() {
        super();
    }

    protected COSName(final ASAtom value) {
        super();
        this.value = value;
    }

    protected COSName(final String value) {
        super();
        this.value = ASAtom.getASAtom(value);
    }

    public COSObjType getType() {
        return COSObjType.COS_NAME;
    }

    public static COSBase fromValue(final ASAtom value) {
        return new COSName(value);
    }

    public static COSBase fromValue(final String value) {
        return new COSName(value);
    }

    public static COSObject construct(final ASAtom value) {
        return new COSObject(new COSName(value));
    }

    public static COSObject construct(final String value) {
        return new COSObject(new COSName(value));
    }

    public void accept(final IVisitor visitor) {
        visitor.visitFromName(this);
    }

    public Object accept(final ICOSVisitor visitor) {
        return visitor.visitFromName(this);
    }

    //! ASAtom data exchange
    public ASAtom getName() {
        return this.value;
    }

    public boolean setName(final ASAtom value) {
        set(value);
        return true;
    }

    public ASAtom get() {
        return value;
    }

    public void set(final ASAtom value) {
        this.value = value;
    }

    public void set(final String value) {
        this.value = ASAtom.getASAtom(value);
    }

    //! String data exchange
		/*! It is recommended to use ASAtom instead of the string representation of the PDF Name object
		    whenever possible. See method GetName().
		*/
    public String getString() {
        return this.value.getValue();
    }

    public boolean setString(final String value) {
        set(value);
        return true;
    }

    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof COSName)) return false;

        COSName cosName = (COSName) o;

        return value != null ? value.equals(cosName.value) : cosName.value == null;

    }
}
