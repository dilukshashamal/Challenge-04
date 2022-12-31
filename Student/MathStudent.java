package Student;

public class MathStudent extends Student{

    private int quiz1;
    private int quiz2;
    private int quiz3;
    private int quiz4;
    private int quiz5;
    private int test1;
    private int test2;
    private int finalExam;

    public MathStudent(String firstName, String lastName, int quiz1, int quiz2, int quiz3, int quiz4, int quiz5, int test1, int test2, int finalExam) {
        super(firstName, lastName, "Math");
        this.quiz1=quiz1;
        this.quiz2=quiz2;
        this.quiz3=quiz3;
        this.quiz4=quiz4;
        this.quiz5=quiz5;
        this.test1=test1;
        this.test2=test2;
        this.finalExam=finalExam;
    }

    @Override
    public double calculateFinalGrade() {
        double quizAverage = (double)(quiz1+quiz2+quiz3+quiz4+quiz5)/5;
        return (quizAverage*0.15)+(test1*0.3)+(test2*0.2)+(finalExam*0.35);
    }
}
