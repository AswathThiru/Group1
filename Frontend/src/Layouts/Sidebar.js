import {AnimatePresence, motion} from 'framer-motion'
import '../Layouts/Sidebar.css'
import {FaDownload, FaUpload, FaReceipt, FaFile, FaFolderOpen} from 'react-icons/fa'
import { NavLink } from 'react-router-dom'
import { useState } from 'react'
import Logo from '../Assets/logo.png'

const routes = [
    {
        path:"/maker",
        name:"Maker-Upload",
        icon: <FaUpload/>
    },
    {
        path:"/checker",
        name:"Checker-Review",
        icon: <FaFile/>
    },
    {
        path:"/dashboard",
        name:"Viwe | Download",
        icon: <FaDownload/>
    },
    {
        path:"/misReport",
        name:"MIS Report",
        icon: <FaReceipt/>
    },
 ]

export default function Sidebar() {
    
    const [isOpen,setIsOpen] = useState(false)

    const toggle = () => setIsOpen(!isOpen);

    return (
        <div className='main-container m-0'>
            <motion.div animate={{width: isOpen ? "230px": "45px"}} className="sidebar">

                <div className="top_section">
                    {isOpen && <h4>E-Register ... <br /> <span className='br'>Branch Document Register</span></h4> }
                    <div className="bars">
                        {/* <FaBars className='icons' onClick={toggle}/> */}
                        <img src={Logo} alt="logo" onClick={toggle} className='alogo'/>
                    </div>
                </div>

                <section className='routes'>
                    {routes.map((route) => (
                       <NavLink  to={route.path} key={route.name} className='link'>
                        <div className="icon"> {route.icon} </div>
                        <AnimatePresence>
                            {isOpen && < motion.div className="link_text">{route.name}</motion.div>}
                        </AnimatePresence>
                       </NavLink> 
                    ))}
                    {isOpen && <FaFolderOpen className='folder' />}
                    {/* {isOpen && <img src={Folder} alt="" className="folder" />} */}

                </section>
             
            </motion.div>
        </div>
        
    )
}
