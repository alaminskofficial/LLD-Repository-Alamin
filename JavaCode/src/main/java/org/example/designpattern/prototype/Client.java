package org.example.designpattern.prototype;
//@Author : Sk Alamin
public class Client {
    public static void main(String[] args) {
        StudentRegistry sr = new StudentRegistry();
        fillRegistry(sr);

        Student st1 = sr.get("APR23BATCH").clone();
        st1.setName("Alamin");
        st1.setAge(23);
        st1.setPsp(99);

        Student st2 = sr.get("APR23IntelligentBatch").clone();
        st2.setName("sk alamin");
        st2.setAge(24);
        st2.setPsp(79);
    }

    public static void fillRegistry(StudentRegistry sr) {
        Student apr23Batch = new Student();
        apr23Batch.setBatchName("APR23BeginnerBatch");
        apr23Batch.setAvgBatchPsp("85");
        sr.register("APR23BATCH", apr23Batch);

        IntelligentStudent st = new IntelligentStudent();
        st.setIq(187);
        st.setBatchName("APR23IntelligentBatch");
        st.setAvgBatchPsp("89");
        sr.register("APR23IntelligentBatch", st);
    }
}
