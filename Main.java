import java.util.Random;

public class Main {


    public static void main(String[] args) throws Exception {
        Random random = new Random();

        Graduate student;
        Undergraduate student1;
        for (int i = 0; i < 10; i++) {
            int ranId = 100000 + random.nextInt(900000);
            double ranGPA = 1.0 + (3.0 * random.nextDouble());
            int ranType =  random.nextInt(2);
            if (ranType == 0) {
                student = new Graduate(ranId, ranGPA);
                //"ID>>"+ID+" ,GPA>>"+GPA+" ,Status>>"+getStatus()
                System.out.println("Graduate"+student.displayStudent());

            } else {
                student1 = new Undergraduate(ranId, ranGPA);
                System.out.println("Undergraduate"+student1.displayStudent());

            }
        }

    }
    public abstract static class Student{
        int ID;
        double GPA;
        public Student(int ID1,double GPA1){
            this.ID =ID1;
            this.GPA =GPA1;
        }
        public abstract String getStatus();
        public String displayStudent(){
            return "ID>>"+ID+" ,GPA>>"+GPA+" ,Status>>"+getStatus();
        }
    }
    //The status of the graduate student is good if his GPA is 3.0 or above otherwise it is probation.
    // The undergraduate's status is honor if his GPA is 3.0 or above, good if his GPA is 2.0 or above, probation otherwise.
    public static class Graduate extends Student{
        public Graduate(int ID1, double GPA1) {
            super(ID1, GPA1);
        }

        @Override
        public String getStatus() {
            if (GPA >= 3) {
                return "Good";
            } else {
                return "Prohibition";
            }
        }
    }
    public static class Undergraduate extends Student{
        public Undergraduate(int ID1, double GPA1) {
            super(ID1, GPA1);
        }

        @Override
        public String getStatus() {
            if (GPA >= 3) {
                return "Honor";
            } else if (GPA>=2){
                return "Good";
            } else {
                return "Prohibition";
            }
        }
    }
}
