import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import Maker from "./Pages/Maker";
import Checker from "./Pages/Checker";
import Dashboard from "./Pages/Dashboard";
import MisReport from "./Pages/MisReport";
import AddEmployee from "./Layouts/AddEmployee";
import AddManager from "./Layouts/AddManager";
import Login from './Layouts/Login';
import AddDetails from './Layouts/AddDetails';
import AddManagerDetails from './Layouts/AddManagerDetails';


function App() {
  return (
    <div className="">
      <Router>
        <Routes>
          <Route path='/' element={<Login/>}></Route>
           <Route path="/maker" element={<Maker/>}></Route>
           <Route path="/checker" element={<Checker />} ></Route>
           <Route path="/dashboard" element={<Dashboard/>}></Route>
           <Route path="/misReport" element={<MisReport/>}></Route>
           <Route path="/addemployee" element={<AddEmployee />}></Route>
           <Route path="/addmanager" element={<AddManager />}></Route>
           <Route path="/addDetails" element={<AddDetails />}></Route>
           <Route path="/addManagerDetails" element={<AddManagerDetails />}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
