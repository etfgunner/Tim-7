import React, { Component } from 'react';
import './App.css';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import Orders from './components/Orders';
import Contact from './components/Contact';
import Navbar from './components/CustomNavbar';

class App extends Component {
  constructor(){
    super();
    this.state={
      rentals:[],
    };

  }

  componentDidMount(){
    fetch('http://185.91.158.33:8081/rest/rentals/all')
    .then(
      results => {
      console.log('fdsafdsa');
      console.log(results);
      return results.json();
    }
  ).then(data => {
    //console.log(data['0']);
    /*
    data=data['0'];
    console.log(data);
      let rentals=data.results.map((rent) => {
        return (
          <div key={rent.results}>
          <b>fads</b>
          <b>{rent.id}</b>
          </div>
        )
      })
      this.setState({rentals: rentals});
      console.log("state",this.state.rentals)
      return data;
      */
    })
  }
  

  
  
  render() {
    return (
       <Router>
         <div>
           <Navbar />
          <Route exact path="/" component={Home}/>
          <Route path="/about" component={About}/>
          <Route path="/orders" component={Orders}/>
          <Route path="/contact" component={Contact}/>          
        </div>
      </Router>
    )
  }
}

export default App;
