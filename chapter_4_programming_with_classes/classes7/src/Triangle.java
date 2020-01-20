//Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
// вычисления площади, периметра и точки пересечения медиан.
public class Triangle {
    double side1;
    double side2;
    double side3;
    boolean isExist = true;

    public static void main(String[] args) {

        Triangle t = new Triangle();
        t.medianIntersection();
        double area = t.areaTriangle();
        double perimetr = t.perimetrTriangle();
        System.out.printf("Perimetr = %f; area = %f", perimetr, area);
        Triangle t2 = new Triangle(10, 5, 6);
        t2.medianIntersection();
    }

    Triangle() {
        this.side1 = 1;
        this.side2 = 1;
        this.side3 = 1;
        System.out.println("Triangle is created");
    }

    Triangle(double side1, double side2, double side3) {
        double max;
        if ((side1 >= side2) && (side1 >= side3)) {
            max = side1;
            if (max <= (side2 + side3)) {
                System.out.println("Triangle is created");
                isExist = true;
            } else {
                System.out.println("Triangle with such sides does not exist");
                isExist = false;
            }
        } else if ((side2 >= side1) && (side2 >= side3)) {
            max = side2;
            if (max <= (side1 + side3)) {
                System.out.println("Triangle is created");
                isExist = true;
            } else {
                System.out.println("Triangle with such sides does not exist");
                isExist = false;
            }
        } else if ((side3 >= side1) && (side3 >= side2)) {
            max = side3;
            if (max <= (side1 + side2)) {
                System.out.println("Triangle is created");
                isExist = true;
            } else {
                System.out.println("Triangle with such sides does not exist");
                isExist = false;
            }
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

    }

    public double areaTriangle() {
        if (!isExist) {
            System.out.println("Сan't calculate the area of non-existent triangle");
            return 0;
        }
        double p = (side1 + side2 + side3) / 2;
        double pp = p * (p - side1) * (p - side2) * (p - side3);
        return Math.sqrt(pp);
    }

    public double perimetrTriangle() {
        if (!isExist) {
            System.out.println("Сan't calculate the area of non-existent triangle");
            return 0;
        }
        return side1 + side2 + side3;
    }

    public void medianIntersection() {
        if (!isExist) {
            System.out.println("Сan't calculate the area of non-existent triangle");
            return;
        }
        double max = 0;
        double height = 0;
        double ab = 0;
        double p = (side1 + side2 + side3) / 2;
        //  find the height to the largest side
        if ((side1 >= side2) && (side1 >= side3)) {
            max = side1;
            if (side2 > side3) {
                ab = side2;
            } else {
                ab = side3;
            }
            height = (2 * (Math.sqrt(p * (p - side1) * (p - side2) * (p - side3)))) / max;
        } else if ((side2 >= side1) && (side2 >= side3)) {
            max = side2;
            if (side1 > side3) {
                ab = side1;
            } else {
                ab = side3;
            }
            height = (2 * (Math.sqrt(p * (p - side1) * (p - side2) * (p - side3)))) / max;
        } else if ((side3 >= side1) && (side3 >= side2)) {
            max = side3;
            if (side1 > side2) {
                ab = side1;
            } else {
                ab = side2;
            }
            height = (2 * (Math.sqrt(p * (p - side1) * (p - side2) * (p - side3)))) / max;
        }
        //coordinates of point A equal to 0.0
        //find the length from point A to point X. where X is point which devides AC by height
        //to find AX will use Pythagorean theorem

        double ax = Math.sqrt((ab * ab) - (height * height));
        double mx = (ax + max) / 2;
        double my = height / 2;

        double nx = (2 * mx) / 3;
        double ny = (2 * my) / 3;
        System.out.println("X:" + nx + " Y:" + ny);

    }
}
