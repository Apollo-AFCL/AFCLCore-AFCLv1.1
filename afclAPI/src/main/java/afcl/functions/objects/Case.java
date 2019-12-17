
package afcl.functions.objects;

import afcl.Function;
import afcl.functions.Switch;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a case of the {@link Switch} compound
 * @author stefanpedratscher
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "value",
        "break",
        "functions"
})
public class Case {

    /**
     * If this value is equal to the one in {@link DataEval} the case will be executed.
     */
    @JsonProperty("value")
    private String value;

    /**
     * Terminated the enclosing switch.
     */
    @JsonProperty("break")
    private String _break;

    /**
     * List of functions to be executed if the cases matches {@link DataEval}
     */
    @JsonProperty("functions")
    private List<Function> functions = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Case() {
    }

    /**
     * Constructor for case
     *
     * @param value     If this value is equal to the one in {@link DataEval} the case will be executed.
     * @param functions List of functions to be executed
     */
    public Case(String value, List<Function> functions) {
        this.value = value;
        this.functions = functions;
    }

    /**
     * Getter and Setter
     */

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("break")
    public String getBreak() {
        return _break;
    }

    @JsonProperty("break")
    public void setBreak(String _break) {
        this._break = _break;
    }

    @JsonProperty("functions")
    public List<Function> getFunctions() {
        return functions;
    }

    @JsonProperty("functions")
    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}