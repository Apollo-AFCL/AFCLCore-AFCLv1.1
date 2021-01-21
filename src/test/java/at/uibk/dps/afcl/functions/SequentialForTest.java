package at.uibk.dps.afcl.functions;

import at.uibk.dps.afcl.functions.objects.DataIns;
import at.uibk.dps.afcl.functions.objects.DataLoops;
import at.uibk.dps.afcl.functions.objects.DataOuts;
import org.junit.Assert;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Test the functionality of a sequqntialFor object.
 *
 * @author stefanpedratscher
 */
public class SequentialForTest {
	/**
	 * Test full construction of a sequentialFor.
	 *
	 * @author stefanpedratscher
	 */
	@Test
	public void testFullConstruction() {
		AtomicFunction atomicFunction = new AtomicFunction("atomicFunction", "atomicFunctionType", null, null);
		DataIns dataIns = new DataIns("inName", "inType");
		DataOuts dataOuts = new DataOuts("outName", "outType", "outSource");
		final DataLoops dataLoops = new DataLoops();
		List<String> iterators = Arrays.asList("10", "collectionName");

		SequentialFor sequentialFor = new SequentialFor("sequentialFor",
				new ArrayList<>(Collections.singleton(dataIns)), new ArrayList<>(Collections.singleton(dataLoops)),
				iterators, new ArrayList<>(Collections.singleton(atomicFunction)),
				new ArrayList<>(Collections.singleton(dataOuts)));

		Assert.assertEquals("sequentialFor", sequentialFor.getName());

		Assert.assertEquals(1, sequentialFor.getDataIns().size());
		Assert.assertEquals(dataIns, sequentialFor.getDataIns().get(0));
		Assert.assertEquals(dataIns.hashCode(), sequentialFor.getDataIns().get(0).hashCode());

		Assert.assertEquals(1, sequentialFor.getDataLoops().size());
		Assert.assertEquals(dataLoops, sequentialFor.getDataLoops().get(0));
		Assert.assertEquals(dataLoops.hashCode(), sequentialFor.getDataLoops().get(0).hashCode());

		Assert.assertEquals(iterators, sequentialFor.getIterators());
		Assert.assertEquals(iterators.hashCode(), sequentialFor.getIterators().hashCode());

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
		SequentialFor sequentialFor = new SequentialFor();

		Assert.assertNull(sequentialFor.getName());
		Assert.assertNull(sequentialFor.getDataIns());
		Assert.assertNull(sequentialFor.getDataLoops());
		Assert.assertTrue(sequentialFor.getIterators().isEmpty());
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
		new BeanTester().testBean(SequentialFor.class);
	}

	/**
	 * Test hashCode and equals
	 *
	 * @author stefanpedratscher
	 */
	@Test
	public void testHashEquals() {
		SequentialFor sequentialFor = new SequentialFor("name", null, null, new ArrayList<>(), null, null);

		Assert.assertEquals(sequentialFor, sequentialFor);
		Assert.assertEquals(sequentialFor.hashCode(), sequentialFor.hashCode());
		Assert.assertNotEquals(sequentialFor, null);

		LoopCompound loopCompound = new LoopCompound();
		Assert.assertNotEquals(sequentialFor, loopCompound);

		SequentialFor sequentialFor2 = new SequentialFor("name", null, null, new ArrayList<>(), null, null);
		Assert.assertEquals(sequentialFor, sequentialFor2);
		Assert.assertEquals(sequentialFor.hashCode(), sequentialFor2.hashCode());
		sequentialFor2.setAdditionalProperty("name", "type");
		Assert.assertNotEquals(sequentialFor, sequentialFor2);

		SequentialFor sequentialFor3;
		sequentialFor3 = new SequentialFor("nameWrong", null, null, new ArrayList<>(), null, null);
		Assert.assertNotEquals(sequentialFor, sequentialFor3);

		sequentialFor3 = new SequentialFor("name", Collections.singletonList(new DataIns("name", "type", "source")),
				null, new ArrayList<>(), null, null);
		Assert.assertNotEquals(sequentialFor, sequentialFor3);

		sequentialFor3 = new SequentialFor("name", null, Collections.singletonList(new DataLoops()), new ArrayList<>(),
				null, null);
		Assert.assertNotEquals(sequentialFor, sequentialFor3);

		sequentialFor3 = new SequentialFor("name", null, null, Arrays.asList("10"), null, null);
		Assert.assertNotEquals(sequentialFor, sequentialFor3);

		sequentialFor3 = new SequentialFor("name", null, null, new ArrayList<>(),
				Collections.singletonList(new AtomicFunction()), null);
		Assert.assertNotEquals(sequentialFor, sequentialFor3);

		sequentialFor3 = new SequentialFor("name", null, null, new ArrayList<>(), null,
				Collections.singletonList(new DataOuts("name", "type", "source")));
		Assert.assertNotEquals(sequentialFor, sequentialFor3);
	}
}
