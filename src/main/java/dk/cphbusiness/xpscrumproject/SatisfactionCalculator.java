package dk.cphbusiness.xpscrumproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muggi
 */
public class SatisfactionCalculator implements SatisfactionCalculatorInterface {

    @Override
    public List<Student> calculate(List<Student> studentlist, List<Subject> poolA, List<Subject> poolB, List<Subject> poolC) {
        for (Student student : studentlist) {
            student.setGrades(0, 0, 0);
            boolean poolAset = false;
            boolean poolBset = false;
            boolean poolCset = false;
            boolean firstGradeSet = false;
            boolean secondGradeSet = false;
            boolean thirdGradeSet = false;
            List<Subject> firstPrio = student.getFirstPriority();
            List<Subject> secondPrio = student.getSecondPriority();

            if (!poolA.isEmpty()) {
                for (Subject subject : poolA) {
                    if (subject.getTitle().equals(firstPrio.get(0).getTitle()) || subject.getTitle().equals(firstPrio.get(1).getTitle()) || subject.getTitle().equals(firstPrio.get(2).getTitle())) {
                        if (!poolAset) {
                            if (!firstGradeSet) {
                                firstGradeSet = true;
                                poolAset = true;
                                student.setFirstGrade(1);
                            }

                        }
                    }
                }
            }
            if (!poolB.isEmpty()) {
                for (Subject subject : poolB) {
                    if (subject.getTitle().equals(firstPrio.get(0).getTitle()) || subject.getTitle().equals(firstPrio.get(1).getTitle()) || subject.getTitle().equals(firstPrio.get(2).getTitle())) {
                        if (!poolBset) {
                            if (!firstGradeSet) {
                                firstGradeSet = true;
                                poolBset = true;
                                student.setFirstGrade(1);
                            } else if (!secondGradeSet) {
                                secondGradeSet = true;
                                poolBset = true;
                                student.setSecondGrade(1);
                            }
                        }
                    }
                }
            }
            if (!poolC.isEmpty()) {
                for (Subject subject : poolC) {
                    if (subject.getTitle().equals(firstPrio.get(0).getTitle()) || subject.getTitle().equals(firstPrio.get(1).getTitle()) || subject.getTitle().equals(firstPrio.get(2).getTitle())) {
                        if (!poolCset) {
                            if (!firstGradeSet) {
                                firstGradeSet = true;
                                poolCset = true;
                                student.setFirstGrade(1);
                            } else if (!secondGradeSet) {
                                secondGradeSet = true;
                                poolCset = true;
                                student.setSecondGrade(1);
                            } else {
                                thirdGradeSet = true;
                                poolCset = true;
                                student.setThirdGrade(1);
                            }
                        }
                    }
                }
            }

            //_________________________________________________________________________________________________________________________________
            if (!firstGradeSet || !secondGradeSet || !thirdGradeSet) {
                if (!poolA.isEmpty()) {
                    if (!poolAset) {
                        for (Subject subject : poolA) {
                            if (subject.getTitle().equals(secondPrio.get(0).getTitle()) || subject.getTitle().equals(secondPrio.get(1).getTitle()) || subject.getTitle().equals(secondPrio.get(2).getTitle())) {
                                if (!poolAset) {
                                    if (!firstGradeSet) {
                                        firstGradeSet = true;
                                        poolAset = true;
                                        student.setFirstGrade(2);
                                    } else if (!secondGradeSet) {
                                        secondGradeSet = true;
                                        poolAset = true;
                                        student.setSecondGrade(2);
                                    } else {
                                        thirdGradeSet = true;
                                        poolAset = true;
                                        student.setThirdGrade(2);
                                    }
                                }
                            }
                        }
                    }
                }

                if (!poolB.isEmpty()) {
                    if (!poolBset) {
                        for (Subject subject : poolB) {
                            if (subject.getTitle().equals(secondPrio.get(0).getTitle()) || subject.getTitle().equals(secondPrio.get(1).getTitle()) || subject.getTitle().equals(secondPrio.get(2).getTitle())) {
                                if (!poolBset) {
                                    if (!firstGradeSet) {
                                        firstGradeSet = true;
                                        poolBset = true;
                                        student.setFirstGrade(2);
                                    } else if (!secondGradeSet) {
                                        secondGradeSet = true;
                                        poolBset = true;
                                        student.setSecondGrade(2);
                                    } else {
                                        thirdGradeSet = true;
                                        poolBset = true;
                                        student.setThirdGrade(2);
                                    }
                                }
                            }
                        }
                    }
                }
                if (!poolC.isEmpty()) {
                    if (!poolCset) {
                        for (Subject subject : poolC) {
                            if (subject.getTitle().equals(secondPrio.get(0).getTitle()) || subject.getTitle().equals(secondPrio.get(1).getTitle()) || subject.getTitle().equals(secondPrio.get(2).getTitle())) {
                                if (!poolCset) {
                                    if (!firstGradeSet) {
                                        firstGradeSet = true;
                                        poolCset = true;
                                        student.setFirstGrade(2);
                                    } else if (!secondGradeSet) {
                                        secondGradeSet = true;
                                        poolCset = true;
                                        student.setSecondGrade(2);
                                    } else {
                                        thirdGradeSet = true;
                                        poolCset = true;
                                        student.setThirdGrade(2);
                                    }
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
        List<Student> list111 = new ArrayList();
        List<Student> list112 = new ArrayList();
        List<Student> list122 = new ArrayList();
        List<Student> list222 = new ArrayList();
        List<Student> list110 = new ArrayList();
        List<Student> list120 = new ArrayList();
        List<Student> list220 = new ArrayList();
        List<Student> list100 = new ArrayList();
        List<Student> list200 = new ArrayList();
        List<Student> list000 = new ArrayList();
        List<Student> resultList = new ArrayList();

        for (Student s : slist) {
            if (s.getGrades()[0] == 0 && s.getGrades()[1] == 0 && s.getGrades()[2] == 0) {
                list000.add(s);
            } else if (s.getGrades()[0] == 2 && s.getGrades()[1] == 0 && s.getGrades()[2] == 0) {
                list200.add(s);
            } else if (s.getGrades()[0] == 1 && s.getGrades()[1] == 0 && s.getGrades()[2] == 0) {
                list100.add(s);
            } else if (s.getGrades()[0] == 2 && s.getGrades()[1] == 2 && s.getGrades()[2] == 0) {
                list220.add(s);
            } else if (s.getGrades()[0] == 1 && s.getGrades()[1] == 2 && s.getGrades()[2] == 0) {
                list120.add(s);
            } else if (s.getGrades()[0] == 1 && s.getGrades()[1] == 1 && s.getGrades()[2] == 0) {
                list110.add(s);
            } else if (s.getGrades()[0] == 2 && s.getGrades()[1] == 2 && s.getGrades()[2] == 2) {
                list222.add(s);
            } else if (s.getGrades()[0] == 1 && s.getGrades()[1] == 2 && s.getGrades()[2] == 2) {
                list122.add(s);
            } else if (s.getGrades()[0] == 1 && s.getGrades()[1] == 1 && s.getGrades()[2] == 2) {
                list112.add(s);
            } else if (s.getGrades()[0] == 1 && s.getGrades()[1] == 1 && s.getGrades()[2] == 1) {
                list111.add(s);
            }

        }

        for (Student s : list000) {
            resultList.add(s);
        }

        for (Student s : list200) {
            resultList.add(s);
        }

        for (Student s : list100) {
            resultList.add(s);
        }

        for (Student s : list220) {
            resultList.add(s);
        }

        for (Student s : list120) {
            resultList.add(s);
        }

        for (Student s : list110) {
            resultList.add(s);
        }

        for (Student s : list222) {
            resultList.add(s);
        }

        for (Student s : list122) {
            resultList.add(s);
        }

        for (Student s : list112) {
            resultList.add(s);
        }

        for (Student s : list111) {
            resultList.add(s);
        }

        return resultList;
    }
}
