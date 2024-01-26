package org.example.designpattern.builder;

public class Student {
    private String name;
    private int age;
    private String universityName;
    private Gender gender;
    private String phoneNumber;
    private double psp;

    private Student(Builder builder){
        this.name = builder.getName();
        this.universityName = builder.getUniversityName();
        this.age = builder.getAge();
        this.gender = builder.getGender();
        this.phoneNumber = builder.getPhoneNumber();
        this.psp = builder.getPsp();;
    }

    public static Builder createBuilder(){
        return new Builder();
    }


    static class Builder {
        private String name;
        private int age;
        private String universityName;
        private Gender gender;
        private String phoneNumber;
        private double psp;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getUniversityName() {
            return universityName;
        }

        public Builder setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public Gender getGender() {
            return gender;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        private boolean validate() {
            if (this.phoneNumber.length() != 10) {
                return false;
            }
            return true;
        }


        public Student build() throws Exception {
            // start validations
            if (!validate()) {
                throw new Exception();
            }

            // end validations

            return new Student(this);
        }
    }
}
