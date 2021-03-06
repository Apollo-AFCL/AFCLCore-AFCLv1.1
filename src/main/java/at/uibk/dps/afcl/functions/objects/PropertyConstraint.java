
package at.uibk.dps.afcl.functions.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Objects;

/**
 * This class describes a property or constraint which
 * provide additional information to a workflow runtime.
 * @author stefanpedratscher
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "value"
})
public class PropertyConstraint {

    /**
     * Name of the property or constraint
     */
    @JsonProperty("name")
    private String name;

    /**
     * Value of the property or constraint regarding
     * its {@link PropertyConstraint#name}
     */
    @JsonProperty("value")
    private String value;

    /**
     * Optional additional json properties.
     */
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new ConcurrentHashMap<>();

    /**
     * Default constructor.
     */
    public PropertyConstraint() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    /**
     * Constructor for property or constraint
     *
     * @param name  Name of the property or constraint
     * @param value Value of the property or constraint regarding
     *              its {@link PropertyConstraint#name}
     */
    public PropertyConstraint(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Getter and Setter
     */

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(final String name) {
        this.name = name;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(final String value) {
        this.value = value;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set specific property.
     *
     * @param name of the property.
     * @param value of the property.
     */
    @JsonAnySetter
    public void setAdditionalProperties(final String name, final Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final PropertyConstraint that = (PropertyConstraint) object;
        return Objects.equals(name, that.name) &&
                Objects.equals(value, that.value) &&
                Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, additionalProperties);
    }
}
