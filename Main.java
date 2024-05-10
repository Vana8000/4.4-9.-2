import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
interface Student {
    void learn();
}
class ConcreteStudent implements Student {
    @Override
    public void learn() {
        System.out.println("я учусь. .zZ");
    }
}
abstract class StudentDecorator implements Student {
    protected Student decoratedStudent;

    public StudentDecorator(Student student) {
        this.decoratedStudent = student;
    }
    public void learn() {
        decoratedStudent.learn();
    }
}

class StudentWithClock extends StudentDecorator {
    public StudentWithClock(Student student) {
        super(student);
    }
    @Override
    public void learn() {
        super.learn();
        printCurrentTime();
        System.out.println("я закончил учитьс€");
    }
    private void printCurrentTime() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("“екущее врем€: " + time.format(formatter));
    }
}
public class Main {
    public static void main(String[] args) {
        Student student = new ConcreteStudent();
        Student studentWithClock = new StudentWithClock(student);

        studentWithClock.learn();
    }
}