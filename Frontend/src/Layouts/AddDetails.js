import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import UserService from '../Service/UserService'
import Navbar from './Navbar'
// import Sidebar from './Sidebar'

export default function AddDetails() {

  let navigate=useNavigate()

  const [addDetails, setaddDetails] = useState({
    branch: "",
    name: "",
    empId: "",
    designation: "",
    region: "",
    cluster: "",
    branchName: "",
    emailId:"",
    managerId:""
})

const { name, branch, empId,emailId, designation, region, cluster, branchName,managerId } = addDetails

const onInputChange = (e) => {
  setaddDetails({ ...addDetails, [e.target.name]: e.target.value });
};

const onSubmit = async (e) => {
    e.preventDefault();

    let token = sessionStorage.getItem("token")

    UserService.addEmployee(token,addDetails).then((res)=>{
        console.log(res.data);
        alert('Details Added Successfully')
    }).catch((err)=>{
        console.log(err);
    })
    navigate("/maker")
};


  return (
    <div className="conatiner-fluid p-0 m-0">
    <div className="row p-0 m-0">
        <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 p-0 m-0">
            <Navbar />
        </div>
        {/* <div className="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2 p-0 m-0">
            <Sidebar />
        </div> */}
        <div className="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-10 p-0 m-0">
            <div className="col-xl-8 col-lg-8 col-md-8 col-sm-8 col-8 offset-md-3 border rounded p-4 mt-5 shadow" >
                <h5 className="card-title text-center mb-4">Add Employee Details</h5>
                <form onSubmit={(e) => onSubmit(e)}>
                    <div className="row">
                        <div className="col-6 mt-3">
                            <label htmlFor="Farmer Name" className='form-label fw-bold'>Name</label>
                            <input type="text" className='form-control' name='name'
                                value={name} onChange={(e) => onInputChange(e)} required />
                        </div>
                        <div className="col-6 mt-3">
                            <label htmlFor="Milk type" className='form-label fw-bold'>Branch</label>
                            <input type="text" className='form-control' name='branch'
                                value={branch} onChange={(e) => onInputChange(e)} required />
                        </div>

                        <div className="col-6 mt-3">
                            <label htmlFor="Email" className='form-label fw-bold'>EMP ID</label>
                            <input type="text" className='form-control' name='empId'
                                value={empId} onChange={(e) => onInputChange(e)} required />
                        </div>
                        <div className="col-6 mt-3">
                            <label htmlFor="Email" className='form-label fw-bold'>Email ID</label>
                            <input type="text" className='form-control' name='emailId'
                                value={emailId} onChange={(e) => onInputChange(e)} required />
                        </div>
                        <div className="col-6 mt-3">
                            <label htmlFor="Email" className='form-label fw-bold'>Designation</label>
                            <input type="text" className='form-control' name='designation'
                                value={designation} onChange={(e) => onInputChange(e)} required />
                        </div>
                        <div className="col-6 mt-3">
                            <label htmlFor="Email" className='form-label fw-bold'>Region</label>
                            <input type="text" className='form-control' name='region'
                                value={region} onChange={(e) => onInputChange(e)} required />
                        </div>
                        <div className="col-6 mt-3">
                            <label htmlFor="Email" className='form-label fw-bold'>Cluster</label>
                            <input type="text" className='form-control' name='cluster'
                                value={cluster} onChange={(e) => onInputChange(e)} required />
                        </div>
                        <div className="col-6 mt-3">
                            <label htmlFor="Email" className='form-label fw-bold'>Branch Name</label>
                            <input type="text" className='form-control' name='branchName'
                                value={branchName} onChange={(e) => onInputChange(e)} required />

                        </div> <div className="col-6 mt-3">
                            <label htmlFor="Email" className='form-label fw-bold'>Manager ID</label>
                            <input type="text" className='form-control' name='managerId'
                                value={managerId} onChange={(e) => onInputChange(e)} required />
                        </div>

                    </div>
                    <div className="mt- text-end">
                        <button type='submit' className='btn-3 btn-3'>Save</button>
                        <Link to='/maker' className='btn-2 btn-2 cancel'>Cancel</Link>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
  )
}
