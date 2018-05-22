import React from 'react';
import '../style/LoginForm.css';

export default class LoginForm extends React.Component{

	state = {
		username: '',
		password: ''
	};

	change = e => {
		this.setState({
			[e.target.name]: e.target.value
		});
	};

	onSubmit = (e) => {
		e.preventDefault();
		this.props.onSubmit(this.state);
		this.setState({
			username: '',
			password: ''
		})
	};

	render(){

		return (

			<form>
				<div>
					<h3> Login form </h3>
					<input 
						name = "username"
						placeholder = "Username" 
						type = "text"
						value = {this.state.username} 
						onChange={e => this.change(e)}
					/>
					<br />
					<input 
						name = "password"
						placeholder = "Password"
						type = "password" 
						value = {this.state.password} 
						onChange={e => this.change(e)}
					/>
					<br />
					<button onClick={e => this.onSubmit(e)}>Submit</button>
				</div>
			</form>

		);

	}

}