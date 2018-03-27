package solid_principles;

/**
 * Created by guoyifeng on 3/27/18.
 *
 * Abstraction shall not depend on the concrete implementation
 * Concrete implementation shall depend on abstraction
 */
public class DependencyInversionPrinciple {
    /**
     * This is a good design
     * the implementation of calculateArea() depends on the abstraction of ShapeInterface
     */
    class AreaCalculator {
        public float calculateArea(ShapeInterface s) {
            // calculate the area of given shape which implements the interface
            return 0.0f;
        }
    }

    interface ShapeInterface {
        public float getArea();
    }

    class Rectangle implements ShapeInterface {
        private float length;
        private float width;

        @Override
        public float getArea() {
            return length * width;
        }
    }

    class Triangle implements ShapeInterface {
        private float length;
        private float width;

        @Override
        public float getArea() {
            return length * width / 2;
        }
    }
}
