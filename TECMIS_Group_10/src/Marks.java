
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mithila
 */
public class Marks {
    Connection con=MyConnection.getConnection();
    private String reg_no=null;
    private String subjet_code=null;
    private String quiz_no=null;
    private String assessment_no=null;
    private String type=null;
    private String marks=null;

    
    public String getReg_no() {
        return reg_no;
    }

    
    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    
    public String getSubjet_code() {
        return subjet_code;
    }

    
    public void setSubjet_code(String subjet_code) {
        this.subjet_code = subjet_code;
    }

    
    public String getQuiz_no() {
        return quiz_no;
    }

    
    public void setQuiz_no(String quiz_no) {
        this.quiz_no = quiz_no;
    }

    
    public String getAssessment_no() {
        return assessment_no;
    }

   
    public void setAssessment_no(String assessment_no) {
        this.assessment_no = assessment_no;
    }

    
    public String getType() {
        return type;
    }

    
    public void setType(String type) {
        this.type = type;
    }

    
    public String getMarks() {
        return marks;
    }

   
    public void setMarks(String marks) {
        this.marks = marks;
    }
    
    void addQuizMarks()
    {
        try {
            Connection con=MyConnection.getConnection();
            String sql="INSERT INTO quiz VALUES('"+getReg_no()+"','"+getSubjet_code()+"','"+getQuiz_no()+"','"+getMarks()+"')";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data added Successfully!..");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    void addAssessmentMarks()
    {
        try {
             Connection con=MyConnection.getConnection();
             String sql="INSERT INTO assessment VALUES('"+getReg_no()+"','"+getSubjet_code()+"','"+getAssessment_no()+"','"+getMarks()+"')";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.execute();
             JOptionPane.showMessageDialog(null, "Data added Successfully!..");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    } 
    
    void addMidMarks()
    {
        try {
            Connection con=MyConnection.getConnection();
             String sql="INSERT INTO mid VALUES('"+getReg_no()+"','"+getSubjet_code()+"','"+getMarks()+"')";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.execute();
             JOptionPane.showMessageDialog(null, "Data added Successfully!..");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void addFinalMarks()
    {
        try {
             Connection con=MyConnection.getConnection();
             String sql="INSERT INTO final VALUES('"+getReg_no()+"','"+getSubjet_code()+"','"+getType()+"','"+getMarks()+"')";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.execute();
             JOptionPane.showMessageDialog(null, "Data added Successfully!..");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     String addGrade(String reg_no,String sub_code)
    {
             
        double quiz=0,assessment=0,mid=0,final_m=0,total=0;
        
        quiz=getQuizMarks(reg_no,sub_code);
        assessment=getAssessmentMarks(reg_no,sub_code);
        mid=getMidMarks(reg_no,sub_code);
        final_m=getFinalMarks(reg_no,sub_code);
        
        total=quiz+assessment+mid+final_m;
        System.out.println(total);
        
        return getGrade(total);
    }
     
     double getQuizMarks(String reg_no,String sub_code)
     {
         
         double quiz = 0;
         int q[]=new int[3],i=0;
         
         try {
            
            String sql="SELECT *FROM quiz WHERE reg_no='"+reg_no+"' and subject_code='"+sub_code+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet qrs=ps.executeQuery();
           if(qrs.next())
           {
                while(qrs.next())
                {
                    q[i]=Integer.parseInt(qrs.getString("marks"));
                    i++;
                }
              
                if(q[0]<q[1] &&q[0]<q[2])
                {
                    quiz=(double)(q[1]+q[2])/20*100/10;
                    return quiz;
                }
                if(q[1]<q[0] && q[1]<q[2])
                {
                     quiz=(double)(q[0]+q[2])/20*100/10;
                    return quiz;
                }
                if(q[2]<q[0] && q[2]<q[1])
                {
                     quiz=(double)(q[0]+q[1])/20*100/10;
                    return quiz;
                } 
           }        
         }
         catch (Exception e) {
             //System.out.println(e);
         }
        
        
         return quiz;
     }
     
     double getAssessmentMarks(String reg_no,String sub_code)
     {
         double ass=0;
         int i=0,a[]=new int[3];
         try {
            i=0;
            String sql="SELECT *FROM assessment WHERE reg_no='"+reg_no+"' AND subject_code='"+sub_code+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet ars=ps.executeQuery();
            if(ars.next())
            {
                 while(ars.next())
                 {
                    a[i]=Integer.parseInt(ars.getString("marks"));
                    i++;
                 }
                 if(a[0]<a[1] &&a[0]<a[2])
                 {
                    ass=(double)(a[1]+a[2])/20*100/10*2;
                    return ass;
                 }
                if(a[1]<a[0] && a[1]<a[2])
                {
                    ass=(double)(a[0]+a[2])/20*100/10*2;
                    return ass;
                }
                if(a[2]<a[0] && a[2]<a[1])
                {
                    ass=(double)(a[0]+a[1])/20*100/10*2;
                    return ass;
                }
            }    
            
        } catch (Exception e) {
             System.out.println(e);
        }
         
        
         return ass;
     } 
     
     double getMidMarks(String reg_no,String sub_code)
     {
         double mid=0;
         int m=0;
         try {
            String sql="SELECT *FROM mid WHERE reg_no='"+reg_no+"' AND subject_code='"+sub_code+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet mrs=ps.executeQuery();
            if(mrs.next()){
                m=Integer.parseInt(mrs.getString("marks"));
                mid=(float)m/100*20;
                 return mid;
            }     
           
        } catch (Exception e) {
             //System.out.println(e);
        }
         
         
         return mid;
     }
     double getFinalMarks(String reg_no,String sub_code)
     {
         Attendance att=new Attendance();
         double finalm=0,f1=1,f2=1;
         int f[]=new int[2];
         int i=0;
         try {
             String sql="SELECT *FROM final WHERE reg_no='"+reg_no+"' AND subject_code='"+sub_code+"'";
              PreparedStatement ps=con.prepareStatement(sql);
              ResultSet frs=ps.executeQuery();
              
                  while(frs.next())
                  {
                      f[i]=Integer.parseInt(frs.getString("marks"));
                      i++;
                  }
                  f1=(double)f[0]/100*40;
                  f2=(double)f[1]/100*30;
                  finalm=f1+f2;
                  if(att.getCAEligibility(reg_no, sub_code).equals("Not Eligible"))
                      return 0;
                  else
                      return finalm;
                  
        } catch (Exception e) {
             //System.out.println(e);
        }
         
         
         return finalm;
     } 
     
     String getGrade(double mark)
     {
         if(mark<100 && mark>=85)
             return "A+";
         else if(mark<85 && mark>=75)
             return "A";
         else if(mark<75 && mark>=70)
             return "A-";
         else if(mark<70 && mark>=65)
             return "B+";
         else if(mark<65 && mark>=60)
             return "B";
         else if(mark<60 && mark>=55)
             return "B-";
         else if(mark<55 && mark>=50)
             return "C+";
         else if(mark<50 && mark>=45)
             return "C";
         else if(mark<45 && mark>=40)
             return "C-";
         else
             return "F";
     }
     
     String addGradeDif(String reg_no,String sub_code)
     {
          double quiz=0,assessment=0,mid=0,final_m=0,total=0;
          
          quiz=getQuiz2(reg_no,sub_code);
          assessment=getAssessment2(reg_no,sub_code);
          mid=getMidMarks(reg_no,sub_code);
          final_m=getFinal2(reg_no,sub_code);
          total=quiz+assessment+mid+final_m;
          //System.out.println(mid);
          return getGrade(total);
          
     }
     
     double getQuiz2(String reg_no,String sub_code)
     {
         double quiz=0;
         int q[]=new int[4],i=0;
         
         try {
             String sql="SELECT *FROM quiz WHERE reg_no='"+reg_no+"' AND subject_code='"+sub_code+"'";
             PreparedStatement ps=con.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             while(rs.next())
             {
                 q[i]=Integer.parseInt(rs.getString("marks"));
                 i++;
             }
             if(q[1]<q[0] &&q[1]<q[2] && q[1]<q[2])
             {
                 quiz=(double)(q[0]+q[2]+q[3])/30*100/10;
                 return quiz;
             }
             if(q[2]<q[0] &&q[2]<q[1] && q[2]<q[3])
             {
                 quiz=(double)(q[0]+q[1]+q[3])/30*100/10;
                 return quiz;
             }
             if(q[0]<q[1] &&q[0]<q[2] && q[0]<q[3])
             {
                 quiz=(double)(q[1]+q[2]+q[3])/30*100/10;
                 return quiz;
             } 
             if(q[3]<q[0] &&q[3]<q[2] && q[3]<q[1])
             {
                 quiz=(double)(q[0]+q[2]+q[1])/30*100/10;
                 return quiz;
             } 
         } catch (Exception e) {
         }
         return quiz;
         
     }
     
     double getAssessment2(String reg_no,String sub_code)
     {
         double ass=0;
         int a[]=new int[2],i=0;
         try {
             String sql="SELECT *FROM assessment WHERE reg_no='"+reg_no+"' AND subject_code='"+sub_code+"'";
             PreparedStatement ps=con.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             while(rs.next())
             {
                 a[i]=Integer.parseInt(rs.getString("marks"));
                 i++;
             }
             ass=(double)(a[0]+a[1])/20*100/10;
             return ass;
         } catch (Exception e) {
         }
         return ass;
     }
     
     double getFinal2(String reg_no,String sub_code)
     {
         Attendance att=new Attendance();
         double f_marks=0;
         int m=0;
         try {
             String sql="SELECT *FROM final WHERE reg_no='"+reg_no+"' AND subject_code='"+sub_code+"'";
             PreparedStatement ps=con.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             if(rs.next())
             {
                 m=Integer.parseInt(rs.getString("marks"));
                 
             }
             f_marks=(double)m/100*60;
             if(att.getCAEligibility2(reg_no, sub_code).equals("Not Eligible"))
             {
                 return 0;
             }
             else
             {
                  return f_marks;
             }
            
             
         } catch (Exception e) {
         }
         return f_marks;
     }
     
     String addGradeDif2(String reg_no,String sub_code)
     {
          double quiz=0,assessment=0,mid=0,final_m=0,total=0;
          
          quiz=getQuizMarks(reg_no,sub_code);
          assessment=getAssessmentMarks(reg_no,sub_code);
          mid=getMidMarks(reg_no,sub_code);
          final_m=getFinal3(reg_no,sub_code);
          total=quiz+assessment+mid+final_m;
          //System.out.println(mid);
          return getGrade(total);
          
     }
     
     double getFinal3(String reg_no,String sub_code)
     {
         double f_marks=0,f1=0,f2=0;
         int f[]=new int[2],i=0;
         try {
             String sql="SELECT *from final WHERE reg_no='"+reg_no+"' AND subject_code='"+sub_code+"'";
             PreparedStatement ps=con.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             while(rs.next())
             {
                 f[i]=Integer.parseInt(rs.getString("marks"));
                 i++;
             }
             f1=(double)f[0]/100*30;
             f2=(double)f[1]/100*40;
             f_marks=f1+f2;
             return f_marks;
         } catch (Exception e) {
         }
         return f_marks;
     } 
     
     void addGPA(String reg)
     {
         float sgpa=addSGPA(reg);
         float cgpa=addCGPA(reg);
         System.out.println(sgpa);
         System.out.println(cgpa);
         try {
             String sql="INSERT INTO gpa VALUES('"+reg+"','"+sgpa+"','"+cgpa+"')";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.execute();
         } catch (Exception e) {
         }
     }
     
     float addSGPA(String reg)
     {
         float value[]=new float[6];
         int val[]=new int[6];
         int i=0,sum2=0;
         float sum=0,sgpa=0;
         
         try {
            String sql="SELECT *FROM grade WHERE reg_no='"+reg+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                val[i]=getSubjectCovertToValue(rs.getString("subject_code"));
                value[i]=getGradeConvertToValue(rs.getString("grade"));
                i++;
            }
             for (int j = 0; j < val.length; j++) {
                 sum+=val[j]*value[j];
                 sum2+=val[j];
             }
             sgpa=(float)sum/sum2;
             return sgpa;
           
         } catch (Exception e) {
             System.out.println(e);
         }
         return sgpa;
     }
     
     float getGradeConvertToValue(String grade)
     {
         float value=0;
         if(grade.equals("A+"))
             return (float) 4.0;
         if(grade.equals("A"))
             return (float) 4.0;
         if(grade.equals("B+"))
             return (float) 3.7;
         if(grade.equals("B"))
             return (float) 3.5;
         if(grade.equals("B-"))
             return (float) 3.0;
         if(grade.equals("C+"))
             return (float) 2.5;
         if(grade.equals("C"))
             return (float) 2.0;
         if(grade.equals("C-"))
             return (float) 1.7;
         else
             value=0;
         return value;
     } 
     
     int getSubjectCovertToValue(String sub_code)
     {
         //in here char array size is 7
         int sub=0;
         char m[]=sub_code.toCharArray();
         sub=Character.getNumericValue(m[6]);
         return sub;
     }
     
     float addCGPA(String reg)
     {
         float value[]=new float[6];
         int val[]=new int[6];
         int i=0,sum2=0;
         float sum=0;
         float cgpa=0;
         
         try {
            String sql="SELECT *FROM grade WHERE reg_no='"+reg+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                val[i]=getSubjectCovertToValue(rs.getString("subject_code"));
                value[i]=getGradeConvertToValue(rs.getString("grade"));
                i++;
            }
             for (int j = 0; j < val.length-1; j++) {
                 sum+=val[j]*value[j];
                 sum2+=val[j];
             }
             cgpa=(float)sum/sum2;
             return cgpa;
           
         } catch (Exception e) {
             System.out.println(e);
         }
         return cgpa;
     } 
     
     String getSGPA(String reg)
     {
         Connection con=MyConnection.getConnection();
         try {
             String sql="Select sgpa from gpa WHERE reg_no='"+reg+"'";
             PreparedStatement ps=con.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             if(rs.next())
                 return rs.getString("sgpa");
         } catch (Exception e) {
         }
         return "0";
     } 
     String getCGPA(String reg)
     {
         Connection con=MyConnection.getConnection();
         try {
             String sql="Select cgpa from gpa WHERE reg_no='"+reg+"'";
             PreparedStatement ps=con.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             if(rs.next())
                 return rs.getString("cgpa");
         } catch (Exception e) {
         }
         return "0";
     } 
}
