import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import AddClient from './components/AddClient';
import ListClients from './components/ListClients';

function App() {
  return (
    <div className="App">
      <Router>
        <div className="container">
          <Routes>
            <Route exact path="/" element={<ListClients/>} />
            <Route path="/clients" element={<ListClients/>}/>
            <Route path="/add-client" element={<AddClient/>} />
            <Route path="/edit-client/:id" element={<AddClient/>}></Route>
          </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;
