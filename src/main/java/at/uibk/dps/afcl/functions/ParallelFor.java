
package at.uibk.dps.afcl.functions;

import at.uibk.dps.afcl.Function;
import at.uibk.dps.afcl.functions.objects.DataIns;
import at.uibk.dps.afcl.functions.objects.DataOuts;
import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class describes the parallelFor compound
 * @author stefanpedratscher
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "dataIns",
        "iterators",
        "loopBody",
        "dataOuts"
})
@JsonTypeName("parallelFor")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class ParallelFor extends LoopCompound {

    /**
     * Contains needed information about the number of (parallel) loop iterations
     */
    @JsonProperty("iterators")
    protected final List<String> iterators = new ArrayList<>();

    /**
     * Default constructor.
     */
    public ParallelFor() {
        super();
    }

    /**
     * Constructor for function compound parallelFor
     *
     * @param name        Unique identifier of the compound
     * @param dataIns     Data input ports ({@link DataIns})
     * @param iterators information about the number of
     *                    (parallel) loop iterations
     * @param loopBodyParallelFor    functions which should be
     *                               executed in each iteration
     * @param dataOuts    Data output ports ({@link DataOuts})
     */
    public ParallelFor(String name, List<DataIns> dataIns, List<String> iterators, List<Function> loopBodyParallelFor, List<DataOuts> dataOuts) {
        this.name = name;
        this.dataIns = dataIns;
        this.iterators.addAll(iterators);
        this.setLoopBody(loopBodyParallelFor);
        this.dataOuts = dataOuts;
    }

    /**
     * Getter and Setter
     */

    @JsonProperty("iterators")
    public List<String> getIterators() {
        return iterators;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        ParallelFor that = (ParallelFor) object;
        return Objects.equals(iterators, that.iterators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), iterators);
    }
}
