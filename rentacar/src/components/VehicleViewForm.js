import React, {Component} from 'react';
import { Table} from 'antd';
import 'antd/dist/antd.css';

export default class VehicleViewForm extends React.Component{

	constructor(){
        super();
        this.state={
          rentals:[],
          columns : [{
            title: 'Brand',
            dataIndex: 'brand',
            key: 'brand',
          }, {
            title: 'Name', 
            dataIndex: 'name',
            key: 'name',
          }, {
            title: 'Type',
            dataIndex: 'type',
            key: 'type',
          }, {
            title: 'Produced year',
            dataIndex: 'producedYear',
            key: 'producedYear',
          }, {
            title: 'Transimission',
            dataIndex: 'transimission',
            key: 'transimission',
          }]
        };
    
      }

      componentDidMount(){
        //fetch('http://185.91.158.33:8084/vehicle/rest/vehicle/all')
        fetch('http://localhost:8080/rest/vehicle/all') 
        .then(
          results => {
          console.log(results);
          //return results.json();  
          return results.json();  }
      ).then(data => {
        console.log(data);
          let rentals=data.map((rent) => {

            return (
              {
                  brand: rent.brand,
                  name: rent.name,
                  type: rent.type,
                  producedYear: rent.producedYear,
                  transimission: rent.transimission,
              }
            )
          })
        
          this.setState({rentals: rentals});
          console.log("state",this.state.rentals)
          return data;
          
          
        })
      }

	render(){
        return (
            <div>
            <Table dataSource={this.state.rentals} columns={this.state.columns} />
            </div>
        )
    }

	

}