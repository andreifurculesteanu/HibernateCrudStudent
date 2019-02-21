package principal;
 
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import dao.DbOperations;
import pojosGenerados.Student;
 

 
public class AppMain {
 
    public static void main(String[] args) {
        System.out.println(".......Hibernate Crud Operations Example.......\n");
 
        System.out.println("\n=======CREATE RECORDS=======\n");
        Student s = new Student(1, "Smith", new Date(), new BigDecimal(525.75));
        DbOperations.insertarStudent(s);
 /*
        System.out.println("\n=======READ RECORDS=======\n");
        ListviewStudents = DbOperations.displayRecords();
        if(viewStudents != null & viewStudents.size() > 0) {
            for(Student studentObj : viewStudents) {
                logger.info(studentObj.toString());
            }
        }
 
        logger.info("\n=======UPDATE RECORDS=======\n");
        int updateId = 1;
        DbOperations.updateRecord(updateId);
        logger.info("\n=======READ RECORDS AFTER UPDATION=======\n");
        List updateStudent = DbOperations.displayRecords();
        if(updateStudent != null & updateStudent.size() > 0) {
            for(Student studentObj : updateStudent) {
                logger.info(studentObj.toString());
            }
        }
 
        logger.info("\n=======DELETE RECORD=======\n");
        int deleteId = 5;
        DbOperations.deleteRecord(deleteId);
        logger.info("\n=======READ RECORDS AFTER DELETION=======\n");
        List deleteStudentRecord = DbOperations.displayRecords();
        for(Student studentObj : deleteStudentRecord) {
            logger.info(studentObj.toString());
        }
 
        logger.info("\n=======DELETE ALL RECORDS=======\n");
        DbOperations.deleteAllRecords();
        logger.info("\n=======READ RECORDS AFTER ALL RECORDS DELETION=======");
        List deleteAll = DbOperations.displayRecords();
        if(deleteAll.size() == 0) {
            logger.info("\nNo Records Are Present In The Database Table!\n");
        }       
        System.exit(0);
        */
    } 
}