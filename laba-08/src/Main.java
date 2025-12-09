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

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", залікова: " + id + ", середній бал: " + averageScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return id.equals(s.id); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}



class Faculty {
    private String name;

  
    private Set<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new HashSet<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public Set<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }
}



class Institute {
    private String name;

    // ПРОТИ List → HashSet
    private Set<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new HashSet<>();
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }
}



public class Main {
    public static void main(String[] args) {


        Student s1 = new Student("Олексій", "Ткаченко", "01832", 85);
        Student s2 = new Student("Анна", "Литвин", "00321", 97);
        Student s3 = new Student("Георгій", "Гавриленко", "00411", 99);

        Faculty its = new Faculty("ІТС");
        its.addStudent(s1);
        its.addStudent(s2);
        its.addStudent(s3);

        Faculty fiot = new Faculty("ФІОТ");

        Student s4 = new Student("Марія", "Шевченко", "01451", 96);
        fiot.addStudent(s4);

        Institute kpi = new Institute("КПІ");
        kpi.addFaculty(its);
        kpi.addFaculty(fiot);

        int totalStudents = 0;
        for (Faculty f : kpi.getFaculties()) {
            totalStudents += f.getStudents().size();
        }

        System.out.println("1) Загальна кількість студентів: " + totalStudents);


   
        List<Faculty> facultyList = new ArrayList<>(kpi.getFaculties());
        ListIterator<Faculty> it = facultyList.listIterator();

        Faculty maxFaculty = null;
        int maxCount = -1;

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


        Set<Student> bestStudents = new HashSet<>();

        for (Faculty f : kpi.getFaculties()) {
            Iterator<Student> sit = f.getStudents().iterator();

            while (sit.hasNext()) {
                Student st = sit.next();
                if (st.getAverageScore() >= 95 && st.getAverageScore() <= 100) {
                    bestStudents.add(st);
                }
            }
        }

        System.out.println("3) Студенти з балом 95..100:");
        bestStudents.forEach(st -> System.out.println("    " + st));



        Map<String, Student> studentMap = new HashMap<>();

        for (Faculty f : kpi.getFaculties()) {
            for (Student s : f.getStudents()) {
                studentMap.put(s.getId(), s);
            }
        }

        System.out.println("\n4) Пошук студента за ID (Map):");
        String searchId = "00321";
        System.out.println("    Шукаємо " + searchId);
        System.out.println("    Знайдено: " + studentMap.getOrDefault(searchId, null));
    }
}
