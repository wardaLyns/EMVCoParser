package Model;

/**
 * Created by User on 07/03/2018.
 */
public class EmvObject {
    /**
     * Retrieve the length of the value
     */
    int length;

    /**
     * Retrieve value from
     */

    String values;

    /**
     * Getter Length Value
     */
    public int getLength() {
        return length;
    }

    /**
     * Setter Length Value
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Getter Emvco Values
     */
    public String getValues() {
        return values;
    }

    /**
     * Setter Length Value
     */
    public void setValues(String values) {
        this.values = values;
    }

    /**
     * Create equals and hashcode methode if comparator method is needed
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmvObject emvObject = (EmvObject) o;

        if (length != emvObject.length) return false;
        return values != null ? values.equals(emvObject.values) : emvObject.values == null;
    }

    @Override
    public int hashCode() {
        int result = length;
        result = 31 * result + (values != null ? values.hashCode() : 0);
        return result;
    }
}
