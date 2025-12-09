import java.util.*;

class Student {
    private String name;
    private String surname;
    private String id;
    private int averageScore;

    public Student(String name, String surname, String id, int averageScore) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.averageScore = averageScore;
    }

    public int getAverageScore() {
        return averageScore;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", залікова: " + id + ", середній бал: " + averageScore;
    }
}

class Faculty {
    private String name;
    private List<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }
}

class Institute {
    private String name;
    private List<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}

public class Main {
    public static void main(String[] args) {

        // Створення тестових даних
        Student s1 = new Student("Олексій", "Ткаченко", "01832", 85);
        Student s2 = new Student("Марія", "Коваленко", "01833", 97);
        Student s3 = new Student("Іван", "Шевченко", "01834", 92);
        Student s4 = new Student("Анна", "Бондаренко", "01835", 99);

        Faculty its = new Faculty("ІТС");
        its.addStudent(s1);
        its.addStudent(s2);

        Faculty fmм = new Faculty("ФММ");
        fmм.addStudent(s3);
        fmм.addStudent(s4);

        Institute kpi = new Institute("КПІ");
        kpi.addFaculty(its);
        kpi.addFaculty(fmм);

        // ========== ЗАВДАННЯ 1: for-each ==========
        int totalStudents = 0;

        for (Faculty f : kpi.getFaculties()) {
            totalStudents += f.getStudents().size();
        }

        System.out.println("1) Загальна кількість студентів: " + totalStudents);

        // ========== ЗАВДАННЯ 2: ListIterator (типізований) ==========
        Faculty maxFaculty = null;
        int maxCount = -1;

        ListIterator<Faculty> it = kpi.getFaculties().listIterator();
        while (it.hasNext()) {
            Faculty f = it.next();
            int count = f.getStudents().size();

            if (count > maxCount) {
                maxCount = count;
                maxFaculty = f;
            }
        }

        System.out.println("2) Факультет з найбільшою кількістю студентів: " +
                (maxFaculty != null ? maxFaculty.getName() : "немає"));

        // ========== ЗАВДАННЯ 3: НЕТИПІЗОВАНИЙ Iterator ==========
        List<Student> bestStudents = new ArrayList<>();

        for (Faculty f : kpi.getFaculties()) {
            @SuppressWarnings("unchecked")  
            Iterator studentIterator = f.getStudents().iterator();

            while (studentIterator.hasNext()) {
                // Явне приведення типу (casting)
                Student st = (Student) studentIterator.next();
                
                if (st.getAverageScore() >= 95 && st.getAverageScore() <= 100) {
                    bestStudents.add(st);
                }
            }
        }

        System.out.println("3) Студенти зі середнім балом 95..100:");

        if (bestStudents.isEmpty()) {
            System.out.println("    Немає таких студентів");
        } else {
            bestStudents.forEach(st -> System.out.println("    " + st));
        }
    }
}