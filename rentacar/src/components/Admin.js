import React, {Component} from 'react';
import { Table} from 'antd';
import 'antd/dist/antd.css';
import VehicleForm from './VehicleForm';
import VehicleViewForm from './VehicleViewForm';

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
            <VehicleForm onSubmit={fields => this.onSubmit(fields)}/>
            <p> 
            	{JSON.stringify(this.state.fields, null, 2)}
            </p>
            </div>

            /*<div>
            	<VehicleViewForm />
            </div>*/

        )
    }
}