import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {Jumbotron, Grid, Row, Col, Image, Button} from 'react-bootstrap';

export default class Home extends Component{
    render(){
        return (
            <Grid>
                <Jumbotron>
            <h2> Welcome Home </h2>
            </Jumbotron>
            <Link to="/about">
                <Button bsStyle="primary">About</Button>
            </Link>
            </Grid>
        )
    }
}