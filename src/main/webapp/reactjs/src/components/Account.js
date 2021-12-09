import React, { Component } from 'react';

import { Card, Form, Button, Row, Col } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlusSquare, faSave } from '@fortawesome/free-solid-svg-icons';

export default class Account extends Component {

    constructor(props) {
        super(props);
        this.state = {
            accountName: '',
            accountNumber: '',
            description: '',
            issuingBank: '',
            initialAmount: ''
        };
        this.accountChange = this.accountChange.bind(this);
        this.submitAccount = this.submitAccount.bind(this);
    }

    submitAccount(event) {
        alert('Account Name: ' + this.state.accountName +
            ', Account Number: ' + this.state.accountNumber +
            ', Description: ' + this.state.description +
            ', Issuing Bank: ' + this.state.issuingBank +
            ', Initial Amount: ₱' + this.state.initialAmount
        );
        event.preventDefault();
    }

    accountChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header><FontAwesomeIcon icon={faPlusSquare} /> Add Account</Card.Header>
                <Form onSubmit={this.submitAccount} id="accountFormId">
                    <Card.Body>
                        <Row className="mb-3">
                            <Form.Group as={Col} controlId="formGridAccountName">
                                <Form.Label>Account Name</Form.Label>
                                <Form.Control required
                                    type="text" name="accountName"
                                    value={this.state.accountName}
                                    onChange={this.accountChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter the Account Name" />
                            </Form.Group>

                            <Form.Group as={Col} controlId="formGridAccountNumber">
                                <Form.Label>Account Number</Form.Label>
                                <Form.Control
                                    type="text" name="accountNumber"
                                    value={this.state.accountNumber}
                                    onChange={this.accountChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter the Account Number" />
                            </Form.Group>
                        </Row>

                        <Form.Group className="mb-3" controlId="formGridDescription">
                            <Form.Label>Description</Form.Label>
                            <Form.Control
                                type="text" name="description"
                                value={this.state.description}
                                onChange={this.accountChange}
                                className={"bg-dark text-white"}
                                placeholder="Provide a short description of the account" />
                        </Form.Group>

                        <Row className="mb-3">
                            <Form.Group as={Col} controlId="formGridIssuingBank">
                                <Form.Label>Issuing Bank</Form.Label>
                                <Form.Control
                                    type="text" name="issuingBank"
                                    value={this.state.issuingBank}
                                    onChange={this.accountChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Enter the Issuing Bank" />
                            </Form.Group>

                            <Form.Group as={Col} controlId="formGridInitialAmount">
                                <Form.Label>Initial Amount</Form.Label>
                                <Form.Control required
                                    type="text" name="initialAmount"
                                    value={this.state.initialAmount}
                                    onChange={this.accountChange}
                                    className={"bg-dark text-white"}
                                    placeholder="000.00" />
                            </Form.Group>
                        </Row>
                    </Card.Body>
                    <Card.Footer style={{ "textAlign": "right" }}>
                        <Button variant="primary" type="submit">
                            <FontAwesomeIcon icon={faSave} /> Submit
                        </Button>
                    </Card.Footer>
                </Form>
            </Card>
        );
    }
}