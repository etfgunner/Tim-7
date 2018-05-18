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
    fetch('http://185.91.158.33:8081/rest/rentals/all')
    .then(
      results => {
      console.log('fdsafdsa');
      console.log(results);
      return results.json();
    }
  ).then(data => {
    //console.log(data['0']);
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
