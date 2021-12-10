import React, { Component } from 'react';

import { Card, Form, Button, Row, Col } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlusSquare, faSave, faUndo, faEdit } from '@fortawesome/free-solid-svg-icons';

import MyToast from './MyToast';

import axios from 'axios';

export default class RecordTransaction extends Component {

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.state.show = false;
        this.transactionChange = this.transactionChange.bind(this);
        this.submitTransaction = this.submitTransaction.bind(this);
    };

    initialState = {
        transactionId: '',
        transactionAmount: '',
        transactionDate: '',
        transactionDetails: '',
        transactionType: '',
        inboundAccount: '',
        inboundAccountId: '',
        outboundAccount: '',
        outboundAccountId: '',
        jarName: '',
        jarId: ''
    };

    componentDidMount() {
        const accountId = +this.props.match.params.id;
        if (accountId) {
            this.findAccountById(accountId);
        }
    };

    /*findAccountById = (accountId) => {
        axios.get("http://localhost:3030/accounts/" + accountId)
            .then(response => {
                if (response.data != null) {
                    this.setState({
                        accountId: response.data.accountId,
                        accountName: response.data.accountName,
                        accountNumber: response.data.accountNumber,
                        description: response.data.description,
                        issuingBank: response.data.issuingBank,
                        balance: response.data.balanceRaw
                    });
                }

            }).catch((error) => {
                console.lerror("Error - " + error);
            });
    }*/

    resetAccount = () => {
        this.setState(() => this.initialState);
    };

    submitTransaction = event => {
        event.preventDefault();

        const transaction = {
            transactionId: this.state.transactionId,
            transactionAmount: this.state.transactionAmount,
            transactionDate: this.state.transactionDate,
            transactionDetails: this.state.transactionDetails,
            transactionType: this.state.transactionType,
            inboundAccount: this.state.inboundAccount,
            inboundAccountId: this.state.inboundAccountId,
            outboundAccount: this.state.outboundAccount,
            outboundAccountId: this.state.outboundAccountId,
            jarName: this.state.jarName,
            jarId: this.state.jarId
        }

        axios.post("http://localhost:3030/transactions", transaction)
            .then(response => {
                if (response.data != null) {
                    this.setState({ "show": true, "method": "post" });
                    setTimeout(() => this.setState({ "show": false }), 3000);
                } else {
                    this.setState({ "show": false });
                }
            });

        this.setState(this.initialState);
    };

    /*updateAccount = event => {
        event.preventDefault();

        const transaction = {
            transactionId: this.state.transactionId,
            transactionAmount: this.state.transactionAmount,
            transactionDate: this.state.transactionDate,
            transactionDetails: this.state.transactionDetails,
            transactionType: this.state.transactionType,
            inboundAccount: this.state.inboundAccount,
            inboundAccountId: this.state.inboundAccountId,
            outboundAccount: this.state.outboundAccount,
            outboundAccountId: this.state.outboundAccountId,
            jarName: this.state.jarName,
            jarId: this.state.jarId
        }

        axios.put("http://localhost:3030/accounts/" + this.state.accountId, transaction)
            .then(response => {
                if (response.data != null) {
                    this.setState({ "show": true, "method": "put" });
                    setTimeout(() => this.setState({ "show": false }), 3000);
                    setTimeout(() => this.accountList(), 3000);
                } else {
                    this.setState({ "show": false });
                }
            });

        this.setState(this.initialState);
    };*/

    transactionChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        });
    };

    /*accountList = () => {
        return this.props.history.push("/account-list");
    };*/

    render() {

        const {
            //transactionId,
            transactionAmount,
            transactionDate,
            transactionDetails,
            transactionType,
            //inboundAccount,
            inboundAccountId,
            //outboundAccount,
            outboundAccountId,
            //jarName,
            jarId 
        } = this.state;

        return (
            <div>
                <div style={{ "display": this.state.show ? "block" : "none" }}>
                    <MyToast show={this.state.show} message={this.state.method === "put" ? "Transaction Updated Succesfully" : "Transaction Recorded Successfully"} type={"success"} />
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header><FontAwesomeIcon icon={this.state.transactionId ? faEdit : faPlusSquare} /> {this.state.transactionId ? "Modify Transaction" : "Record New Transaction"}</Card.Header>
                    <Form onReset={this.resetAccount} onSubmit={this.state.transactionId ? this.updateAccount : this.submitTransaction} id="accountFormId">
                        <Card.Body>
                            <Row className="mb-3">
                                <Form.Group as={Col} controlId="formGridTransactionAmount">
                                    <Form.Label>Transaction Amount</Form.Label>
                                    <Form.Control required autoComplete="off"
                                        type="text" name="transactionAmount"
                                        value={transactionAmount} onChange={this.transactionChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Enter transaction amount" />
                                </Form.Group>

                                <Form.Group as={Col} controlId="formGridTransactionDate">
                                    <Form.Label>Date</Form.Label>
                                    <Form.Control required autoComplete="off"
                                        type="datetime" name="transactionDate"
                                        value={transactionDate} onChange={this.transactionChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Enter the transaction date" />
                                </Form.Group>
                            </Row>


                            <Form.Group className="mb-3" controlId="formGridTransactionDetails">
                                <Form.Label>Details</Form.Label>
                                <Form.Control autoComplete="off"
                                    type="text" name="transactionDetails"
                                    value={transactionDetails} onChange={this.transactionChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Provide a short description of the account" />
                            </Form.Group>

                            <Row className="mb-3">
                                <Form.Group as={Col} controlId="formGridTransactionType">
                                    <Form.Label>Type</Form.Label>
                                    <Form.Control autoComplete="off"
                                        type="text" name="transactionType"
                                        value={transactionType} onChange={this.transactionChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Enter the type" />
                                </Form.Group>
                                <Form.Group as={Col} controlId="formGridJarId">
                                    <Form.Label>Jar</Form.Label>
                                    <Form.Control autoComplete="off"
                                        type="text" name="jarId"
                                        value={jarId} onChange={this.transactionChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Withdraw from Jar.." />
                                </Form.Group>
                            </Row>
                            <Row className="mb-3">
                                <Form.Group as={Col} controlId="formGridInboundAccountId">
                                    <Form.Label>Deduct amount from: </Form.Label>
                                    <Form.Control required autoComplete="off"
                                        type="text" name="inboundAccountId"
                                        value={inboundAccountId} onChange={this.transactionChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Select Account.." />
                                </Form.Group>

                                <Form.Group as={Col} controlId="formGridOutboundAccountId">
                                    <Form.Label>Add amount to: </Form.Label>
                                    <Form.Control autoComplete="off"
                                        type="text" name="outboundAccountId"
                                        value={outboundAccountId} onChange={this.transactionChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Select Account.." />
                                </Form.Group>
                            </Row>
                        </Card.Body>
                        <Card.Footer style={{ "textAlign": "right" }}>
                            <Button size="sm" variant="primary" type="submit">
                                <FontAwesomeIcon icon={faSave} /> {this.state.accountId ? "Update" : "Save"}
                            </Button>
                            {' '}
                            <Button size="sm" variant="info" type="reset">
                                <FontAwesomeIcon icon={faUndo} /> Reset
                            </Button>
                        </Card.Footer>
                    </Form>
                </Card>
            </div>
        );
    }
}