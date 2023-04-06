import React, { useEffect, useState } from 'react'
import '../Pages/Dashboard.css'
import Navbar from '../Layouts/Navbar'
import Sidebar from '../Layouts/Sidebar'
import UserService from '../Service/UserService';
import { useNavigate } from 'react-router-dom';

import * as XLSX from 'xlsx';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

export default function Dashboard() {

  let navigate = useNavigate();
 
  const [approvedList, setApprovedList] = useState([]);

  useEffect(( )=>{
    loadApprovedList();
  },[])

  const loadApprovedList = async () => {
    let token = sessionStorage.getItem("token");
 
    if(token!=null){
     UserService.getApprovedList(token).then(
       (res)=>{
        
        setApprovedList(res.data)
        console.log(res.data);
       }
     ).catch((err)=>{
       console.log(err);
     })
    }else{
     navigate("/");
    }
     
 }

//  for PDF PRINT EXCEL

const exportToPDF = () => {  //used for exporting to pdf
  const table = document.getElementById('table1'); // Replace "table1" with your table id abishek
  html2canvas(table).then(canvas => {
    const imgData = canvas.toDataURL('image/png');
    const pdf = new jsPDF();
    pdf.addImage(imgData, 'PNG', 10, 10);
    pdf.save('table1.pdf'); // Update the file name accordingly
  });
}

const Print = () =>{    // used for printing

  //console.log('print');
  
  let printContents = document.getElementById('table1').innerHTML;
  
  let originalContents = document.body.innerHTML;
  
  document.body.innerHTML = printContents;
  
  window.print();
  
  document.body.innerHTML = originalContents;
  
  }

const exportToExcel = () => {  // used for ecporting to excel
  const table = document.getElementById('printtable');
  const worksheet = XLSX.utils.table_to_sheet(table);
  const workbook = XLSX.utils.book_new();
  XLSX.utils.book_append_sheet(workbook, worksheet, 'Sheet1');
  const excelBuffer = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
  const blob = new Blob([excelBuffer], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
  const url = URL.createObjectURL(blob);
  const link = document.createElement('a');
  link.href = url;
  link.setAttribute('download', 'my-table.xlsx');
  document.body.appendChild(link);
  link.click();
  document.body.removeChild(link);
}

 const approvedListObj=approvedList.map((approve ,index)=>{

  return (
   <tr>
    {/* <button className='docclick' name='srNo' value={approve.srNo}   onClick={(e1)=>onChange(e1)}></button> */}
   <td>{approve.srNo}</td>
   <td>{approve.startDate}</td>
   <td>{approve.expiryDate}</td>
   <td> {approve.region}</td>
   <td> {approve.circel}</td>
   <td> {approve.cluster}</td>
   <td> {approve.branch}</td>
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
          <div className="col-xl-9 col-lg-8 col-md-6 col-sm-4 col-4 mt-3">
            <h6 className='heading'>Viwe / Download</h6>
          </div>
          <hr className='hrline1' />

          <div className="col-xl-11 col-lg-11 col-md-11 col-sm-11 col-11  border rounded p-4 mt-3 shadow scrol1" >
          <div className="text-end">
              <button className='btndel btndel-1 ' onClick={Print}>Print</button>
              <button className='btndel btndel-1'onClick={exportToExcel}>Excel</button>
              <button className='btndel btndel-1' onClick={exportToPDF}>PDF</button>
            </div>
           <div id='printtable'>
           <table className="table table-striped table-hover shadow" id='table1'>
              <thead>
                <tr>
                  <th scope="col">Serial No</th>
                  <th scope="col">Start Date </th>
                  <th scope="col">Expriy Date</th>
                  <th scope="col">Region</th>
                  <th scope="col">Circle</th>
                  <th scope="col">Cluster</th>
                  <th scope="col">Branch</th>
                </tr>
              </thead>
              <tbody>
                  {approvedListObj}
              </tbody>
            </table>
           </div>
          </div>
        </div>
      </div>
    </div>
  )
}
