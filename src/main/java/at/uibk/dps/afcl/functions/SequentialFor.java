package at.uibk.dps.afcl.functions;

import at.uibk.dps.afcl.Function;
import at.uibk.dps.afcl.functions.objects.DataIns;
import at.uibk.dps.afcl.functions.objects.DataLoops;
import at.uibk.dps.afcl.functions.objects.DataOuts;
import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class describes the sequential for compound
 * 
 * @author stefanpedratscher
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "dataIns", "dataLoops", "loopCounter", "loopBody", "dataOuts" })
@JsonTypeName("for")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class SequentialFor extends LoopCompound {

	/**
	 * Contains needed information about potential loop data flow
	 */
	@JsonProperty("dataLoops")
	private List<DataLoops> dataLoopsSequentialFor;

	/**
	 * Contains needed information about the number of (sequential) loop iterations
	 */
	@JsonProperty("iterators")
	protected final List<String> iterators = new ArrayList<>();

	public SequentialFor() {
	}

	/**
	 * Constructor for function compound for
	 *
	 * @param name                     Unique identifier of the compound
	 * @param dataIns                  Data input ports ({@link DataIns})
	 * @param loopCounterSequentialFor information about the number of (sequential)
	 *                                 loop iterations
	 * @param loopBodySequentialFor    functions which should be executed in each
	 *                                 iteration
	 * @param dataOuts                 Data output ports ({@link DataOuts})
	 */
	public SequentialFor(String name, List<DataIns> dataIns, List<DataLoops> dataLoopsSequentialFor,
			List<String> iterators, List<Function> loopBodySequentialFor, List<DataOuts> dataOuts) {
		this.name = name;
		this.dataIns = dataIns;
		this.dataLoopsSequentialFor = dataLoopsSequentialFor;
		this.iterators.addAll(iterators);
		this.setLoopBody(loopBodySequentialFor);
		this.dataOuts = dataOuts;
	}

	/**
	 * Getter and Setter
	 */

	@JsonProperty("dataLoops")
	public List<DataLoops> getDataLoops() {
		return dataLoopsSequentialFor;
	}

	@JsonProperty("dataLoops")
	public void setDataLoops(List<DataLoops> dataLoops) {
		this.dataLoopsSequentialFor = dataLoops;
	}

	@JsonProperty("iterators")
	public List<String> getIterators() {
		return this.iterators;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		SequentialFor that = (SequentialFor) o;
		return Objects.equals(dataLoopsSequentialFor, that.dataLoopsSequentialFor)
				&& Objects.equals(iterators, that.iterators);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), dataLoopsSequentialFor, iterators);
	}
}
