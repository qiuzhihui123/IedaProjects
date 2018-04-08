package com.qiuhui.service;

import com.qiuhui.dao.StudentDao;

public class StudentService {
    
    private StudentDao studentDao;
    
    
    
    public void save(){
        studentDao.save();
        
    }
    
    private void setStudentDao(StudentDao studentDao){
        
        this.studentDao = studentDao;
    }
    
    
}
