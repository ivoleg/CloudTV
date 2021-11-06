package diving;

import java.util.HashMap;
/**
 * Enum that represents encapsulation of a diver’s position.
 * @author Oleg Ivannikov
 */
public enum Position {
    STRAIGHT ('A', "Straight"),
    PIKE ('B', "Pike"),
    TUCK ('C', "Tuck"),
    FREE ('D', "Free"),
    FLY ('E', "Fly");

    private final Character code;
    private final String description;

    /**
     * Default constructor.
     * @param code Character
     * @param description String
     */
    Position(Character code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Return the instance that corresponds to the given code or null if the code is invalid.
     * @param code code we are looking for
     * @return position whose code it has, or null if there is no such position
     */
    public static Position fromCode(Character code) {
        HashMap<Character, Position> codeToPosition = new HashMap<>();
        for (Position position : Position.values()) {
            codeToPosition.put(position.code, position);
        }
        return codeToPosition.get(code);
    }

    /**
     * Return the instance that corresponds to the given description (ignoring the case of the String objects)
     * or null if the description is invalid
     * @param description description we are looking for
     * @return position whose description it has, or null if there is no such position
     */
    public static Position fromDescription(String description) {
        if (description == null) {return null;}       //because otherwise description.toLowerCase throws a NullPointerException on null String.
        HashMap<String, Position> descriptionToPosition = new HashMap<>();
        for (Position position : Position.values()) {
            descriptionToPosition.put(position.description.toLowerCase(), position);
        }
        return descriptionToPosition.get(description.toLowerCase());
    }

    /**
     * Return code that corresponds to this instance
     * @return code
     */
    public Character getCode() {
        return this.code;
    }

    /**
     * Returns description of this enum instance.
     * @return description
     */
    @Override
    public String toString() {
        return this.description;
    }
    /*
     The coursework also asked for the appropriate hashCode and equals methods, but for the enum, these methods are
     final and can't be overridden.
     */
}
