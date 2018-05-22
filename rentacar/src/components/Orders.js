import React, {Component} from 'react';
import { Table} from 'antd';
import 'antd/dist/antd.css';

export default class Orders extends Component{
    
    constructor(){
        super();
        this.state={
          rentals:[],
          columns : [{
            title: 'Id narudžbe',
            dataIndex: 'id',
            key: 'id',
          }, {
            title: 'ID klijenta',
            dataIndex: 'clientId',
            key: 'clientId',
          }, {
            title: 'Datum rezervacije',
            dataIndex: 'datumRezervacije',
            key: 'datumRezervacije',
          }, {
            title: 'Rezervisano od',
            dataIndex: 'rezervisanoOd',
            key: 'rezervisanoOd',
          }, {
            title: 'Rezervisano do',
            dataIndex: 'rezervisanoDo',
            key: 'rezervisanoDo',
          }]
        };
    
      }

    componentDidMount(){
        fetch('http://185.91.158.33:8081/rest/rentals/all')
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
                  id: rent.id,
                  clientId: rent.clientId,
                  rezervisanoOd: rent.dateFrom.substring(0, 10),
                  rezervisanoDo: rent.dateTo.substring(0, 10),
                  datumRezervacije: rent.dateRented.substring(0, 10),
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