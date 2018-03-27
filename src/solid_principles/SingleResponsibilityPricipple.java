package solid_principles;

/**
 * Created by guoyifeng on 3/26/18.
 *
 * A class should have one and only one reason to change it
 * which means a class should be designed to have only one job
 */
public class SingleResponsibilityPricipple {
    /**
     * The class AreaCalculator is responsible for calculating area as well as
     * print something. So this is not a good design
     * Instead, we could design a new class to print all kinds of required accuracy result
     */
    class AreaCalculator {
        private float result;

        public float calculateArea(Shape s) {
            // calculates the area for a given shape, store it in the result
            return 0.0f;
        }


        public String printAreaAccurateToDecimalPlace() { // bad naming
            // prints result accurate to one decimal place
            return "";
        }
    }

    class Shape {

    }
}
