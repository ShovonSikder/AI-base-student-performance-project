
package studentperformancepredictor;

import java.util.Scanner;

class Student{
    //declared all requires attribute
    int studytime,failures,G1,G2;
    boolean schoolsup,paid,acttivities,internet;
    char G3;
    
    //constructor to assign values
    Student(int studytime,int failures,boolean schoolsup,boolean paid,boolean activities,boolean internet,int G1,int G2){
        this.studytime=studytime;
        this.failures=failures;
        this.schoolsup=schoolsup;
        this.paid=paid;
        this.acttivities=activities;
        this.internet=internet;
        this.G1=G1;
        this.G2=G2;       
    }
    //the model
    void predictFinalGrade(){
        if(G2<=11){
            if(G2<=8){
                if(G1<=8){
                    G3='F';
                }
                else{
                    if(schoolsup){
                        G3='D';
                    }
                    else{
                       if(failures<=1){
                           G3='F';
                       }
                       else{
                           G3='D';
                       }
                    }
                }
            }
            else{
                if(G2<=10){
                    if(G1<=9){
                        if(!paid){
                            if(G2<=9){
                                if(schoolsup){
                                    G3='F';
                                }
                                else{
                                    if(!acttivities){
                                        G3='D';
                                    }
                                    else{
                                        if(studytime<=1){
                                            if(failures<=2){
                                                G3='D';
                                            }
                                            else{
                                                G3='F';
                                            }
                                        }
                                        else{
                                            if(failures<=1){
                                                G3='F';
                                            }
                                            else{
                                                G3='D';
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                G3='D';
                            }
                        }
                        else{
                            G3='F';
                        }
                    }
                    else{
                        G3='D';
                    }
                }
                else{
                    if(!paid){
                        G3='D';
                    }
                    else{
                        if(G1<=10){
                            G3='D';
                        }
                        else{
                            G3='C';
                        }
                    }
                }
            }
        }
        else{
            if(G2<=13){
                if(schoolsup){
                    G3='C';
                }
                else{
                    if(G2<=12){
                        G3='C';
                    }
                    else{
                        if(G1<=10){
                            G3='C';
                        }
                        else{
                            if(!internet){
                                if(studytime<=2){
                                    G3='C';
                                }
                                else{
                                    G3='B';
                                }
                            }
                            else{
                                if(!acttivities){
                                    G3='B';
                                }
                                else{
                                    if(studytime<=1){
                                        G3='C';
                                    }
                                    else{
                                        if(studytime<=2){
                                            G3='B';
                                        }
                                        else{
                                            G3='C';
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else{
                if(G2<=15){
                    G3='B';
                }
                else{
                    G3='A';
                }
            }
        }
    }
    
    
}

public class StudentPerformancePredictor {

    
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        
         int studytime,failures,G1,G2;
         boolean schoolsup,paid,acttivities,internet;
         
         System.out.print("Weekly study time (numeric: 1 - <2 hours, 2 - 2 to 5 hours, 3 - 5 to 10 hours, or 4 - >10 hours): ");
         studytime=scan.nextInt();
         
         System.out.print("Number of past class failures: ");
         failures=scan.nextInt();
         
         System.out.print("Extra educational support?y/n: ");
         schoolsup= (scan.next().charAt(0)=='y');
         
         System.out.print("Extra paid classes within the course subject (Math or Portuguese)?y/n: ");
         paid= (scan.next().charAt(0)=='y');
         
         System.out.print("Extra-curricular activities?y/n: ");
         acttivities= (scan.next().charAt(0)=='y');
         
         System.out.print("Internet access at home?y/n: ");
         internet= (scan.next().charAt(0)=='y');
         
         System.out.print("First period grade (numeric: from 0 to 20): ");
         G1=scan.nextInt();
         
         System.out.print("Second period grade (numeric: from 0 to 20): ");
         G2=scan.nextInt();
         
        Student s=new Student(studytime, failures, schoolsup, paid, acttivities, internet, G1, G2);
        s.predictFinalGrade();
        System.out.println("\nPredicted final grade: "+s.G3);
    }
    
}
