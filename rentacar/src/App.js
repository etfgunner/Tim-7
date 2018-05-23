import React, { Component } from 'react';
import './App.css';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import Orders from './components/Orders';
import Contact from './components/Contact';
import Navbar from './components/CustomNavbar';
import Admin from './components/Admin';
import LoginForm from './components/LoginForm';
import Register from './components/Register';

class App extends Component {


  
  
  render() {
    return (
      <div>
       <Router>
         <div>
           <Navbar />
          <Route exact path="/" component={Home}/>
          <Route path="/about" component={About}/>
          <Route path="/orders" component={Orders}/>
          <Route path="/contact" component={Contact}/> 
          <Route path="/admin" component={Admin}/>  
          <Route path="/login" component={LoginForm}/>  
          <Route path="/register" component={Register}/>
        </div>
      </Router>
      </div>
    )
  }
}

export default App;
