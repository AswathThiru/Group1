import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import '../Layouts/Login.css'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import UserService from '../Service/UserService';


export default function Login() {

    let navigate= useNavigate();

    const [loginDetails, setLoginDetails] = useState({
      username:"",
      password:"",
      role:""
    })

    const {username, password, role} = loginDetails

    const onInputChange = (e) => {
      setLoginDetails({ ...loginDetails, [e.target.name]: e.target.value });
  };

  const onSubmit = (e) =>{
    var Manager;
    e.preventDefault();
    
    // toast("this is message");
    console.log(loginDetails);
    UserService.userLogin(loginDetails).then(
      (res)=>{
        sessionStorage.setItem("token",res.data.token)
        console.log(res.data);
        
        if(res.data.role=="admin"){
          navigate("/dashboard")
        }
        if(res.data.role=="manager"){
          navigate("/addManagerDetails")
        }
        if(res.data.role=="employee"){
          navigate("/addDetails")
        }
        

        alert("logged successfully");
      }

    ).catch(
      (err)=>{
        alert("Invalid cradintials")
        console.log(err);
      }
    )
    // navigate("/addDetails")
  }
 
  return (
    <div className='container-fluid bgimage'>
      <div className="row">
        <div className="card login">
          <div className="card-body">
            <form onSubmit={(e) => onSubmit(e) }>
              <label htmlFor="UserName" className='fw-bold mt-3 labels'>Username </label><br />
              {/* <FontAwesomeIcon icon={faUser}></FontAwesomeIcon> */}
              <input type="text" className='input my-2' placeholder='Enter your username' minLength='2' maxLength='15'
              onChange={(e) => onInputChange(e)} name="username" value={username} required /><br />
              <label htmlFor="Password" className='fw-bold mt-3 labels'>Password </label><br />
              {/* <FontAwesomeIcon icon={faLock}></FontAwesomeIcon> */}
              <input type="password" className='input my-2' placeholder='Enter your password' minLength='2' maxLength='15'
              onChange={(e) => onInputChange(e)} name="password" value={password} required/><br />
              <div className="text-center">
                <button className='btn btn-1'>Login</button>
              </div>
            </form>
          </div>
        </div>
      </div>
      <ToastContainer/>
    </div>
  )
}
