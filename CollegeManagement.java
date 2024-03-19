/*
 *
 * College Management
 * Student data
 * Student Details
 *
 */
package college;
import java.util.Scanner;
public class CollegeManagement
{

    public static void main(String[] args){
        final StudentView studentView = new StudentView();
        final Student student = studentView.getStudentDetails();

        System.out.println("Student details");
        System.out.println(student.getName());
        System.out.println(student.getDateOfBirth());
        System.out.println(student.getPhone());
        System.out.println(student.getDepartment());
        System.out.println(student.getGender());
    }
}
class StudentView{

    private static final Scanner SCANNER = new Scanner(System.in);

    public Student getStudentDetails() {
        final String name = getName();
        final String dateOfBirth = getDateOfBirth();
        final Long mobile = getPhone();
        final Student.Department department = getDepartment();
        final Student.Gender gender = getGender();

        return new Student(name, dateOfBirth, mobile, department, gender);
    }

    private Student.Gender getGender(){
        System.out.println("Enter a gender");
        String chooseGender = SCANNER.nextLine();

        return Student.Gender.data1(chooseGender);
    }

    private Student.Department getDepartment(){
        System.out.println("Enter a Department");
        String departmentName = SCANNER.nextLine();

        return Student.Department.data(departmentName);
    }

    private String getName() {
        System.out.println("Enter your name");

        return SCANNER.nextLine();
    }

    private String getDateOfBirth() {
        System.out.println("Enter your date of birth");

        return SCANNER.nextLine();
    }

    private Long getPhone() {
        System.out.println("Enter your phone");

        return SCANNER.nextLong();
    }
}

class Student {
    enum Department {
        BIOMEDICAL("biomedical"), BIOTECH("biotech"), CIVIL("civil"), COUMPUTERSCIENCE("computerscience"), MECHANICAL("mech");

        final private String departmentName;

        Department(String departmentName) {
            this.departmentName = departmentName;
        }

        public static final Department data(String department) {
            switch (department) {
                case "civil":
                    return Department.CIVIL;
                case "mechanical":
                    return Department.MECHANICAL;
                case "biomedical":
                    return Department.BIOMEDICAL;
                case "biotech":
                    return Department.BIOTECH;
                case "computerscience":
                    return Department.COUMPUTERSCIENCE;
                default:
                    return null;
            }
        }
    }

        enum Gender {
            MALE("male"), FEMALE("female"), OTHERS("others");
            final private String chooseGender;

            Gender(String chooseGender) {
                this.chooseGender = chooseGender;
            }

            public static final Gender data1(String gender) {
                    switch (gender) {
                        case "male":
                            return Gender.MALE;
                        case "female":
                            return Gender.FEMALE;
                        case "others":
                            return Gender.OTHERS;
                        default:
                            return null;
                    }
            }

    }

            private Department department;
            private Gender gender;
            private String name;
            private String dateOfBirth;
            private Long phone;

            Student(final String name, final String dateOfBirth, final Long phone, final Department department, final Gender gender) {
                this.name = name;
                this.dateOfBirth = dateOfBirth;
                this.phone = phone;
                this.department = department;
                this.gender = gender;
            }

            public String getName() {
                return name;
            }

            public void setName(final String name) {
                this.name = name;
            }

            public String getDateOfBirth() {
                return dateOfBirth;
            }

            public void setDateOfBirth(final String dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
            }

            public Long getPhone() {
                return phone;
            }

            public void setPhone(final Long phone) {
                this.phone = phone;
            }

            public Department getDepartment() {
                return department;
            }

            public void setDepartment(final Department department) {
                this.department = department;
            }

            public Gender getGender() {
                return gender;
            }

            public void setGender(Gender gender) {
                this.gender = gender;
            }
}

