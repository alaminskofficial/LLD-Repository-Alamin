package org.example.designpattern.prototype;

public class IntelligentStudent extends  Student{
    private int iq;
    public IntelligentStudent(){};

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public  IntelligentStudent(IntelligentStudent st){
        super(st);
        this.iq = st.iq;
    }
    public IntelligentStudent clone(){
        return  new IntelligentStudent(this);
    }

}
