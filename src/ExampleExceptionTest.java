import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class ExampleExceptionTest {

  /**
   * Test data for positive test.
   *
   * @return test data array
   */
  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
            {2, 2, 4},
            {2, 3, 6},
            {1, 0, 0},
            {0, 4, 0},
            {0b0010, 4, 8}
    };
  }

  /**
   * Test data for exception test.
   *
   * @return test data array
   */
  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
            {-2, 2},
            {2, -2},
            {-2, -2},
            //{2, 2} // for test correctness test-cases
    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int c) {
    assertEquals(ExampleException.rectangleArea(a, b), c, "Square is incorrect");
  }


  @Test(dataProvider = "negativeData")
  public void testRectangleAreaNegative(int a, int b) {
    try {
      ExampleException.rectangleArea(a, b);
      fail("This code shouldn't be executed"); // check if exception really was present.
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "input value is below zero!", "Message of IllegalArgumentException is incorrect");
    }
  }
}