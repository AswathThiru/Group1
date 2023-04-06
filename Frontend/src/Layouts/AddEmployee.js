import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import UserService from '../Service/UserService'
import Navbar from './Navbar'
import Sidebar from './Sidebar'

export default function AddEmployee() {
    
  let navigate=useNavigate()

  const [employee, setEmployee] = useState({
    
    name: "",
    username: "",
    password:"",
    role: ""
})

const { name,username,password,role } = employee

const onInputChange = (e) => {
  setEmployee({ ...employee, [e.target.name]: e.target.value });
};

const onSubmit = async (e) => {
    e.preventDefault();

    UserService.registerEmp(employee).then((res)=>{
        console.log(res.data);
        alert('Employee  Registered Successfully')
    }).catch((err)=>{
        console.log(err);
    })
    navigate("/checker")
    
   // console.log(employee);
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
                    <div className="col-xl-5 col-lg-5 col-md-5 col-sm-5 col-5 offset-md-3 border rounded p-4 mt-5 shadow" >
                        <h5 className="card-title text-center mb-4">Register Employee</h5>
                        <form onSubmit={(e) => onSubmit(e)}>

                        <div className=" mt-3">
                                    <label htmlFor="Farmer Name" className='form-label fw-bold'>Name</label>
                                    <input type="text" className='form-control' name='name'
                                        value={name} onChange={(e) => onInputChange(e)} required />
                                </div>

                                <div className=" mt-3">
                                    <label htmlFor="Farmer Name" className='form-label fw-bold'>Username</label>
                                    <input type="text" className='form-control' name='username'
                                        value={username} onChange={(e) => onInputChange(e)} required />
                                </div>
                                <div className=" mt-3">
                                    <label htmlFor="Milk type" className='form-label fw-bold'>Password</label>
                                    <input type="text" className='form-control' name='password'
                                        value={password} onChange={(e) => onInputChange(e)} required />
                                </div>

                                <div className=" mt-3">
                                    <label htmlFor="Email" className='form-label fw-bold'>Role</label>
                                    <input type="text" className='form-control' name='role'
                                        value={role} onChange={(e) => onInputChange(e)} required />
                                </div>
                            
                            <div className="mt-3 text-end">
                                <button type='submit' className='btndel btndel-1'>Submit</button>
                                <Link to='/checker' className='btndel btndel-1'>Cancel</Link>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
  )
}
