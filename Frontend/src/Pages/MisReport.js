import React from 'react'
import Navbar from '../Layouts/Navbar'
import Sidebar from '../Layouts/Sidebar'

export default function MisReport() {
  return (
    <div className="conatiner-fluid p-0 m-0">
      <div className="row p-0 m-0">
        <div className="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 p-0 m-0">
            <Navbar/>
        </div>
        <div className="col-xl-2 col-lg-2 col-md-2 col-sm-2 col-2 p-0 m-0">
            <Sidebar/>
        </div>
        <div className="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-10 p-0 m-0">

        </div>
      </div>
    </div>
  )
}
