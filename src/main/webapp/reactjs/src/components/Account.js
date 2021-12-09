import React, { Component } from 'react';

import { Card, Form, Button, Row, Col } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlusSquare, faSave, faUndo } from '@fortawesome/free-solid-svg-icons';

import MyToast from './MyToast';

import axios from 'axios';

export default class Account extends Component {

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.state.show = false;
        this.accountChange = this.accountChange.bind(this);
        this.submitAccount = this.submitAccount.bind(this);
    }

    initialState = {
        accountName: '', accountNumber: '', description: '', issuingBank: '', initialBalance: ''
    }

    resetBook = () => {
        this.setState(() => this.initialState);
    }

    submitAccount = event => {
        event.preventDefault();

        const account = {
            name: this.state.accountName,
            accountNumber: this.state.accountNumber,
            description: this.state.description,
            issuingBank: this.state.issuingBank,
            initialBalance: this.state.initialBalance
        }

        axios.post("http://localhost:3030/accounts", account)
        .then(response => {
            if(response.data != null) {
                this.setState({"show": true});
                setTimeout(() => this.setState({"show": false}), 3000);
            } else {
                this.setState({"show":false});
            }
        });

        this.setState(this.initialState);
    }

    accountChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    render() {
        const { accountName, accountNumber, description, issuingBank, initialBalance } = this.state;

        return (
            <div>
                <div style={{"display": this.state.show ? "block" : "none"}}>
                    <MyToast children = {{show:this.state.show, message:"Account Saved Successfully", type: "success"}}/>
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header><FontAwesomeIcon icon={faPlusSquare} /> Add Account</Card.Header>
                    <Form onSubmit={this.submitAccount} id="accountFormId">
                        <Card.Body>
                            <Row className="mb-3">
                                <Form.Group as={Col} controlId="formGridAccountName">
                                    <Form.Label>Account Name</Form.Label>
                                    <Form.Control required autoComplete="off"
                                        type="text" name="accountName"
                                        value={accountName} onChange={this.accountChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Enter the Account Name" />
                                </Form.Group>

                                <Form.Group as={Col} controlId="formGridAccountNumber">
                                    <Form.Label>Account Number</Form.Label>
                                    <Form.Control autoComplete="off"
                                        type="text" name="accountNumber"
                                        value={accountNumber} onChange={this.accountChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Enter the Account Number" />
                                </Form.Group>
                            </Row>

                            <Form.Group className="mb-3" controlId="formGridDescription">
                                <Form.Label>Description</Form.Label>
                                <Form.Control autoComplete="off"
                                    type="text" name="description"
                                    value={description} onChange={this.accountChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Provide a short description of the account" />
                            </Form.Group>

                            <Row className="mb-3">
                                <Form.Group as={Col} controlId="formGridIssuingBank">
                                    <Form.Label>Issuing Bank</Form.Label>
                                    <Form.Control autoComplete="off"
                                        type="text" name="issuingBank"
                                        value={issuingBank} onChange={this.accountChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Enter the Issuing Bank" />
                                </Form.Group>

                                <Form.Group as={Col} controlId="formGridInitialBalance">
                                    <Form.Label>Initial Balance</Form.Label>
                                    <Form.Control required autoComplete="off"
                                        type="text" name="initialBalance"
                                        value={initialBalance} onChange={this.accountChange}
                                        className={"bg-dark text-white"}
                                        placeholder="000.00" />
                                </Form.Group>
                            </Row>
                        </Card.Body>
                        <Card.Footer style={{ "textAlign": "right" }}>
                            <Button variant="primary" type="submit">
                                <FontAwesomeIcon icon={faSave} /> Submit
                            </Button>
                            {' '}
                            <Button variant="info" type="reset">
                                <FontAwesomeIcon icon={faUndo} /> Reset
                            </Button>
                        </Card.Footer>
                    </Form>
                </Card>
            </div>
        );
    }
}