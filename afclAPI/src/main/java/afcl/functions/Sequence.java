
package afcl.functions;

import afcl.Function;
import afcl.functions.objects.DataIns;
import afcl.functions.objects.DataOuts;
import afcl.functions.objects.PropertyConstraint;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class describes the sequence compound
 * @author stefanpedratscher
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "dataIns",
        "sequenceBody",
        "dataOuts"
})
@JsonTypeName("sequence")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class Sequence extends Compound {

    /**
     * List of {@link Function}s to be executed sequentially
     */
    @JsonProperty("sequenceBody")
    private List<Function> sequenceBody;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Sequence() {
    }

    /**
     * Constructor for function compound sequence
     *
     * @param name         Unique identifier of the compound
     * @param dataIns      Data input ports ({@link DataIns})
     * @param sequenceBody List of {@link Function}s to be executed sequentially
     * @param dataOuts     Data output ports ({@link DataOuts})
     */
    public Sequence(String name, List<DataIns> dataIns, List<Function> sequenceBody, List<DataOuts> dataOuts) {
        this.name = name;
        this.dataIns = dataIns;
        this.sequenceBody = sequenceBody;
        this.dataOuts = dataOuts;
    }

    /**
     * Getter and Setter
     */

    @JsonProperty("sequenceBody")
    public List<Function> getSequenceBody() {
        return sequenceBody;
    }

    @JsonProperty("sequenceBody")
    public void setSequenceBody(List<Function> sequenceBody) {
        this.sequenceBody = sequenceBody;
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