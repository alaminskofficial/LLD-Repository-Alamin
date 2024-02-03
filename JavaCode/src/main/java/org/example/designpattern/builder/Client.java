package org.example.designpattern.builder;
//@Author : Sk Alamin
public class Client {
    public static void main(String[] args) throws Exception {
        Student student = Student.createBuilder()
                .setAge(26)
                .setName("Alamin")
                .setGender(Gender.MALE)
//                .setPsp(91.99)
                .setUniversityName("Jadavpur University")
                .setPhoneNumber("1123456789")
                .build();
    }

}
