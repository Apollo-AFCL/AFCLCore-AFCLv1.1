package at.uibk.dps.afcl.functions.objects;

import at.uibk.dps.afcl.functions.Compound;
import org.junit.Assert;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Test the functionality of a condition object.
 *
 * @author stefanpedratscher
 */
public class ConditionTest {
    /**
     * Test full construction of an aCondition.
     *
     * @author stefanpedratscher
     */
    @Test
    public void testFullConstruction() {
        final Condition condition = new Condition("1", "2", "number", "==", "AND");

        Assert.assertEquals("1", condition.getData1());
        Assert.assertEquals("2", condition.getData2());
        Assert.assertEquals("==", condition.getOperator());
        Assert.assertEquals(0, condition.getAdditionalProperties().size());
    }

    /**
     * Test the empty construction of an aCondition.
     *
     * @author stefanpedratscher
     */
    @Test
    public void testEmptyConstruction() {
        final Condition aCondition = new Condition();

        Assert.assertNull(aCondition.getData1());
        Assert.assertNull(aCondition.getData2());
        Assert.assertNull(aCondition.getOperator());
        Assert.assertNull(aCondition.getNegation());
        Assert.assertEquals(0, aCondition.getAdditionalProperties().size());
    }

    /**
     * Test getter and setter
     *
     * @author stefanpedratscher
     */
    @Test
    public void testGetterAndSetter() {
        new BeanTester().testBean(Condition.class);
    }

    /**
     * Test hashCode and equals
     *
     * @author stefanpedratscher
     */
    @Test
    public void testHashEquals() {
        final Condition aCondition = new Condition("1", "2", "number", "!=", "AND");

        Assert.assertEquals(aCondition, aCondition);
        Assert.assertEquals(aCondition.hashCode(), aCondition.hashCode());
        Assert.assertNotEquals(aCondition, null);

        final Compound compound = new Compound();
        Assert.assertNotEquals(aCondition, compound);

        final Condition aCondition2 = new Condition("1", "2", "number", "!=", "AND");
        Assert.assertEquals(aCondition, aCondition2);
        Assert.assertEquals(aCondition.hashCode(), aCondition2.hashCode());
        aCondition2.setAdditionalProperties("name", "type");
        Assert.assertNotEquals(aCondition, aCondition2);

        Condition aCondition3;
        aCondition3 = new Condition("5", "2", "number", "!=", "AND");
        Assert.assertNotEquals(aCondition, aCondition3);

        aCondition3 = new Condition("1", "5", "number", "!=", "AND");
        Assert.assertNotEquals(aCondition, aCondition3);

        aCondition3 = new Condition("1", "2", "number", "==", "AND");
        Assert.assertNotEquals(aCondition, aCondition3);

        aCondition3 = new Condition("1", "2", "number", "!=", "AND");
        aCondition3.setNegation("negation");
        Assert.assertNotEquals(aCondition, aCondition3);
    }
}
