import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  constructor(){
    super();
    this.state={
      rentals:[],
    };

  }

  componentDidMount(){
    fetch('http://bst119.bstelecom.ba:8081/rest/rentals/all')
    .then(
      results => {
      console.log('fdsafdsa');
      var jes=results.json();
      console.log(jes);
      return jes;
    }
  ).then(data => {
      let rentals=data.results.map((rent) => {
        return (
          <div key={rent.results}>
          <b>{rent.id}</b>
          </div>
        )
      })
      this.setState({rentals: rentals});
      console.log("state",this.state.rentals)
    })
  }
  

  
  
  render() {
    return (
      <div className="container2">
      <div className="container1">
      {this.state.rentals}
      </div>
      </div>
    )
  }
}

export default App;
