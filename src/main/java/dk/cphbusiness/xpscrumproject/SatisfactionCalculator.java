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
        for (Student student : studentlist) {
            student.setGrades(0, 0);
            boolean poolAset = false;
            boolean poolBset = false;
            boolean firstGradeSet = false;
            boolean secondGradeSet = false;
            Subject[] firstPrio = student.getFirstPriority();
            Subject[] secondPrio = student.getSecondPriority();

            for (Subject subject : poolA) {
                if (subject.getTitle().equals(firstPrio[0].getTitle()) || subject.getTitle().equals(firstPrio[1].getTitle())) {
                    firstGradeSet = true;
                    poolAset = true;
                    student.setFirstGrade(1);
                }
            }

            for (Subject subject : poolB) {
                if (subject.getTitle().equals(firstPrio[0].getTitle()) || subject.getTitle().equals(firstPrio[1].getTitle())) {
                    if (firstGradeSet) {
                        secondGradeSet = true;
                        student.setSecondGrade(1);
                        poolBset = true;
                    } else {
                        firstGradeSet = true;
                        student.setFirstGrade(1);
                        poolBset = true;
                    }

                }
            }
            
            if (!firstGradeSet || !secondGradeSet) {
                if (!poolAset) {
                    for (Subject subject : poolA) {
                        if (subject.getTitle().equals(secondPrio[0].getTitle()) || subject.getTitle().equals(secondPrio[1].getTitle())) {
                           
                            if (firstGradeSet) {
                                secondGradeSet = true;
                                student.setSecondGrade(2);
                            } else {
                                firstGradeSet = true;
                                student.setFirstGrade(2);
                            }

                        }
                    }
                }
                if (!poolBset) {
                    for (Subject subject : poolB) {
                        if (subject.getTitle().equals(secondPrio[0].getTitle()) || subject.getTitle().equals(secondPrio[1].getTitle())) {
                            if (firstGradeSet) {
                                secondGradeSet = true;
                                student.setSecondGrade(2);
                            } else {
                                firstGradeSet = true;
                                student.setFirstGrade(2);
                            }

                        }
                    }
                }
            }
        }

        return studentlist;
    }
}
