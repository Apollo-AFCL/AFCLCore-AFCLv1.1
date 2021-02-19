
package at.uibk.dps.afcl.functions.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Objects;

/**
 * This class describes the data output ports of
 * an atomic function
 * @author stefanpedratscher
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "type",
        "source",
        "saveto",
        "properties",
        "constraints"
})
public class DataOutsAtomic {

    /**
     * Unique identifier for the data output port
     */
    @JsonProperty("name")
    private String atomicOutputName;

    /**
     * Indicates the data type of the data port
     */
    @JsonProperty("type")
    private String atomicOutputType;

    /**
     * To specify the output of the data output
     * port
     */
    @JsonProperty("saveto")
    private String atomicOutputSaveTo;

    /**
     * Tells whether value will be passed to other
     * function
     */
    @JsonProperty("passing")
    private Boolean passingDataOutsAtomic;

    /**
     * {@link PropertyConstraint} (information about the
     * behaviour of functions)
     */
    @JsonProperty("properties")
    private List<PropertyConstraint> propertiesDataOutsAtomic;

    /**
     * {@link PropertyConstraint} (which must be fulfilled
     * by underlying workflow runtime environment)
     */
    @JsonProperty("constraints")
    private List<PropertyConstraint> constraintsDataOutsAtomic;

    /**
     * Default constructor.
     */
    public DataOutsAtomic() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    /**
     * Constructor for data output port of atomic function
     *
     * @param atomicOutputName Unique identifier for the data output port
     * @param atomicOutputType Data type of the data port
     */
    public DataOutsAtomic(final String atomicOutputName, final String atomicOutputType) {
        this.atomicOutputName = atomicOutputName;
        this.atomicOutputType = atomicOutputType;
    }

    /**
     * Getter and Setter
     */

    @JsonProperty("name")
    public String getName() {
        return atomicOutputName;
    }

    @JsonProperty("name")
    public void setName(final String name) {
        this.atomicOutputName = name;
    }

    @JsonProperty("type")
    public String getType() {
        return atomicOutputType;
    }

    @JsonProperty("type")
    public void setType(final String type) {
        this.atomicOutputType = type;
    }

    @JsonProperty("saveto")
    public String getSaveto() {
        return atomicOutputSaveTo;
    }

    @JsonProperty("saveto")
    public void setSaveto(final String saveto) {
        this.atomicOutputSaveTo = saveto;
    }

    @JsonProperty("passing")
    public Boolean getPassing() {
        return passingDataOutsAtomic;
    }

    @JsonProperty("passing")
    public void setPassing(final Boolean passing) {
        this.passingDataOutsAtomic = passing;
    }

    @JsonProperty("properties")
    public List<PropertyConstraint> getProperties() {
        return propertiesDataOutsAtomic;
    }

    @JsonProperty("properties")
    public void setProperties(final List<PropertyConstraint> properties) {
        this.propertiesDataOutsAtomic = properties;
    }

    @JsonProperty("constraints")
    public List<PropertyConstraint> getConstraints() {
        return constraintsDataOutsAtomic;
    }

    @JsonProperty("constraints")
    public void setConstraints(final List<PropertyConstraint> constraints) {
        this.constraintsDataOutsAtomic = constraints;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final DataOutsAtomic that = (DataOutsAtomic) object;
        return Objects.equals(atomicOutputName, that.atomicOutputName) &&
                Objects.equals(atomicOutputType, that.atomicOutputType) &&
                Objects.equals(atomicOutputSaveTo, that.atomicOutputSaveTo) &&
                Objects.equals(passingDataOutsAtomic, that.passingDataOutsAtomic) &&
                Objects.equals(propertiesDataOutsAtomic, that.propertiesDataOutsAtomic) &&
                Objects.equals(constraintsDataOutsAtomic, that.constraintsDataOutsAtomic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atomicOutputName, atomicOutputType, atomicOutputSaveTo, passingDataOutsAtomic, propertiesDataOutsAtomic, constraintsDataOutsAtomic);
    }
}
