import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BMI_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of student in class ");
        int n = sc.nextInt();

        int roll_no;
        double weight, height;
        String name;
        List<Double> list = new ArrayList<>();
        // List<Double> BMICalc = new ArrayList<>();
        List<Double> weightList = new ArrayList<>();
        List<Double> heightList = new ArrayList<>();
        List<Integer> s_rollno = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("Enter student " + (i + 1) + " Details");
            System.out.print("Rollno : ");
            roll_no = sc.nextInt();
            System.out.print("weight : ");
            weight = sc.nextDouble();
            System.out.print("height : ");
            height = sc.nextDouble();
            System.out.print("name : ");
            name = sc.next();

            double BMI = CalculateBMI(weight, height);
            list.add(BMI);
            s_rollno.add(roll_no);
            weightList.add(weight);
            heightList.add(height);
        }
        // for (int j = 0; j < n; j++) {
        // BMICalc.add(list.get(j));
        // }

        System.out.println("Press 1 for getBMI of all student");
        System.out.println("Press 2 for overweightBMI of all student");
        System.out.println("Press 3 for list of healthyStudent  student");
        System.out.println("Press 4 for update weight and height student");
        System.out.println("Press 5 for Exit from Application");
        while (true) {
            System.out.println("Enter your choice");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    getBMI(n, list, s_rollno);
                    break;
                case 2:
                    overweightBMI(n, list, s_rollno);
                    break;
                case 3:
                    healthyStudent(n, list, s_rollno);
                    break;
                case 4:
                    System.out.println(weightList);
                    System.out.println(heightList);
                    System.out.println("Enter the no where you want to update weight & height");
                    int i = sc.nextInt();

                    // int RollNo = s_rollno.get(i);
                    // System.out.println(RollNo);

                    List<Double> update = UpdateWeight_Height();

                    System.out.println("update list : " + update);

                    weightList.set(i, update.get(0));
                    heightList.set(i, update.get(1));
                    list.set(i, update.get(2));
                    break;
                case 5:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    public static List<Double> UpdateWeight_Height() {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter updated weight");
        double weight = sc.nextDouble();
        // weightList.add(roll_noIndex, weight);

        System.out.println("enter updated height");
        double height = sc.nextDouble();

        List<Double> updateWH = new ArrayList<>();
        updateWH.add(weight);
        updateWH.add(height);
        updateWH.add(CalculateBMI(weight, height));

        return updateWH;

    }

    public static double CalculateBMI(double weight, double height) {
        double BMI = weight / (height * height);
        return BMI;
    }

    public static void getBMI(int n, List<Double> BMICalc, List<Integer> s_rollno) {
        for (int i = 0; i < n; i++) {
            System.out.println("Rollno :  " + s_rollno.get(i) + " BMI is : " + BMICalc.get(i));
        }
    }

    public static void overweightBMI(int n, List<Double> BMICalc, List<Integer> s_rollno) {
        System.out.println("**********  Overweight BMI List   ********");
        for (int i = 0; i < n; i++) {
            Double x = BMICalc.get(i);
            if (x >= 25.0 && x <= 29.9) {
                System.out.println("Roll no : " + s_rollno.get(i) + "  BMI is : " + BMICalc.get(i));
            }
        }
    }

    public static void healthyStudent(int n, List<Double> BMICalc, List<Integer> s_rollno) {
        System.out.println("**********  Healthy Student List  ********");
        for (int i = 0; i < n; i++) {
            Double x = BMICalc.get(i);
            if (x >= 18.5 && x <= 24.9) {
                System.out.println("Roll no : " + s_rollno.get(i) + "  BMI is : " + BMICalc.get(i));
            }
        }
    }
}
