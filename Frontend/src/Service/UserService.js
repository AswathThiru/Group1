import http from "./HttpCommon";

class UserService{

    userLogin(user){
        return http.post("auth/login",user);
    }
  
    registerEmp(empData){
       return http.post(("auth/register"),empData) 
    }

    addManager(token,addEmployee){
        return http.post(("manager/addManager"),addEmployee, { headers:{"Authorization": `Bearer ${token}` }}) ;
     }
     
     addEmployee(token,employeeData){
        return http.post(("employee/addEmployee"),employeeData,  { headers:{"Authorization": `Bearer ${token}` }}) 
     }

     getPdfDetailsBySrNo(token,srNo){
        return http.get((`manager/getBySrno/${srNo}`), { headers:{"Authorization": `Bearer ${token}` }}) 
     }

     getPdfDetailist(token){
        return http.get((`manager/allPdf`),  { headers:{"Authorization": `Bearer ${token}` }}) 
     }
   
     addApprovalData(token,ApprovalData){
      return http.post(("manager/ApproveFile"),ApprovalData,  { headers:{"Authorization": `Bearer ${token}` }}) 
   }

   getApprovedList(token){
      return http.get((`manager/allApproved`),  { headers:{"Authorization": `Bearer ${token}` }}) 
   }

   deleteFile(token, Id){
      return http.delete((`pdf/delete/${Id}`) , {headers:{"Authorization":`Bearer ${token}`}})
   }
}

export default  new UserService();  	