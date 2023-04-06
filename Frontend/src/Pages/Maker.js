import React, { useState } from 'react'
import axios from 'axios';
import Navbar from '../Layouts/Navbar'
import Sidebar from '../Layouts/Sidebar'
import '../Pages/Maker.css'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';



export default function Maker() {

  const [selectedFile, setSelectedFile] = useState(null)
  const [expiryDate, setExpiryDate] = useState('');
  const [startDate, setStartDate] = useState('');
  const [userEmail, setUserEmail] = useState('');
  const [empId, setEmpId] = useState('');
  const [bdrType, setBdrType] = useState('');
  const [description, setDescription] = useState('');

  // const [documentDetails, setDocumentDetails]= useState({
  //   bdrType:"",
  //   description:"",
  //   startDate:"",
  //   expiryDate:"",
  //   note:"",
  //   usermail:"",
  //   employee_emp_id:"",
  // })

  //const {bdrType,description,startDate,expiryDate,note,usermail,employee_emp_id}=documentDetails

  const handleFileInput = (e) => {
    setSelectedFile(e.target.files[0]);
  };

  const handleExpiryDateChange = (e) => {
    setExpiryDate(e.target.value);
  };

  const handleStartDateChange = (e) => {
    setStartDate(e.target.value);
  };

  const handleUserEmailChange = (e) => {
    setUserEmail(e.target.value);
  };

  const handleEmpIdChange = (e) => {
    setEmpId(e.target.value);
  };

  const handleBdrTypeChange = (e) => {
    setBdrType(e.target.value);
  };

  const handleDescriptionChange = (e) => {
    setDescription(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
      // console.log("hjbd",selectedFile);
      // console.log("hjbd",bdrType);

    const formData = new FormData();
    formData.append('file', selectedFile);
    formData.append('expiryDate', expiryDate);
    formData.append('startDate', startDate);
    formData.append('userEmail', userEmail);
    formData.append('empId', empId);
    formData.append('description',description);
    formData.append('bdrType',bdrType);
    
   // console.log("form data ",formData);
    let token=sessionStorage.getItem("token");

    axios.post('http://localhost:8082/api/pdf/upload', formData,  {
      headers: {
        'Content-Type': 'multipart/form-data',
      "Authorization": `Bearer ${token}`
        
      }
    })
      .then((response) => {
        alert(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
      document.getElementById("create-course-form").reset();
  };



  return (
    <div className="conatiner-fluid p-0 m-0">
      <div className="row p-0 m-0">
        <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 p-0 m-0">
          <Navbar />
        </div>
        <div className="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2 p-0 m-0">
          <Sidebar />
        </div>
        <div className="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-10 p-0 m-0">
          <form onSubmit={handleSubmit} id="create-course-form">
            <div className="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-10 border rounded p-4 mt-4 shadow bg-color" >
              <div>
                
                <input type="file" className='uploadinput' name="pdfFile" onChange={handleFileInput}  />
               

              </div>
            </div>
            <div className="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-10  border rounded p-4 mt-3 shadow bg-color" >
              <div className="row">
                <div className="col-6 line">
                  <h5 className='fw-bold label'>Document Details </h5>
                  <div className="detail mt-4">
                    <div className='mt-2'>
                      <label className='fw-bold'>Original docs is with Branch </label>
                      <label class="toggle">
                        <input class="toggle-checkbox" type="checkbox" />
                        <div class="toggle-switch"></div>
                        <span class="toggle-label"></span>
                      </label>
                    </div>
                    <div className='mt-2'>
                      <label className='fw-bold'>BDR Type </label><br />
                      <input className='texts' type="text" name="bdrType" id="" onChange={(e) => handleBdrTypeChange(e)} value={bdrType} />
                    </div>
                    <div className='mt-2'>
                      <label className='fw-bold'>Description</label><br />
                      <textarea name="description" rows="2" cols="50" onChange={(e) => handleDescriptionChange(e)} value={description}></textarea>
                    </div>
                    <div className='mt-4'>
                      <label className='fw-bold'>Start Date</label><br />
                      <input className='texts' type="date" name="startDate" id="" onChange={(e) => handleStartDateChange(e)} value={startDate} />
                    </div>
                    <div className='mt-4'>
                      <label className='fw-bold'>Expiry Date </label><br />
                      <input className='texts' type="date" name="expiryDate" id="" onChange={(e) => handleExpiryDateChange(e)} value={expiryDate} />
                    </div>
                  </div>
                </div>
                <div className="col-6 ">
                  <h5 className='fw-bold label'>Maker Details </h5>
                  <div className="detail mt-4">
                    <div className='mt-2'>
                      <label className='fw-bold'>Date </label><br /><br />

                    </div>
                    <div className='mt-2'>
                      <label className='fw-bold'>Branch </label><br /><br />

                    </div>
                    <div className='mt-2'>
                      <label className='fw-bold'>EMP ID</label><br />
                      <input className='texts' type="text" name="empId" id="" onChange={(e) => handleEmpIdChange(e)} value={empId} />
                    </div>
                    <div className='mt-2'>
                      <label className='fw-bold'>Role</label><br /><br />

                    </div>
                    <div className='mt-2'>
                      <label className='fw-bold'>Email</label><br />
                      <input className='texts' type="text" name="userEmail" id="" onChange={(e) => handleUserEmailChange(e)} value={userEmail} />
                    </div>
                    <hr className='mt-5 hrline' />
                    <div className="text-end mt-3">
                      <button type="submit" className='btn btn-1'>Submit Docs</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>    
          </form>
        </div>
      </div>
      <ToastContainer/>
    </div>
  )
}
