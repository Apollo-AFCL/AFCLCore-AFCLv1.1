package at.uibk.dps.afcl.functions;

import at.uibk.dps.afcl.functions.objects.Condition;
import at.uibk.dps.afcl.functions.objects.DataIns;
import at.uibk.dps.afcl.functions.objects.DataOuts;
import org.junit.Assert;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Test the functionality of a sequqntialFor object.
 *
 * @author stefanpedratscher
 */
public class WhileTest {

  /**
   * Test full construction of a sequentialFor.
   *
   * @author stefanpedratscher
   */
  @Test
  public void testFullConstruction() {
    final AtomicFunction atomicFunction =
        new AtomicFunction("atomicFunction", "atomicFunctionType", null, null);
    final DataIns dataIns = new DataIns("inName", "inType");
    final DataOuts dataOuts = new DataOuts("outName", "outType", "outSource");
    final List<Condition> condition =
        Arrays.asList(new Condition("1", "2", "number", "==", "AND", false),
            new Condition("1", "1", "number", "==", "AND", false));

    final While sequentialFor =
        new While("sequentialFor", new ArrayList<>(Collections.singleton(dataIns)),
            new ArrayList<>(Collections.singleton(atomicFunction)), condition,
            new ArrayList<>(Collections.singleton(dataOuts)));

    Assert.assertEquals("sequentialFor", sequentialFor.getName());

    Assert.assertEquals(1, sequentialFor.getDataIns().size());
    Assert.assertEquals(dataIns, sequentialFor.getDataIns().get(0));
    Assert.assertEquals(dataIns.hashCode(), sequentialFor.getDataIns().get(0).hashCode());

    assertEquals(condition, sequentialFor.getCondition());

    Assert.assertEquals(1, sequentialFor.getLoopBody().size());
    Assert.assertEquals(atomicFunction, sequentialFor.getLoopBody().get(0));
    Assert.assertEquals(atomicFunction.hashCode(), sequentialFor.getLoopBody().get(0).hashCode());

    Assert.assertEquals(1, sequentialFor.getDataOuts().size());
    Assert.assertEquals(dataOuts, sequentialFor.getDataOuts().get(0));
    Assert.assertEquals(dataOuts.hashCode(), sequentialFor.getDataOuts().get(0).hashCode());

    Assert.assertEquals(0, atomicFunction.getAdditionalProperties().size());
  }

  /**
   * Test the empty construction of a sequentialFor.
   *
   * @author stefanpedratscher
   */
  @Test
  public void testEmptyConstruction() {
    final While sequentialFor = new While();

    Assert.assertNull(sequentialFor.getName());
    Assert.assertNull(sequentialFor.getDataIns());
    Assert.assertNull(sequentialFor.getCondition());
    Assert.assertNull(sequentialFor.getLoopBody());
    Assert.assertNull(sequentialFor.getDataOuts());
    Assert.assertEquals(0, sequentialFor.getAdditionalProperties().size());
  }

  /**
   * Test getter and setter
   *
   * @author stefanpedratscher
   */
  @Test
  public void testGetterAndSetter() {
    new BeanTester().testBean(While.class);
  }

  /**
   * Test hashCode and equals
   *
   * @author stefanpedratscher
   */
  @Test
  public void testHashEquals() {
    final While sequentialFor = new While("name", null, null, null, null);

    Assert.assertEquals(sequentialFor, sequentialFor);
    Assert.assertEquals(sequentialFor.hashCode(), sequentialFor.hashCode());
    Assert.assertNotEquals(sequentialFor, null);

    final LoopCompound loopCompound = new LoopCompound();
    Assert.assertNotEquals(sequentialFor, loopCompound);

    final While sequentialFor2 = new While("name", null, null, null, null);
    Assert.assertEquals(sequentialFor, sequentialFor2);
    Assert.assertEquals(sequentialFor.hashCode(), sequentialFor2.hashCode());
    sequentialFor2.setAdditionalProperties("name", "type");
    Assert.assertNotEquals(sequentialFor, sequentialFor2);

    While sequentialFor3;
    sequentialFor3 = new While("nameWrong", null, null, null, null);
    Assert.assertNotEquals(sequentialFor, sequentialFor3);

    sequentialFor3 = new While("name",
        Collections.singletonList(new DataIns("name", "type", "source")), null, null, null);
    Assert.assertNotEquals(sequentialFor, sequentialFor3);

    sequentialFor3 = new While("name", null, null, null,
        Collections.singletonList(new DataOuts("name", "type", "source")));
    Assert.assertNotEquals(sequentialFor, sequentialFor3);
  }
}
