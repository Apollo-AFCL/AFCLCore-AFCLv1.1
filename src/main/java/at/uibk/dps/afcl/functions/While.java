package at.uibk.dps.afcl.functions;

import at.uibk.dps.afcl.Function;
import at.uibk.dps.afcl.functions.objects.Condition;
import at.uibk.dps.afcl.functions.objects.DataIns;
import at.uibk.dps.afcl.functions.objects.DataOuts;
import com.fasterxml.jackson.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * This class describes the sequential for compound
 * 
 * @author stefanpedratscher
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "dataIns", "loopBody", "condition"})
@JsonTypeName("while")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class While extends LoopCompound {

  /**
   * Provides the stop condition(s)
   */
  @JsonProperty("condition")
  protected List<Condition> condition;

  /**
   * Default constructor.
   */
  public While() {
    super();
  }

  /**
   * Constructor for function compound for
   *
   * @param name Unique identifier of the compound
   * @param dataIns Data input ports ({@link DataIns})
   * @param iterator information about the number of (sequential) loop iterations
   * @param loopBodySequentialFor functions which should be executed in each
   *        iteration
   * @param condition stop condition
   * @param dataOuts Data output ports ({@link DataOuts})
   */
  public While(final String name, final List<DataIns> dataIns,
      final List<Function> loopBodySequentialFor, final List<Condition> condition,
      final List<DataOuts> dataOuts) {
    this();
    this.name = name;
    this.dataIns = dataIns;
    this.setLoopBody(loopBodySequentialFor);
    this.dataOuts = dataOuts;
    this.condition = condition;
  }

  @JsonProperty("condition")
  public List<Condition> getCondition() {
    return condition;
  }

  @JsonProperty("condition")
  public void setCondition(List<Condition> condition) {
    this.condition = condition;
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
    final While that = (While) object;
    return Objects.equals(condition, that.condition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), condition);
  }
}
