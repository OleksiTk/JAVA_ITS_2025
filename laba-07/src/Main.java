
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

        // --- Дані з умови ---
        Student s1 = new Student("Олексій", "Ткаченко", "01832", 85);

        Faculty its = new Faculty("ІТС");
        its.addStudent(s1);

        Institute kpi = new Institute("КПІ");
        kpi.addFaculty(its);

        // =========================
        // 1) Порахувати загальну кількість студентів (тип ітератора b = for-each)
        // =========================
        int totalStudents = 0;

        for (Faculty f : kpi.getFaculties()) {  // for-each
            totalStudents += f.getStudents().size();
        }

        System.out.println("1) Загальна кількість студентів: " + totalStudents);

        // =========================
        // 2) Знайти факультет з найбільшою кількістю студентів (тип ітератора c = ListIterator)
        // =========================
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

        // =========================
        // 3) Студенти з середнім балом у діапазоні 95..100 (тип ітератора a = Iterator)
        // =========================
        List<Student> bestStudents = new ArrayList<>();

        for (Faculty f : kpi.getFaculties()) {
            Iterator<Student> studentIterator = f.getStudents().iterator(); // Iterator

            while (studentIterator.hasNext()) {
                Student st = studentIterator.next();
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
