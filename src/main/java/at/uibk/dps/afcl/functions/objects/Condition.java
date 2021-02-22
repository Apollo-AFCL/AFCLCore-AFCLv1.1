
package at.uibk.dps.afcl.functions.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class represents a condition of {@link Condition}
 * @author stefanpedratscher
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data1",
        "data2",
        "operator"
})
public class Condition {

    /**
     * Left operand
     */
    @JsonProperty("data1")
    private String data1;

    /**
     * Right operand
     */
    @JsonProperty("data2")
    private String data2;

    /**
     * Represents how the different conditions should be
     * combined (AND or OR)
     */
    @JsonProperty("combinedWith")
    private String combinedWith;

    /**
     * Operand (e.g. ==, contains, ...)
     */
    @JsonProperty("operator")
    private String operator;

    /**
     * Negate the condition
     */
    @JsonProperty("negation")
    private String negation;

    /**
     * Optional additional json properties.
     */
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new ConcurrentHashMap<>();

    /**
     * Default constructor.
     */
    public Condition() {
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    /**
     * Constructor for ACondition
     *
     * @param data1    Left operand
     * @param data2    Right operand
     * @param operator Operand (e.g. ==, contains, ...)
     */
    public Condition(final String data1, final String data2, final String operator, final String combinedWith) {
        this.data1 = data1;
        this.data2 = data2;
        this.operator = operator;
        this.combinedWith = combinedWith;
    }

    /**
     * Getter and Setter
     */

    @JsonProperty("data1")
    public String getData1() {
        return data1;
    }

    @JsonProperty("data1")
    public void setData1(final String data1) {
        this.data1 = data1;
    }

    @JsonProperty("data2")
    public String getData2() {
        return data2;
    }

    @JsonProperty("data2")
    public void setData2(final String data2) {
        this.data2 = data2;
    }

    @JsonProperty("combinedWith")
    public String getCombinedWith() {
        return combinedWith;
    }

    @JsonProperty("combinedWith")
    public void setCombinedWith(final String combinedWith) {
        this.combinedWith = combinedWith;
    }

    @JsonProperty("operator")
    public String getOperator() {
        return operator;
    }

    @JsonProperty("operator")
    public void setOperator(final String operator) {
        this.operator = operator;
    }

    @JsonProperty("negation")
    public String getNegation() {
        return negation;
    }

    @JsonProperty("negation")
    public void setNegation(final String negation) {
        this.negation = negation;
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
        final Condition that = (Condition) object;
        return Objects.equals(data1, that.data1) &&
                Objects.equals(data2, that.data2) &&
                Objects.equals(operator, that.operator) &&
                Objects.equals(negation, that.negation) &&
                Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data1, data2, operator, negation, additionalProperties);
    }
}
