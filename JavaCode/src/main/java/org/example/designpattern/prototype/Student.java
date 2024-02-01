package org.example.designpattern.prototype;

public class Student implements Prototype {
    private String name;
    private  int age;
    private double psp;
    private String batchName;
    private String avgBatchPsp;

    public Student() {
    }
    public Student(Student st){
        this.name = st.name;
        this.age = st.age;
        this.psp = st.psp;
        this.batchName = st.batchName;
        this.avgBatchPsp = st.avgBatchPsp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getAvgBatchPsp(String number) {
        return avgBatchPsp;
    }

    public void setAvgBatchPsp(String avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }

    @Override
    public Student clone() {
        return new Student(this);
    }
}
