
package at.uibk.dps.afcl.functions.objects;

import at.uibk.dps.afcl.Function;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Objects;

/**
 * This class describes the data input ports of
 * a {@link Function}
 * @author stefanpedratscher
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "type",
        "source",
        "value",
        "properties",
        "constraints"
})
public class DataIns {

    /**
     * Unique identifier for the data input port
     */
    @JsonProperty("name")
    private String name;

    /**
     * Indicates the data type of the data port
     */
    @JsonProperty("type")
    private String type;

    /**
     * Represents where the data comes from
     */
    @JsonProperty("source")
    private String source;

    /**
     * {@link PropertyConstraint} (information about the
     * behaviour of functions)
     */
    @JsonProperty("properties")
    private List<PropertyConstraint> properties;

    /**
     * {@link PropertyConstraint} (which must be fulfilled
     * by underlying workflow runtime environment)
     */
    @JsonProperty("constraints")
    private List<PropertyConstraint> constraints;

    /**
     * Default empty constructor for data input ports.
     */
    public DataIns() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    /**
     * Constructor for data input ports
     *
     * @param name Unique identifier for the data input port
     * @param type Data type of the data port
     */
    public DataIns(final String name, final String type) {
        this(name, type, null);
    }

    /**
     * Constructor for data input ports
     *
     * @param name   Unique identifier for the data input port
     * @param type   Data type of the data port
     * @param source Specifies where the data comes from
     */
    public DataIns(final String name, final String type, final String source) {
        this.name = name;
        this.type = type;
        this.source = source;
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

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(final String type) {
        this.type = type;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(final String source) {
        this.source = source;
    }

    @JsonProperty("properties")
    public List<PropertyConstraint> getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(final List<PropertyConstraint> properties) {
        this.properties = properties;
    }

    @JsonProperty("constraints")
    public List<PropertyConstraint> getConstraints() {
        return constraints;
    }

    @JsonProperty("constraints")
    public void setConstraints(final List<PropertyConstraint> constraints) {
        this.constraints = constraints;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final DataIns dataIns = (DataIns) object;
        return Objects.equals(name, dataIns.name) &&
                Objects.equals(type, dataIns.type) &&
                Objects.equals(source, dataIns.source) &&
                Objects.equals(properties, dataIns.properties) &&
                Objects.equals(constraints, dataIns.constraints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, source, properties, constraints);
    }
}
