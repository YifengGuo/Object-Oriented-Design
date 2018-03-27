package solid_principles;

/**
 * Created by guoyifeng on 3/26/18.
 * Open to extension, close to modification
 */
public class OpenClosePrinciple {
    /**
     * Each time the need is changed, say, we need to calculate a cycle, then we have to
     * add a new method to this class. So this design is not extensible.
     * Instead, we can design a new class called shape and all the other shapes inherit from this base class
     * and we design a method which receives a child class of Shape and do the calculation
     */
    class AreaCalculator {
        /**
         * calculate the area of a triangle
         * @param t
         * @return
         */
        public float calculateArea(Triangle t) {
            return 0.0f;
        }

        /**
         * calculate the area of a rectangle
         * @param r
         * @return
         */
        public float calculateArea(Rectangle r) {
            return 0.0f;
        }
    }

    class Triangle {

    }

    class Rectangle {

    }
}
