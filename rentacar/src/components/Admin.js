import React, {Component} from 'react';
import { Table} from 'antd';
import 'antd/dist/antd.css';
import VehicleForm from './VehicleForm';
import VehicleViewForm from './VehicleViewForm';
import AddVehicle from './AddVehicle';

export default class Admin extends Component{


	state = {
		fields: {}
	};

	onSubmit = fields => {
		this.setState({fields});
	};

    render(){
        return (

            <div>
                <AddVehicle />
            </div>

           /* <div>
            <VehicleForm onSubmit={fields => this.onSubmit(fields)}/>
            <p> 
            	{JSON.stringify(this.state.fields, null, 2)}
            </p>
            </div>*/

            /*<div>
                <AddVehicle />
                </div>*/

            /*<div>
            	<VehicleViewForm />
            </div>*/

        )
    }
}