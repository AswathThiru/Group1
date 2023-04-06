import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import AxisLogo from '../Assets/AxisBankLogo.png';
import Curve from '../Assets/menucurve.jpg';
import '../Layouts/Navbar.css'
import {FaBell} from 'react-icons/fa'

export default function Navbar() {
  return (
    <div className="container-fluid p-0">
    <div className="row m-0">
        <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 logo">
            <img src={AxisLogo} alt="Logo"  className='imgs'/>
        </div>
        <div className="col-xl-9 col-lg-8 col-md-8 col-sm-8 col-8 curve p-0">
             <img src={Curve} alt="curve"/>
              {/* <FaBell className='bell'/> */}
        </div>
    </div>
  </div>
  )
}
