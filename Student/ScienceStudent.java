package Student;

class ScienceStudent extends Student {

    private int attendance;
    private int project;
    private int midterm;
    private int finalExam;

    public ScienceStudent(String firstName, String lastName,int attendance, int project, int midterm, int finalExam) {
        super(firstName, lastName, "Science");
        this.attendance=attendance;
        this.project=project;
        this.midterm=midterm;
        this.finalExam=finalExam;
    }

    @Override
    public double calculateFinalGrade() {
        return (attendance+0.1)+(project*0.3)+(midterm*0.3)+(finalExam*0.3);
    }
}
