import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link, Navigate, useNavigate } from 'react-router-dom'
import Navbar from '../Layouts/Navbar'
import Sidebar from '../Layouts/Sidebar'
import UserService from '../Service/UserService'

export default function Checker() {
let navigate = useNavigate();
  
  const [pdfList, setPdfList] = useState([]);
  const [pdfDetails, setpdfDetails] = useState([]);
  const [srNoData, setSrNoData] = useState({
    srNo:"",
    bdrType:"",
    description:"",
    startDate:"",
    expiryDate:"",
  });

  const [approvaldata, setapprovaldata] = useState({
    region:"",
    circel:"",
    cluster:"",
    branch:""
  });

 


  const [isOpen, setIsOpen] = useState(false)
  const viewDoc = () => setIsOpen(!isOpen);
  const [isChecked, setIsChecked] = useState(false);

  const handleCheckboxChange = (event) => {
    setIsChecked(event.target.checked);
  };

// const{srNo}=srNoData

  // const onSrNoChange = (e) => {
  //   setSrNoData({ ...srNoData, [e.target.name]: e.target.value });
   
    
  // };

  function onChange(e1) {
   
    let srNo=e1.target.value;

   // setSrNoData(srNo)
    console.log("srno++++",srNo);
    
     const formData =new FormData();

     formData.append('srNo',srNo)
   
    let token = sessionStorage.getItem("token");

    axios.post('http://localhost:8082/api/manager/getBySrno', formData,  {
      headers: {
        'Content-Type': 'multipart/form-data',
      "Authorization": `Bearer ${token}`
        
      }
    })
      .then((response) => {
        setSrNoData(response.data)
        setapprovaldata(response.data.employee)
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
      viewDoc()

}
  
  useEffect(( )=>{
    loadPdfList();
  },[])

  const loadPdfList = async () => {
   let token = sessionStorage.getItem("token");

   if(token!=null){
    UserService.getPdfDetailist(token).then(
      (res)=>{
       
        setPdfList(res.data)
      }
    ).catch((err)=>{
      console.log(err);
    })
   }else{
    navigate("/");
   }
    
}

function deleteFile(Id){
  let token = sessionStorage.getItem("token",);
  UserService.deleteFile(token, Id)
}

//console.log("log",pdfList);

// get doc details by id

const loadDocDetails = async () => {
  let token = sessionStorage.getItem("token");

  if(token!=null){
   UserService.getPdfDetailsBySrNo(token ,srNoData).then(
     (res)=>{
      setpdfDetails(res.data)
     }
   ).catch((err)=>{
     console.log(err);
   })
  }else{
   navigate("/");
  }

  //on approvaa data
 
}

const approvaldataset={
  srNo:srNoData.srNo,
  bdrType: srNoData.bdrType,
  startDate:srNoData.startDate ,
  expiryDate:srNoData.expiryDate,
  region:approvaldata.region,
  circel:approvaldata.region,
  cluster:approvaldata.cluster,
  branch:approvaldata.branch
}

function OnApprovalClick(){
  let token = sessionStorage.getItem("token");
  console.log("hrllo",approvaldataset);
  UserService.addApprovalData(token,approvaldataset).then((res)=>{
    console.log(res.data);
    alert('Document Approved Successfully')
  }).catch((err)=>{
    console.log(err);
})
}


   const pdfListObj=pdfList.map((pdf ,index)=>{

   return (
    <tr>
    <td><button className='docclick' name='srNo' value={pdf.srNo}   onClick={(e1)=>onChange(e1)}>{pdf.srNo}</button></td>
    <td> {pdf.uploadedDate}</td>
    <td>{pdf.startDate}</td>
    <td>{pdf.expiryDate}</td>
  </tr>
   )

   })
  

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
          <div className='text-end mt-3'>
          <Link className='btndel btndel-1' to="/addemployee">Add Employee</Link>
          </div>
          <div className="col-xl-11 col-lg-11 col-md-11 col-sm-11 col-11  border rounded p-4 mt-3 shadow scrol" >
            <table className="table table-striped table-hover shadow">
              <thead>
                <tr>
                  <th scope="col">Serial No</th>
                  <th scope="col">Maker Uploaded Date</th>
                  <th scope="col">Start Date </th>
                  <th scope="col">Expiry Date</th>

                </tr>
              </thead>
              <tbody>
               {pdfListObj}
                
              </tbody>
            </table>
          </div>
          {isOpen && <div className="col-xl-11 col-lg-11 col-md-11 col-sm-11 col-11  border rounded p-4 mt-2 shadow scroll" >
            <div className="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6 offset-md-3  border rounded p-4  shadow" >
              <h5 className='label fw-bold text-center'>Document Details</h5>
              <div className='mt-3'>
                <label className='fw-bold'>Original docs is with Branch : <span className='text'>Yes</span></label>

              </div>
              <div className='mt-3'>
                <label className='fw-bold'>Serial no :<span className='text'>{srNoData.srNo}</span> </label><br />

              </div>
              <div className='mt-3'>
                <label className='fw-bold'>BDR Type :<span className='text'>{srNoData.bdrType}</span> </label><br />

              </div>
              <div className='mt-3'>
                <label className='fw-bold'>Description : <span className='text'>{srNoData.description}</span></label><br />

              </div>
              <div className='mt-3'>
                <label className='fw-bold'>Start Date :<span className='text'>{srNoData.startDate}</span> </label><br />
              </div>
              <div className='mt-3'>
                <label className='fw-bold'>Expiry Date :<span className='text'>{srNoData.expiryDate}</span> </label><br />
              </div>
             
            </div>
            <hr className='hrline'/>
            <div>
              <input type="checkbox" checked={isChecked} onChange={handleCheckboxChange}/>
              <span className='ms-3'>I hereby canfirm that the above-mentioned information and doc-uploaded are verified bt me and the machine generated serial no. is mentioned on the doc hard copy.</span>
            </div>

            <div className="text-center mt-2">
              <button className='btndel btndel-1 ' onClick={deleteFile}>Delete Record</button>
              <button className='btndel btndel-1' onClick={OnApprovalClick} disabled={!isChecked}>Approve</button>
            </div>
          </div>}
        </div>
      </div>
    </div>
  )
}
