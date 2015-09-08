/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.xpscrumproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muggi
 */
public class SatisfactionCalculator implements SatisfactionCalculatorInterface {

    @Override
    public List<Student> calculate(List<Student> studentlist, List<Subject> poolA, List<Subject> poolB) {
        for (int i = 0; i < studentlist.size(); i++) {
//        for (Student student : studentlist) {
//            student.setGrades(0, 0);
            studentlist.get(i).setGrades(0, 0);
            boolean poolAset = false;
            boolean poolBset = false;
            boolean firstGradeSet = false;
            boolean secondGradeSet = false;
//            Subject[] firstPrio = student.getFirstPriority();
//            Subject[] secondPrio = student.getSecondPriority();
            Subject[] firstPrio = studentlist.get(i).getFirstPriority();
            Subject[] secondPrio = studentlist.get(i).getSecondPriority();
            if (!poolA.isEmpty()) {
                for (Subject subject : poolA) {
                    if (subject.getTitle().equals(firstPrio[0].getTitle()) || subject.getTitle().equals(firstPrio[1].getTitle())) {
                        if (!poolAset) {
                            firstGradeSet = true;
                            poolAset = true;
                            System.out.println("FirstPrio");
//                    student.setFirstGrade(1);
                            studentlist.get(i).setFirstGrade(1);
                        }
                    }
                }
            }
            if (!poolB.isEmpty()) {
                for (Subject subject : poolB) {
                    if (subject.getTitle().equals(firstPrio[0].getTitle()) || subject.getTitle().equals(firstPrio[1].getTitle())) {
                        if (!poolBset) {
                            if (firstGradeSet) {
                                secondGradeSet = true;
//                        student.setSecondGrade(1);
                                studentlist.get(i).setSecondGrade(1);
                                poolBset = true;
                            } else {
                                firstGradeSet = true;
//                        student.setFirstGrade(1);
                                studentlist.get(i).setFirstGrade(1);
                                poolBset = true;
                            }
                        }
                    }
                }
            }
            if (!poolA.isEmpty()) {
                if (!firstGradeSet || !secondGradeSet) {
                    if (!poolAset) {
                        for (Subject subject : poolA) {
                            if (subject.getTitle().equals(secondPrio[0].getTitle()) || subject.getTitle().equals(secondPrio[1].getTitle())) {
                                if (!poolAset) {
                                    if (firstGradeSet) {
                                        poolAset = true;
                                        secondGradeSet = true;
//                                student.setSecondGrade(2);
                                        studentlist.get(i).setSecondGrade(2);
                                    } else {
                                        poolAset = true;
                                        firstGradeSet = true;
//                                student.setFirstGrade(2);
                                        studentlist.get(i).setFirstGrade(2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!poolB.isEmpty()) {
                if (!poolBset) {
                    for (Subject subject : poolB) {
                        if (subject.getTitle().equals(secondPrio[0].getTitle()) || subject.getTitle().equals(secondPrio[1].getTitle())) {
                            if (!poolBset) {
                                if (firstGradeSet) {
                                    poolBset = true;
                                    secondGradeSet = true;
//                                student.setSecondGrade(2);
                                    studentlist.get(i).setSecondGrade(2);
                                } else {
                                    poolBset = true;
                                    firstGradeSet = true;
//                                student.setFirstGrade(2);
                                    studentlist.get(i).setFirstGrade(2);
                                }
                            }
                        }
                    }
                }
            }
        }
        studentlist = sortList(studentlist);
        return studentlist;
    }

    @Override
    public List<Student> sortList(List<Student> slist) {
        List<Student> list00 = new ArrayList();
        List<Student> list20 = new ArrayList();
        List<Student> list10 = new ArrayList();
        List<Student> list22 = new ArrayList();
        List<Student> list12 = new ArrayList();
        List<Student> list11 = new ArrayList();
        List<Student> resultList = new ArrayList();

        for (Student s : slist) {
            if (s.getGrades()[0] == 0 && s.getGrades()[1] == 0) {
                list00.add(s);
            } else if (s.getGrades()[0] == 2 && s.getGrades()[1] == 0) {
                list20.add(s);
            } else if (s.getGrades()[0] == 1 && s.getGrades()[1] == 0) {
                list10.add(s);
            } else if (s.getGrades()[0] == 2 && s.getGrades()[1] == 2) {
                list22.add(s);
            } else if (s.getGrades()[0] == 1 && s.getGrades()[1] == 2) {
                list12.add(s);
            } else if (s.getGrades()[0] == 1 && s.getGrades()[1] == 1) {
                list11.add(s);
            }
        }
        
        for (Student s : list00) {
            resultList.add(s);
        }
        
        for (Student s : list20) {
            resultList.add(s);
        }
        
        for (Student s : list10) {
            resultList.add(s);
        }
        
        for (Student s : list22) {
            resultList.add(s);
        }
        
        for (Student s : list12) {
            resultList.add(s);
        }
        
        for (Student s : list11) {
            resultList.add(s);
        }
        
        return resultList;
    }
}
