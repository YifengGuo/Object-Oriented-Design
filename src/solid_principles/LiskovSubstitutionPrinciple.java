package solid_principles;

/**
 * Created by guoyifeng on 3/27/18.
 *
 * Any child class or derived class should be designed to be capable of
 * substitute their super class or base class
 */
public class LiskovSubstitutionPrinciple  {
    /**
     * The problem here is that a rectangle is a 2-d shape which cannot calculate its
     * volume.
     * Instead, we can design a base class Shape
     * then design two derived class 2DShape and 3DShape
     * and all child class should derive from this two super class
     */
    abstract class Shape {
        abstract public float calculateVolume();
        abstract public float calculateArea();
    }

    class Rectangle extends Shape {
        @Override
        public float calculateVolume() {
            return 0.0f;
        }

        @Override
        public float calculateArea() {
            return 0.0f;
        }
    }

    class Cube extends Shape {
        @Override
        public float calculateVolume() {
            return 0.0f;
        }

        @Override
        public float calculateArea() {
            return 0.0f;
        }
    }
}
